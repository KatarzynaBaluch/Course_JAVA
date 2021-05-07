package Sekcja15_StrumieniePliki;

import java.io.*;
import java.nio.charset.Charset;

public class StrumienieZnakowMain {
    public static void main(String[] args) {
        String projectPath = "C:\\Users\\User\\OneDrive - Politechnika Śląska\\Dokumenty\\JAVA\\Projekt_JAVA\\src";

        System.out.println(Charset.defaultCharset()); //UTF-8 - domyslne kodowanie

        //UWAGA! nie da się odczytać znaków do wrirer "*.jpeg" - tylko jako plik tekstowy
        //w konstruktorze można podać też kodowanie

        try (Reader in = new FileReader(projectPath + "\\bee.jpeg");
             Writer out = new FileWriter(projectPath + "\\bee.txt", Charset.forName("UTF-8"))) {
            int chunk;
            while ((chunk = in.read()) != -1) {
                out.write(chunk);
                System.out.println(chunk);
            }
        } catch (IOException e) {

        }

    }
}
