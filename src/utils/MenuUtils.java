package utils;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUtils {

    public static Integer showMainMenu() {

        Scanner sc = new Scanner(System.in);
        int integer  = 0;
        boolean ok = false;
        do {
            try {
                System.out.println("Menu Principal:");
                System.out.println("1. Consultar los los ítems de un vendedor.");
                System.out.println("2- Consultar los vendedores que hay en una ciudad");
                System.out.println("3- Mostrar el ítems más barato de todos los vendedores de una ciudad");
                System.out.println("4- Mostrar todos los ítems de un determinado tipo ordenados por precio");
                System.out.println("5- Simular la compra de un ítem a un NPC");
                System.out.println("6. Exit");

                integer = sc.nextInt();
                ok = true;
            } catch (InputMismatchException ex) {
                System.out.println("ERROR. Input type mismatch\n");
            }
            sc.nextLine();
        } while (!ok);
        return integer;
    }
    public static Integer showNPCMenu() {
        String cad = "";
        cad += "Menu NPC: \n";
        cad += "1. Menu Farmer\n";
        cad += "2. Menu Thief\n";
        cad += "3. Menu Merchant\n";
        cad += "4. Salir\n\n";
        Integer option = Integer.parseInt(JOptionPane.showInputDialog(cad));

        return option;
    }
}
