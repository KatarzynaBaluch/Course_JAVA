package Sekcja15_StrumieniePliki;

import java.io.*;

public class StrumienieBinarneMain {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\User\\OneDrive - Politechnika Śląska\\Dokumenty\\JAVA\\Projekt_JAVA"); //to moze byc tez sciezka do folderu, niekoniecznie plik

        System.out.println(file.exists()); //true
        filesList(file);

        //______________________________________
        File fileToDelete = new File("C:\\Users\\User\\OneDrive - Politechnika Śląska\\Dokumenty\\JAVA\\Projekt_JAVA\\to_delete.txt");
        if (fileToDelete.exists()) {
            fileToDelete.delete();
        }

        //_______________________________________
        File beeFile = new File("C:\\Users\\User\\OneDrive - Politechnika Śląska\\Dokumenty\\JAVA\\Projekt_JAVA\\src\\bee.jpeg");
        InputStream in = null;
        OutputStream out = null;
        try {

            //InputStream i OutputStream to abstrakcyjne, dlatego potrzebyjemy implementacji
            //w konstruktorze implementacji przekazujemy File lub path (pod spodem wtedyutworzy File)
            in = new FileInputStream(beeFile);
            out = new FileOutputStream("C:\\Users\\User\\OneDrive - Politechnika Śląska\\Dokumenty\\JAVA\\Projekt_JAVA\\src\\bee-copy.jpeg");

            int chunk;
            while ((chunk = in.read()) != -1) {
                out.write(chunk);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }

        //--------------------------------------

        // żeby nie robićzagnieżdżonego try catch, to można try with resouurces

        //jesli plik istnieje to FileOutputStream nadpisze go
        try (
                InputStream in2 = new FileInputStream("C:\\Users\\User\\OneDrive - Politechnika Śląska\\Dokumenty\\JAVA\\Projekt_JAVA\\src\\input.txt");
                OutputStream out2 = new FileOutputStream("C:\\Users\\User\\OneDrive - Politechnika Śląska\\Dokumenty\\JAVA\\Projekt_JAVA\\src\\output.txt");
        ) {
            int chunk2;
            while ((chunk2 = in2.read()) != -1) {
                out2.write(chunk2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void filesList(File file) {
        for (String filename : file.list()) {

            String pathFir = file.getPath() + "\\" + filename;
            System.out.println(pathFir);
            File fileDir = new File(pathFir);
            if (fileDir.isDirectory()) {
                filesList(fileDir);
            }

        }
    }
}
