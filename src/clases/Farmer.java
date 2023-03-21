package clases;

import interfaces.iNPC;

import java.util.ArrayList;
import java.util.List;

public class Farmer extends NPC implements iNPC {


    public Farmer(String city) {
        super(city);
        List<Item> items = new ArrayList<>(5);
    }

    public Farmer() {
    }

    @Override
    public String toString() {
        return "Farmer{" + getCity() + "\n" +
                "items=" + items +
                '}';
    }

    @Override
    public void sendItem() {
    }

    @Override
    public void buyItem() {

    }
}
