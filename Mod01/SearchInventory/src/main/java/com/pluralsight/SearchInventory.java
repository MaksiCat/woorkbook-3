package com.pluralsight;

import java.util.ArrayList;

public class SearchInventory {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        System.out.println("Current Inventory:");
        for (Product product : inventory) {
            System.out.println(product);
        }
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();
        inventory.add(new Product("4567", "10' 2x4 (grade B)", 9.99));
        inventory.add(new Product("1234", "Hammer", 19.49));
        inventory.add(new Product("2345", "Box of nails", 9.29));
        inventory.add(new Product("6789", "Screwdriver", 5.99));
        inventory.add(new Product("9876", "Wrench", 14.99));
        return inventory;
    }
}