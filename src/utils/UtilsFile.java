package utils;

import clases.Farmer;
import clases.Item;
import clases.NPC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UtilsFile {


    private static final int NUMFARMERITEMS = 5;
    public final int NUMTHIEFITEMS = 3;
    public final int NUMMARCHANTITEMS = 7;

    public static List<NPC> ProcessFile(List<String> lista, List<NPC> npcList) {
        if (lista.size() == 0)
            initnpcList(npcList);
        else {
            for (String str : lista) {
                String[] parts = str.split(";");
                List<Item> items = readItems(parts);
                switch (parts[0]) {
                    case "FARMER":
                        Farmer farmer = new Farmer(parts[1]);
                        for (Item item : items) {
                            farmer.addItem(item);
                        }
                        npcList.add(farmer);
                    case "THIEF":
                    case "MERCHANT":
                }
            }
        }
        return npcList;
    }


    private static void initnpcList(List<NPC> npcList) {
        npcList.add (new NPC()); //farmer
        npcList.add (new NPC()); //thief
        npcList.add (new NPC()); //marchant
    }

    private static List<Item> readItems(String[] parts) {
        List<Item> items = new ArrayList<>();
        for (int i = 2; i < parts.length; i++) {
            String[] cadena = parts[i].split("-");
            String name = cadena[0];
            String type = cadena[1];
            Double price = Double.valueOf(cadena[2]);
            Double wastage = Double.valueOf(cadena[3]);

            Item item = new Item(name, type, price, wastage);

            items.add(item);

        }
        return null;
    }


    public static List<String> ReadFile(String nomFile) {

        String pathDirectory = "C:\\Users\\Susana\\Documents\\GitHub\\Exercices\\ExamenSPM\\";

        List<String> lista = new ArrayList<>();

        File file;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            file = new File(pathDirectory + nomFile);
            if (file.exists()) {
                fr = new FileReader(file);
                br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    lista.add(linea);
                }

            }
            else {
                file.createNewFile();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return lista;
    }

}
