package org.provider;

import org.example.service.Menu;

public class MenuImpl implements Menu {
    @Override
    public String showMenu() {
        return """
                Pick a number.
                Based on what continent you choose,
                a list of countries in that region
                will be returned.
                ___________________________________
                
                1.  Asia
                2.  Europe
                3.  North America
                4.  South America
                5.  Africa
                ___________________________________
                Q.  Quit
                """;
    }
}
