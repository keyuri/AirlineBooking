package airline.services;

import airline.datasource.FlightsDS;
import airline.datasource.LocationDS;
import airline.model.FlightInformation;
import airline.model.SearchCriteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keyuri on 30-08-2017.
 */
public class SearchFlightService {

    public List<FlightInformation> searchFlights(SearchCriteria filter) {
        List<FlightInformation> allFlights = FlightsDS.getAllFlights();
        List<FlightInformation> selectedFlights = new ArrayList<FlightInformation>();

        for(FlightInformation flight : allFlights){

            if (flight.getSourceCityId().equalsIgnoreCase(filter.getSourceCityId()) &&
                    flight.getDestinationCityId().equalsIgnoreCase(filter.getDestCityId())
                    && flight.areSeatsAvailable(filter.getNoOfTravellers())) {
                selectedFlights.add(flight);
            }
        }

        return selectedFlights;
    }
}
