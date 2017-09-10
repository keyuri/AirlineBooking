package airline.datasource;

import airline.model.Location;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * Created by Keyuri on 31-08-2017.
 */
public class LocationDS {

    private static List<Location> locationList = null;

    public static List<Location> getLocations() {

        if(locationList != null)
            return locationList;

        locationList = new ArrayList<Location>();
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

    public static Location getLocation(String cityId) {
            if(locationList == null)
                getLocations();

        for(Location location : locationList){
            if(location.getId().equalsIgnoreCase(cityId)) return location;
        }

        return null;
    }
}
