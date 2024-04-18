package org.consumer;

import org.example.service.Menu;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            ServiceLoader<Menu> loaderMenu = ServiceLoader.load(Menu.class);
            var menu = loaderMenu.findFirst();
            menu.ifPresent(value -> System.out.println(value.showMenu()));
            String input = userInput();
            if (input.equalsIgnoreCase("q")) {
                break;
            }

            switch (input) {
                case "1" -> Presentation.show("Asia");
                case "2" -> Presentation.show("Europe");
                case "3" -> Presentation.show("NorthAmerica");
                case "4" -> Presentation.show("SouthAmerica");
                case "5" -> Presentation.show("Africa");
                default -> Presentation.show();
            }
            scanner.nextLine();
        }
    }

    private static String userInput() {
        while (true) {
            String input = scanner.nextLine();
            try {
                if (input.equalsIgnoreCase("q"))
                    return input;
                int number = Integer.parseInt(input);
                return validNumberToString(number);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number 1-5 or 'q'!");
            } catch (IllegalArgumentException e) {
                System.out.println("Only single numbers 1-5 or 'q'!");
            }
        }
    }
    private static String validNumberToString(int number) {
        if (number >= 1 && number <= 5) {
            return String.valueOf(number);
        }
        throw new IllegalArgumentException();
    }
}