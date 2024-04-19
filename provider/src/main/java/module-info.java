import org.example.service.Continent;
import org.provider.*;

module provider {
    requires service;
    provides Continent with Asia, Europe, NorthAmerica, SouthAmerica, Africa;
}