package org.provider;

import org.example.service.Continent;
import org.example.service.Direction;
import org.example.service.Hemisphere;

import java.util.List;

@Hemisphere({Direction.NORTH,Direction.WEST})
public class NorthAmerica implements Continent {
    @Override
    public List<String> someCountries() {
        return List.of("United States", "Canada", "Mexico", "Guatemala", "Haiti");
    }

    @Override
    public String simpleName() {
        return "North America";
    }
}
