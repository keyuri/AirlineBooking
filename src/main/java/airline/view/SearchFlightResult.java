package airline.view;

import airline.model.Flight;

/**
 * Created by Keyuri on 09-09-2017.
 */
public class SearchFlightResult {
    private Flight flight;
    private FlightPrice flightPrice;

    public SearchFlightResult(Flight availableFlight, FlightPrice flightPrice) {
        this.flight = availableFlight;
        this.flightPrice = flightPrice;
    }

    public Flight getFlight() {
        return flight;
    }

    public FlightPrice getFlightPrice() {
        return flightPrice;
    }
}
