package Sekcja10_WyjatkiIAseracje.Try_catch_finally;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainTryResources {
    public static void main(String[] args) {

        //dla klas implementujących interfejs AutoCloseable
        //Java automatycznie zamknie zasób (plik, połączenie bazodanowe, scanner ...)
        //można w takim try więcej niż jeden zadeklarować
        try (FileWriter fileWriter = new FileWriter("test.txt");
             Scanner scanner = new Scanner(System.in);
             DataBaseMenager dataBaseMenager=new DataBaseMenager()) {
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
