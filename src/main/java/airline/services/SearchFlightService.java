package airline.services;

import airline.StringUtils;
import airline.datasource.FlightsDS;
import airline.model.FlightInformation;
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

    public List<FlightInformation> searchFlights(SearchFlightCriteria filter) {
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

    public List<FlightPrice> getPriceForFlights(List<FlightInformation> flights,SearchFlightCriteria searchFlightCriteria){
        List<FlightPrice> flightPrices = new ArrayList<FlightPrice>();
        for(FlightInformation flight:flights){
            double pricePerPassenger = flight.getBasePriceForTravelClass(searchFlightCriteria.getTravelClass());
            double totalPrice = searchFlightCriteria.getNoOfTravellers()*pricePerPassenger;
            flightPrices.add(new FlightPrice(pricePerPassenger,totalPrice));

        }
        return flightPrices;
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
