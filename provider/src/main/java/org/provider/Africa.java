package org.provider;

import org.example.service.Continent;

import java.util.List;

public class Africa implements Continent {
    @Override
    public List<String> someCountries() {
        return List.of("Nigeria", "Egypt", "South Africa", "Kenya", "Ethiopia", "Tanzania");
    }
}
