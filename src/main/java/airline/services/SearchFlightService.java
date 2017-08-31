package airline.services;

import airline.DataSource;
import airline.model.FlightInformation;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keyuri on 30-08-2017.
 */
public class SearchFlightService {

    public List<FlightInformation> searchFlights(String sourceCityId, String destinationCityId) {
        List<FlightInformation> FlightInfo = DataSource.getAllFlights();
        List<FlightInformation> selectedFlights = new ArrayList<FlightInformation>();
        for (int i = 0; i < FlightInfo.size(); i++) {
            FlightInformation flight = FlightInfo.get(i);
            if (sourceCityId.equalsIgnoreCase(flight.getSourceCityId()) &&
                    destinationCityId.equalsIgnoreCase(flight.getDestinationCityId())) {
                selectedFlights.add(flight);
            }
        }

        return selectedFlights;
    }
}
