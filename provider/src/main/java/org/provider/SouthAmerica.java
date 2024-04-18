package org.provider;

import org.example.service.Continent;

import java.util.List;

public class SouthAmerica implements Continent {
    @Override
    public List<String> someCountries() {
        return List.of("Brazil", "Argentina", "Peru", "Colombia", "Venezuela", "Chile", "Ecuador");
    }
}
