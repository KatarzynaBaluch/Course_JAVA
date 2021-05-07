package Sekcja15_StrumieniePliki;

import java.io.*;
import java.nio.charset.Charset;

public class StrumienieBuforowaneMain {
    public static void main(String[] args) {

        String projectPath = "C:\\Users\\User\\OneDrive - Politechnika Śląska\\Dokumenty\\JAVA\\Projekt_JAVA\\src";
        int size = 8 * 1024; //i bd 8 razy mniej "przejsc" - odczytu i zapisu
        //_________________________________

        try (
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(projectPath + "\\input.txt"), size);
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(projectPath + "\\output.txt"), size);
        ) {
            int chunk;
            while ((chunk = in.read()) != -1) {
                out.write(chunk);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //_________________________________

        try (BufferedReader in = new BufferedReader(new FileReader(projectPath + "\\bee.jpeg"), size);
             BufferedWriter out = new BufferedWriter(new FileWriter(projectPath + "\\bee.txt"), size)) {
            {
                //tu mnożna czytać po całej linijce
                String chunk;

                //tu warunek wyjścia null, a nie -1
                while ((chunk = in.readLine()) != null) {
                    out.write(chunk);
                    System.out.println(chunk);
                }
            }
        } catch (IOException e) {

        }
    }
}
