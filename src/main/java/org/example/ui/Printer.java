package org.example.ui;

public class Printer {
    public static void printMenu(String[] items) {
        for (int i = 0; i < items.length; i++) {
            System.out.println(i + 1 + " " + items[i]);
        }
    }

    public static void printMsg(String msg) {
        System.out.println("****" + msg + "****");
    }
}
