package org.consumer;

import org.example.service.Continent;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ServiceLoader<Continent> continents = ServiceLoader.load(Continent.class);

        HashSet<String> m = new HashSet<>();

        var listOfContinents = new ArrayList<Continent>();
        continents.forEach(listOfContinents::add);

        int input = 0;
        applicationLoop(input, listOfContinents);
    }

    private static void applicationLoop(int input, ArrayList<Continent> listOfContinents) {
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
        while (true) {
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

    private static void menuBuilder(StringBuilder sb, int i, int size, ArrayList<Continent> listOfContinents) {
        if (i == size)
            return;
        sb.append(i)
                .append(". ")
                .append(listOfContinents
                        .get(i).simpleName())
                .append("\n");
        menuBuilder(sb, i + 1, size, listOfContinents);
    }

    private static void menu(ArrayList<Continent> listOfContinents) {
        StringBuilder sb = new StringBuilder();
        menuBuilder(sb, 0, listOfContinents.size(), listOfContinents);
        System.out.printf("""
                ________________________________
                Pick a number to display
                some countries on that continent
                ________________________________
                %s
                'Q'. Quit
                ________________________________
                %n""", sb);

    }
}