package org.consumer;

import org.example.service.Continent;

import java.util.List;
import java.util.ServiceLoader;

public class Presentation {

    private Presentation() {
    }

    protected static void show(String chosenContinent) {
        ServiceLoader<Continent> loaderContinent = ServiceLoader.load(Continent.class);
        System.out.println("Following countries are located in " + chosenContinent + ": ");

        for (Continent continent : loaderContinent) {
            if (continent.getClass().getName().contains(chosenContinent))
                printCountries(continent.someCountries());
        }
        System.out.println("""
                ___________________________________
                Press Enter to go back to menu..
                """);
    }

    protected static void show() {
        System.out.println("""
                ___________________________________
                Not implemented yet...
                """);
    }

    private static void printCountries(List<String> strings) {
        strings.forEach(System.out::println);
    }
}
