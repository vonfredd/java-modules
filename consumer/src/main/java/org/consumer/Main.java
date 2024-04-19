package org.consumer;

import org.example.service.Continent;
import org.example.service.Direction;
import org.example.service.Hemisphere;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ServiceLoader<Continent> continents = ServiceLoader.load(Continent.class);
        var listOfContinents = new ArrayList<Continent>();
        continents.forEach(listOfContinents::add);
        int input = 0;
        applicationLoop(input, listOfContinents);
    }

    private static void applicationLoop(int input, ArrayList<Continent> listOfContinents) {
        List<Direction> directionList = getAllDirections(listOfContinents);
        while (input != -1) {
            menu(listOfContinents);
            input = inputFromUser(directionList.size());
            if (input == -1) {
                break;
            }
            var chosenDirection = directionList.get(input);

            System.out.println("In the " + chosenDirection + " hemisphere we find:\n");
            for (Continent listOfContinent : listOfContinents) {
                Direction[] directionsValue = listOfContinent.getClass().getAnnotation(Hemisphere.class).value();
                for (Direction direction : directionsValue) {
                    if (direction.equals(chosenDirection)) {
                        System.out.println(String.join(",", listOfContinent.someCountries()));
                    }
                }
            }
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

    private static void menu(ArrayList<Continent> listOfContinents) {
        menuBuilderVG(getAllDirections(listOfContinents));
    }

    private static List<Direction> getAllDirections(ArrayList<Continent> listOfContinents) {
        Set<Direction> setOfDirections = new HashSet<>();
        for (Continent listOfContinent : listOfContinents) {
            Direction[] directionsValue = listOfContinent.getClass().getAnnotation(Hemisphere.class).value();
            setOfDirections.addAll(Arrays.asList(directionsValue));
        }
        return new ArrayList<>(setOfDirections);
    }

    private static void menuBuilderVG(List<Direction> ListOfDirections) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (Direction direction : ListOfDirections) {
            sb.append(++counter).append(". ").append(direction).append("\n");
        }
        System.out.printf("""
                ________________________________
                Pick a number to display
                some countries located in
                that Hemisphere.
                ________________________________
                %s
                'Q'. Quit
                ________________________________
                %n""", sb);
    }
}