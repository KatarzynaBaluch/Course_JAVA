package pl.javaskills.creditapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.client.CreditApplicationReader;
import pl.javaskills.creditapp.client.DummyCreditApplicationReader;
import pl.javaskills.creditapp.client.FileCreditApplicationReader;
import pl.javaskills.creditapp.core.*;
import pl.javaskills.creditapp.core.bik.BikApi;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.scoring.*;
import pl.javaskills.creditapp.core.validation.*;
import pl.javaskills.creditapp.core.validation.reflection.*;
import pl.javaskills.creditapp.di.ClassInitializer;
import pl.javaskills.creditapp.integration.BikApiAdapter;

import java.nio.file.*;
import java.sql.Time;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    static {
        TimeZone.setDefault(TimeZone.getTimeZone(Constants.DEFAULT_SYSTEM_ZONE_ID));
        Locale.setDefault(Constants.DEFAULT_LOCALE);
    }

    public static void main(String[] args) throws Exception {


        CreditApplicationReader reader = new DummyCreditApplicationReader();

        List<FieldAnnotationProcessor> fieldProcessors = List.of(new NotNullAnnotationProcessor(), new RegexAnnotationProcessor());
        List<ClassAnnotationProcessor> classProcessors = List.of(new ExactlyOneNotNullAnnotationProcessor());
        ObjectValidator objectValidator = new ObjectValidator(fieldProcessors, classProcessors);

        CompoundPostValidator compoundPostValidator = new CompoundPostValidator(new PurposeOfLoanPostValidator(), new ExpensesPostValidator());

        ClassInitializer classInitializer = new ClassInitializer();
        classInitializer.registerInstance(compoundPostValidator);
        classInitializer.registerInstance(objectValidator);
        classInitializer.registerInstance(new BikScoringCalculator(new BikApiAdapter()));

        CreditApplicationMenager menager = (CreditApplicationMenager) classInitializer.createInstance(CreditApplicationMenager.class);

        menager.init();


        if (args != null && args.length == 2 && args[1].matches("[NS]-\\d*")) {
            System.out.println("main if");
            String appId = args[0];
            String personID = args[1];
            menager.loadApplication(appId, personID);
        } else
            {

            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path homeDir = Paths.get(Constants.OUTPUT_PATH);
            homeDir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
            WatchKey watchKey;
            while ((watchKey = watchService.take()) != null) {
                log.info("New event fired");
                for (WatchEvent event : watchKey.pollEvents()) {
                    log.info("New file detected {}", event.context());
                    if (event.context().toString().endsWith(".json")) {
                        Path pathToFile = homeDir.resolve(event.context().toString());

                        //processing
                       final LoanApplication loanApplication= new FileCreditApplicationReader(pathToFile).read();
                       loanApplication.init();
                       menager.add(loanApplication);

                        Files.deleteIfExists(pathToFile);
                    } else {
                        log.info("File processing skipped ", event.context());
                    }
                }
                menager.startProcessing();
                watchKey.reset();
            }


        }

    }
}
