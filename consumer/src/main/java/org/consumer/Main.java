package org.consumer;

import org.example.service.Continent;
import org.example.service.Menu;

import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while(true){
            ServiceLoader<Menu> loaderMenu = ServiceLoader.load(Menu.class);
            var menu = loaderMenu.findFirst();
            menu.ifPresent(value -> System.out.println(value.showMenu()));
            String input = userInput();
            if(input.equalsIgnoreCase("q")){
                break;
            }

            switch (input){
                case "1" -> show("Asia");
                case "2" -> show("Europe");
            }
        }

    }

    private static String userInput() {
        while(true){
            String input = scanner.nextLine();
            try{
                if (input.equalsIgnoreCase("q"))
                    return input;
                int number = Integer.parseInt(input);
                    return validNumberToString(number);
            }catch (NumberFormatException e){
                System.out.println("Please enter a number 1-5 or 'q'!");
            }catch (IllegalArgumentException e){
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

    private static void show(String chosenContinent){
        ServiceLoader<Continent> loaderContinent = ServiceLoader.load(Continent.class);

        System.out.println("Following countries are located in " + chosenContinent + ": ");
        for (Continent continent : loaderContinent) {
            if (continent.getClass().getName().contains(chosenContinent))
                System.out.println(continent.someCountries(""));
        }
        System.out.println("Press Enter to go back to menu.");
        scanner.nextLine();
    }
}