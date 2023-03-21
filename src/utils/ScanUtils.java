package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScanUtils {
    public static String askForString(String message) {

        Scanner sc = new Scanner(System.in);
        String cadena  = "";
        boolean ok = false;
        do {
            System.out.println(message);
            try {
                cadena = sc.nextLine();
                ok = true;
            } catch (InputMismatchException ex) {
                System.out.println("ERROR. Input type mismatch\n");
            }
        } while (!ok);
        return cadena;
    }
    public static int askForInt(String message) {

        Scanner sc = new Scanner(System.in);
        int integer  = 0;
        boolean ok = false;
        do {
            System.out.println(message);
            try {
                integer = sc.nextInt();
                ok = true;
            } catch (InputMismatchException ex) {
                System.out.println("ERROR. Input type mismatch\n");
            }
        } while (!ok);
        return integer;
    }
}
