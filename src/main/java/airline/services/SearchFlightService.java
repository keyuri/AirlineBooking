package airline.services;

import airline.StringUtils;
import airline.datasource.FlightsDS;
import airline.model.FlightInformation;
import airline.model.SearchCriteria;
import airline.model.TravelClassType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Keyuri on 30-08-2017.
 */
@Service
public class SearchFlightService {

    public List<FlightInformation> searchFlights(SearchCriteria filter) {
        List<FlightInformation> allFlights = FlightsDS.getAllFlights();
        List<FlightInformation> selectedFlights = new ArrayList<FlightInformation>();

        selectedFlights = allFlights.stream()
                .filter(matchSourcefilter(filter.getSourceId()))
                .filter(matchDestinationFilter(filter.getDestinationId()))
                .filter(matchSeatsFilter(filter.getTravelClass(),filter.getNoOfTravellers()))
                .filter(matchDepartureDateFilter(filter.getDepartureDate()))
                .collect(Collectors.toList());

        return selectedFlights;
    }

    private Predicate<FlightInformation> matchDepartureDateFilter(LocalDate departureDate) {
        return flightInformation -> (departureDate == null) ||  flightInformation.travelsOnDate(departureDate);
    }

    private Predicate<FlightInformation> matchSeatsFilter(TravelClassType travelClass, int noOfTravellers) {
        return flightInformation -> travelClass == null || flightInformation.areSeatsAvailable(travelClass,noOfTravellers);
    }

    private Predicate<FlightInformation> matchDestinationFilter(final String destinationId) {
        return flightInformation -> StringUtils.isEmptyOrNull(destinationId) || flightInformation.travelsToDestination(destinationId);
    }

    private Predicate<FlightInformation> matchSourcefilter(final String sourceId) {
        return flight -> StringUtils.isEmptyOrNull(sourceId) || flight.startsAtSource(sourceId);
    }
}
