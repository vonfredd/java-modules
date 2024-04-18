package org.provider;

import org.example.service.Continent;

import java.util.List;

public class NorthAmerica implements Continent {

    @Override
    public List<String> someCountries() {
        return List.of("United States", "Canada", "Mexico", "Guatemala", "Haiti");
    }
}
