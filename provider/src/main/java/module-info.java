import org.example.service.Continent;
import org.example.service.Menu;
import org.provider.Asia;
import org.provider.Europe;
import org.provider.MenuImpl;

module provider {
    requires service;
    provides Continent with Asia, Europe;
    provides Menu with MenuImpl;
}