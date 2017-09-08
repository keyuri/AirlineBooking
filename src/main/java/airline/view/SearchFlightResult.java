package airline.view;

import airline.model.FlightInformation;

/**
 * Created by Keyuri on 09-09-2017.
 */
public class SearchFlightResult {
    private FlightInformation flight;
    private FlightPrice flightPrice;

    public SearchFlightResult(FlightInformation availableFlight, FlightPrice flightPrice) {
        this.flight = availableFlight;
        this.flightPrice = flightPrice;
    }

    public FlightInformation getFlight() {
        return flight;
    }

    public FlightPrice getFlightPrice() {
        return flightPrice;
    }
}
