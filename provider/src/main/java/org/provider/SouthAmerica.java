package org.provider;

import org.example.service.Continent;
import org.example.service.Direction;
import org.example.service.Hemisphere;

import java.util.List;

@Hemisphere({Direction.SOUTH,Direction.WEST})
public class SouthAmerica implements Continent {
    @Override
    public List<String> someCountries() {
        return List.of("Brazil", "Argentina", "Peru", "Colombia", "Venezuela", "Chile", "Ecuador");
    }

    @Override
    public String simpleName() {
        return "South America";
    }
}
