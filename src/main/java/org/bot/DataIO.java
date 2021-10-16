package org.bot;

import java.util.Scanner;

import static java.lang.System.out;

// todo: это интерфейс и реализация
public class DataIO {

    public static String getInputtedString() {
        var inputReader = new Scanner(System.in);
        return inputReader.nextLine();
    }

    public static void printString(String stringToPrint) {
        out.println(stringToPrint);
    }
}
