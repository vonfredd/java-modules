package org.provider;

import org.example.service.Continent;

import java.util.List;

public class Europe implements Continent {
    @Override
    public List<String> someCountries(String continent) {
        return List.of("Sweden","Denmark","Germany","Netherlands","United Kingdom","France","Finland","Spain");
    }
}
