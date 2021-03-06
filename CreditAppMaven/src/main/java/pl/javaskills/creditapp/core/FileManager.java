package pl.javaskills.creditapp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    private static final Logger log = LoggerFactory.getLogger(LoanApplication.class);
    private static final Path HOME_DIR = Paths.get(Constants.OUTPUT_PATH);
    private static final Path SELF_EMPLOYED_DIR = HOME_DIR.resolve("self-employed");
    private static final Path NATURAL_PERSON_DIR = HOME_DIR.resolve("natural-person");

    public void write(ProcessedCreditApplication creditApplication) throws IOException {
        Path personIdDir = getPersonDir(creditApplication);

        if (Files.notExists(personIdDir)) {
            Files.createDirectory(personIdDir);
        }

        Path appIdFile = personIdDir.resolve(creditApplication.getLoanApplication().getId() + ".dat");
        if (Files.notExists(appIdFile)) {
            Files.createFile(appIdFile);
        }

        try (ByteArrayOutputStream byteAOS = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(byteAOS)) {
            out.writeObject(creditApplication);
            Files.write(appIdFile, byteAOS.toByteArray());
            log.info(String.format("Application with id %s succesfully saved", creditApplication.getLoanApplication().getId()));
        }
    }

    //w tych 2 metodach lepiej if -else if i na końcu wyrzucić wyjątek, a nie if else samo
    private Path getPersonDir(ProcessedCreditApplication creditApplication) {
        return creditApplication.getLoanApplication().isNaturalPerson() ?
                NATURAL_PERSON_DIR.resolve(((NaturalPerson) creditApplication.getLoanApplication().getPerson()).getPesel()) :
                SELF_EMPLOYED_DIR.resolve(((SelfEmployed) creditApplication.getLoanApplication().getPerson()).getNip());

    }

    private Path getPersonDir(String personId) {
        String id = personId.replace("N-", "").replace("S-", "");
        return personId.startsWith("N-") ?
                NATURAL_PERSON_DIR.resolve(id) :
                SELF_EMPLOYED_DIR.resolve(id);
    }

    public ProcessedCreditApplication read(String appId, String personId) throws IOException, ClassNotFoundException {
        Path personIdDir = getPersonDir(personId);
        Path appIdFile = personIdDir.resolve(appId + ".dat");

        if (Files.exists(appIdFile)) {

            try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(Files.readAllBytes(appIdFile)))) {
                log.info(String.format("Application with id %s succesfully saved", appId));
                return (ProcessedCreditApplication) in.readObject();
            }
        } else {
            log.info(String.format("File %s not found", appId));
            throw new IllegalStateException(String.format("File %s not found", appId));
        }

    }


    public void init() throws IOException {

        if (Files.notExists(HOME_DIR)) {
            Files.createDirectory(HOME_DIR);
        }

        if (Files.notExists(SELF_EMPLOYED_DIR)) {
            Files.createDirectory(SELF_EMPLOYED_DIR);
        }

        if (Files.notExists(NATURAL_PERSON_DIR)) {
            Files.createDirectory(NATURAL_PERSON_DIR);
        }

    }
}