package lesson4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex2 {
    static int size;

    public static List<Item> allItems;
    public static Backpack backpack;

    private static double bestSumPrice = -999;

    public static void main(String[] args) throws IOException {

        allItems = new ArrayList<>();

        allItems.add(new Item("Аптечка", 4, 1500));
        allItems.add(new Item("Бинокль", 2, 5000));
        allItems.add(new Item("Ноутбук", 2, 40000));
        allItems.add(new Item("Книга", 1, 600));
        allItems.add(new Item("Котелок", 1, 500));

        backpack = new Backpack(5);

        size = allItems.size();

        getAllVariantsItems(size);

        backpack.getItems().forEach((value) -> System.out.println(value));

    }

    public static void getAllVariantsItems(int newSize) {
        if (newSize == 1)

            return;

        for (int i = 0; i < newSize; i++) {
            getAllVariantsItems(newSize - 1);

            if (newSize == 2)

                putMostExpInBackpack();

            rotateArr(newSize);
        }
    }

    public static void putMostExpInBackpack() {
        List<Item> items = new ArrayList<>();

        countPriceOfItms(items, 0, true, 0, 0);
    }

    public static void countPriceOfItms(List<Item> mostCostsItems, int startIndex, boolean isHead, double sumWeight, double sumPrice) {
        for (int i = startIndex; i < allItems.size(); i++) {
            if (isHead) {
                mostCostsItems = new ArrayList<>();
                sumWeight = 0;
                sumPrice = 0;
            }

            if (sumWeight + allItems.get(i).weight > backpack.getWeight()) continue;

            mostCostsItems.add(allItems.get(i));
            sumWeight += allItems.get(i).getWeight();
            sumPrice += allItems.get(i).getPrice();

            countPriceOfItms(mostCostsItems, i + 1, false, sumWeight, sumPrice);

            if (sumPrice > bestSumPrice) {
                bestSumPrice = sumPrice;
                backpack.setItems(new ArrayList<>(mostCostsItems));
            }
        }
    }

    public static void rotateArr(int newSize) {
        int i;
        int pos = size - newSize;

        Item temp = allItems.get(pos);

        for (i = pos + 1; i < size; i++) {
            allItems.set(i - 1, allItems.get(i));
        }

        allItems.set(i - 1, temp);
    }

    public static class Backpack {
        private double weight;
        public List<Item> items = new ArrayList<>();

        public Backpack(double weight) {
            this.weight = weight;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            Collections.sort(items, Comparator.comparing(Item::getPrice));

            this.items = items;
        }

        public double getWeight() {
            return weight;
        }
    }

    public static class Item {
        private String name;
        private double weight, price;

        public Item(String name, double weight, double price) {
            this.name = name;
            this.weight = weight;
            this.price = price;
        }

        public double getWeight() {
            return weight;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return String.format("%s %.1f %.0f", name, weight, price);
        }
    }

}
