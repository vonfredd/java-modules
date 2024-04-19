package org.provider;

import org.example.service.Continent;
import org.example.service.Direction;
import org.example.service.Hemisphere;

import java.util.List;

@Hemisphere({Direction.NORTH,Direction.EAST})
public class Asia implements Continent {
    @Override
    public List<String> someCountries() {
        return List.of("China", "Mongolia", "Thailand", "Japan", "India", "Indonesia", "Pakistan", "Bangladesh");
    }

    @Override
    public String simpleName() {
        return "Asia";
    }
}
