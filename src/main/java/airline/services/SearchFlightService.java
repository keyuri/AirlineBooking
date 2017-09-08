package airline.services;

import airline.StringUtils;
import airline.datasource.FlightsDS;
import airline.model.Flight;
import airline.model.TravelClassType;
import airline.view.FlightPrice;
import airline.view.SearchFlightCriteria;
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

    public List<Flight> searchFlights(SearchFlightCriteria filter) {
        List<Flight> allFlights = FlightsDS.getAllFlights();
        List<Flight> selectedFlights = new ArrayList<Flight>();

        selectedFlights = allFlights.stream()
                .filter(matchSourcefilter(filter.getSourceId()))
                .filter(matchDestinationFilter(filter.getDestinationId()))
                .filter(matchSeatsFilter(filter.getTravelClass(),filter.getNoOfTravellers()))
                .filter(matchDepartureDateFilter(filter.getDepartureDate()))
                .collect(Collectors.toList());

        return selectedFlights;
    }

    public List<FlightPrice> getPriceForFlights(List<Flight> flights, SearchFlightCriteria searchFlightCriteria){
        List<FlightPrice> flightPrices = new ArrayList<FlightPrice>();
        for(Flight flight:flights){
            double pricePerPassenger = flight.getBasePriceForTravelClass(searchFlightCriteria.getTravelClass());
            double totalPrice = searchFlightCriteria.getNoOfTravellers()*pricePerPassenger;
            flightPrices.add(new FlightPrice(pricePerPassenger,totalPrice));

        }
        return flightPrices;
    }

    private Predicate<Flight> matchDepartureDateFilter(LocalDate departureDate) {
        return flightInformation -> (departureDate == null) ||  flightInformation.travelsOnDate(departureDate);
    }

    private Predicate<Flight> matchSeatsFilter(TravelClassType travelClass, int noOfTravellers) {
        return flightInformation -> travelClass == null || flightInformation.areSeatsAvailable(travelClass,noOfTravellers);
    }

    private Predicate<Flight> matchDestinationFilter(final String destinationId) {
        return flightInformation -> StringUtils.isEmptyOrNull(destinationId) || flightInformation.travelsToDestination(destinationId);
    }

    private Predicate<Flight> matchSourcefilter(final String sourceId) {
        return flight -> StringUtils.isEmptyOrNull(sourceId) || flight.startsAtSource(sourceId);
    }
}
