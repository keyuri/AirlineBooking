package airline.datasource;

import airline.model.FlightInformation;
import airline.model.Location;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * Created by Keyuri on 31-08-2017.
 */
public class LocationDS {

    public static List<Location> locationList;
    public static List<FlightInformation> flightList;

    public static List<Location> getLocations() {

        List<Location> locationList = new ArrayList<Location>();
        try {
            Properties locations = new Properties();
            locations.load(LocationDS.class.getResourceAsStream("/locations.properties"));
            Enumeration enumeration = locations.keys();
            while (enumeration.hasMoreElements()) {
                String locationId = (String) enumeration.nextElement();
                locationList.add(new Location(locationId, locations.getProperty(locationId)));

            }
        } catch (java.io.IOException e) {

        }

        return locationList;
    }


}
