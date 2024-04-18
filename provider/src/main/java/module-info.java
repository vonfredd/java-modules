import org.example.service.Continent;
import org.example.service.Menu;
import org.provider.*;

module provider {
    requires service;
    provides Continent with Asia, Europe, NorthAmerica, SouthAmerica, Africa;
    provides Menu with MenuImpl;
}