package clases;

import interfaces.iNPC;

import java.util.ArrayList;
import java.util.List;

public class Farmer extends NPC implements iNPC {

    private int NUM_MAX_ITEMS = 5;

    //List<Item> items;

    public Farmer(String city) {
        super(city);
        items = new ArrayList<>(NUM_MAX_ITEMS);
    }

    public void addItem(Item item) {
        //checkFarmerSize();
        this.items.add(item);
    }

    private void checkFarmerSize() throws Exception {
        if (items.size() >= NUM_MAX_ITEMS) {
            throw new Exception("!");
        }
    }

    public Farmer() {
        }

        @Override
        public String toString () {
            return "Farmer{" + getCity() + "\n" +
                    "items=" + items +
                    '}';
        }

        @Override
        public void sendItem () {
        }

        @Override
        public void buyItem () {

        }
    }
