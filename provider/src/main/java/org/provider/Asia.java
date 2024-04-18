package org.provider;

import org.example.service.Continent;

import java.util.List;

public class Asia implements Continent {
    @Override
    public List<String> someCountries() {
        return List.of("China", "Mongolia", "Thailand", "Japan", "India", "Indonesia", "Pakistan", "Bangladesh");
    }
}
