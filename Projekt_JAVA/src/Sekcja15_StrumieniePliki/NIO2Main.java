package Sekcja15_StrumieniePliki;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;

public class NIO2Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //NIO2 API - Non-Blockieng Input Output



        String path=System.getProperty("user.dir"); //skrót do pobrania ścieżki głównej projektu, w którym jesteśmy
        System.out.println(path);
        File file=new File(path);

        //nowe NIO2 Api
        Path homePath= Paths.get(path);
        System.out.println(homePath);

        boolean isExist=Files.exists(homePath);
        System.out.println(isExist); //true

        //tworzenie nowego foldeu
        Path dataDir=homePath.resolve("data"); //dodanie nowego elementu do path
        if(Files.notExists(dataDir)) {
            Files.createDirectory(dataDir); //tworzenie nowego folderu w katalogu
        }

        //tworzenie nowego pliku
        Path newFilePath=homePath.resolve("xyz.txt");
        if(Files.notExists(newFilePath))
        {
            Files.createFile(newFilePath);
        }

        //zapis do pliku
        Files.writeString(newFilePath, "Ala ma kota", Charset.defaultCharset());

        //kopiowanie pliku
        Path newFilePath2=homePath.resolve("xyz-copy.txt");
        Files.copy(newFilePath, newFilePath2, StandardCopyOption.REPLACE_EXISTING);

        //kopiowanie pliku do OutputStream
        Path newFilePath3=homePath.resolve("xyz-copy2.txt");
        try(OutputStream outputStream=Files.newOutputStream(newFilePath3)) { //strumień, więc try/try with resources
            Files.copy(newFilePath, outputStream);
            outputStream.write(" plus dopisane coś".getBytes());
        }

        //kopiowanie ...
        Path newFile4=homePath.resolve("xyz-copy3.txt");
        try(final BufferedWriter bufferedWriter=Files.newBufferedWriter(newFilePath3)) {
            bufferedWriter.write("qwertyuiopsdfghjk");
        }

        //obiekt - plik
        Path personFile1=dataDir.resolve("person1.dat");

        //zapis
        try(ByteArrayOutputStream bos=new ByteArrayOutputStream();
            ObjectOutputStream oos=new ObjectOutputStream(bos))
        {
            oos.writeObject(new Person("John", 23,"Shmith"));
            byte[] byteObject = bos.toByteArray();
            Files.write(personFile1, byteObject);
        }


        //odczyt
        try(ByteArrayInputStream bis=new ByteArrayInputStream(Files.readAllBytes(personFile1));
            ObjectInputStream oos=new ObjectInputStream(bis))
        {
          Person person=(Person) oos.readObject();
            System.out.println(person);
        }


        //--------------------------------------
        //watch service - nasłuchiwanie
        WatchService service=FileSystems.getDefault().newWatchService();
        dataDir.register(service, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE); //o czym chcemy byc informowani

        WatchKey watchKey;
        while ((watchKey=service.take())!=null)
        {
            //jesli utworzymy plik, to od razu zostanie usuniety
            for(WatchEvent watchEvent: watchKey.pollEvents())
            {
                System.out.println(String.format("%s - %s", watchEvent.kind(), watchEvent.context()));
                Path pathToFile = dataDir.resolve(watchEvent.context().toString());
                System.out.println(pathToFile);
                Files.deleteIfExists(pathToFile);
            }
            watchKey.reset(); //"właczenie" dalszego nasluchowania
        }


    }
}
