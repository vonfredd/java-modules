package org.provider;

import org.example.service.Continent;
import org.example.service.Direction;
import org.example.service.Hemisphere;

import java.util.List;

@Hemisphere({Direction.NORTH,Direction.EAST})
public class Europe implements Continent {
    @Override
    public List<String> someCountries() {
        return List.of("Sweden","Denmark","Germany","Netherlands","United Kingdom","France","Finland","Spain");
    }

    @Override
    public String simpleName() {
        return "Europe";
    }
}
