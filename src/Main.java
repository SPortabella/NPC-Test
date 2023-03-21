import clases.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static utils.MenuUtils.showMainMenu;
import static utils.ScanUtils.askForInt;
import static utils.ScanUtils.askForString;
import static utils.UtilsFile.*;


public class Main {


    public static void main(String[] args) {

        List<String> lista = ReadFile("play.txt");

        List<NPC> npcList = new ArrayList<>();

        if (lista.size() == 0)
            createNPC(npcList);
        else
            ProcessFile(lista, npcList);

        npcList.stream().forEach(npc -> System.out.println(npc));

        Boolean exit = false;

        try {
            do {
                try {
                    int option = showMainMenu();
                    switch (option) {
                        case 1:
                           //1- Consultar los los ítems de un vendedor.
                            Integer number = askForInt("Select:\n 1-Farmer\n 2-Thief \n 3-Merchant\n");
                            if (number == 1)
                            npcList.stream().filter(npc -> npc instanceof Farmer)
                                    .forEach(npc -> npc.showItems());
                            else if (number == 2) {
                                npcList.stream().filter(npc -> npc instanceof Thief)
                                        .forEach(npc -> npc.showItems());
                            } else  {
                                npcList.stream().filter(npc -> npc instanceof Merchant)
                                        .forEach(npc -> npc.showItems());
                            }
                            break;
                        case 2:
                            //2- Consultar los vendedores que hay en una ciudad.
                            String city = askForString("Insert city?");
                            npcList.stream().filter(npc -> npc.getCity().equals(city)).forEach(System.out::println);
                            break;
                        case 3:
                            //3- Mostrar el ítems más barato de todos los vendedores de una ciudad ->lambdas
                            break;
                        case 4:
                            //4- Mostrar todos los ítems de un determinado tipo ordenados por precio (asc)
                            break;
                        case 5:
                            //5- Simular la compra de un ítem a un NPC.
                            break;
                        case 6:
                            exit = true;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Incorrect option");
                            break;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Incorrect option");
                }
            } while (!exit);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bye!!!");
        }
    }

    private static void createNPC(List<NPC> npcList) {
        String cityFarmer = askForString("Insert city of new Farmer?");
        Farmer farmer = new Farmer(cityFarmer);
        farmer.addItem(new Item("item1", "type1", 150.0, 3.0));
        farmer.addItem(new Item("item2", "type1", 150.0, 3.0));
        farmer.addItem(new Item("item3", "type1", 150.0, 3.0));
        farmer.addItem(new Item("item4", "type1", 150.0, 3.0));
        farmer.addItem(new Item("item5", "type1", 150.0, 3.0));
        npcList.add(farmer);

        String cityThief = askForString("Insert city of new Thief?");
        Thief thief = new Thief(cityThief);
        thief.addItem(new Item("item1", "type1", 150.0, 3.0));
        thief.addItem(new Item("item2", "type1", 150.0, 3.0));
        thief.addItem(new Item("item3", "type1", 150.0, 3.0));
        npcList.add(thief);

        String cityMerchant = askForString("Insert city of new Merchant?");
        Merchant merchant = new Merchant(cityMerchant);
        merchant.addItem(new Item("item1", "type1", 150.0, 3.0));
        merchant.addItem(new Item("item2", "type1", 150.0, 3.0));
        merchant.addItem(new Item("item3", "type1", 150.0, 3.0));
        merchant.addItem(new Item("item4", "type1", 150.0, 3.0));
        merchant.addItem(new Item("item5", "type1", 150.0, 3.0));
        merchant.addItem(new Item("item6", "type1", 150.0, 3.0));
        merchant.addItem(new Item("item7", "type1", 150.0, 3.0));
        npcList.add(merchant);
    }

    private static List<Item> initItems() {
        List<Item> itemlist = new ArrayList<>();
        itemlist.add(new Item("item1", "type1", 150.0, 3.0));
        itemlist.add(new Item("item2", "type1", 100.0, 2.0));
        itemlist.add(new Item("item3", "type1", 300.0, 5.0));
        itemlist.add(new Item("item4", "type1", 500.0, 0.0));
        itemlist.add(new Item("item5", "type1", 100.0, 3.5));
        itemlist.add(new Item("item6", "type1", 200.0, 10.0));

        return itemlist;
    }

}
