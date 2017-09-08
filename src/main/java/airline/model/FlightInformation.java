package airline.model;

import java.time.LocalDate;

/**
 * Created by Keyuri on 30-08-2017.
 */

public class FlightInformation {
    private String flightNo;
    private String sourceCityId;
    private String destinationCityId;
    private LocalDate departureDate;
    private Airplane carrier;

    public FlightInformation(String flightNo,
                             String sourceCityId,
                             String destinationCityId){
        this.flightNo = flightNo;
        this.sourceCityId = sourceCityId;
        this.destinationCityId = destinationCityId;
    }


    public FlightInformation(String flightNo,
                             String sourceCityId,
                             String destinationCityId,
                             LocalDate departureDate,
                             Airplane carrier) {
        this.flightNo = flightNo;
        this.sourceCityId = sourceCityId;
        this.destinationCityId = destinationCityId;
        this.departureDate = departureDate;
        this.carrier = carrier;
    }

    public boolean startsAtSource(String sourceId) {
        return this.sourceCityId.equalsIgnoreCase(sourceId);
    }

    public boolean travelsToDestination(String destinationId) {
        return this.destinationCityId.equalsIgnoreCase(destinationId);
    }

    public boolean areSeatsAvailable(TravelClassType travelClass, int noOfRequestedSeats) {
        return carrier.areSeatsAvailable(travelClass, noOfRequestedSeats);
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getSourceCityId() {
        return sourceCityId;
    }

    public String getDestinationCityId() {
        return destinationCityId;
    }

    public void setCarrier(Airplane airplane) {
        this.carrier = airplane;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public boolean travelsOnDate(LocalDate departureDate) {
        return this.departureDate.isEqual(departureDate);
    }
}
