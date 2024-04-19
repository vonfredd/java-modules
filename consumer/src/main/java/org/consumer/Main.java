package org.consumer;

import org.example.service.Continent;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ServiceLoader<Continent> continents = ServiceLoader.load(Continent.class);
        var listOfContinents = new ArrayList<Continent>();
        continents.forEach(listOfContinents::add);
        int input = 0;

        while (input != -1) {
            menu(listOfContinents);
            input = inputFromUser(listOfContinents.size());
            if (input == -1) {
                break;
            }
            var m = listOfContinents.get(input);
            System.out.printf("""
                    Located in %s:
                    """, m.simpleName());
            listOfContinents.get(input).someCountries().forEach(System.out::println);
            System.out.println("Press 'Enter' to go back..");
            scanner.nextLine();
        }
    }

    private static int inputFromUser(int numberOfContinents) {
        while(true) {
            String input = scanner.nextLine();
            try {
                if (input.equalsIgnoreCase("Q")) {
                    return -1;
                }
                int i = Integer.parseInt(input);
                if (i >= numberOfContinents || i < 0)
                    throw new ArrayIndexOutOfBoundsException();
                return i;
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input");
            }
        }
    }

    private static void menu(ArrayList<Continent> listOfContinents) {
        System.out.println("""
                                
                Pick a number to display
                some countries on that continent
                ________________________________
                """);

        for (int i = 0; i < listOfContinents.size(); i++) {
            System.out.println(i + ". " + listOfContinents.get(i).simpleName());
            if (i == listOfContinents.size() - 1) {
                System.out.println("""
                        'Q'. Quit
                        ________________________________
                        """);
            }
        }
    }
}