package clases;

import java.util.ArrayList;
import java.util.List;

public class NPC {
    private String city;

    List<Item> items;

    public void showItems () {
        items.stream().forEach(System.out::println);
    }
    public NPC(String city) {
        this.city = city;
    }

    public NPC() {
    }

    public void addItem(Item item ){
        items.add(item);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "city=" + city + "\n" + items;
    }
}
