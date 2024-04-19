package org.provider;

import org.example.service.Continent;
import org.example.service.Direction;
import org.example.service.Hemisphere;

import java.util.List;

@Hemisphere(Direction.SOUTH)
public class Africa implements Continent {
    @Override
    public List<String> someCountries() {
        return List.of("Nigeria", "Egypt", "South Africa", "Kenya", "Ethiopia", "Tanzania");
    }

    @Override
    public String simpleName() {
        return "Africa";
    }
}
