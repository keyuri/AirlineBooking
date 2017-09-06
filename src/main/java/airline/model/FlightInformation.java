package airline.model;

/**
 * Created by Keyuri on 30-08-2017.
 */

public class FlightInformation {
    private String flightNo;
    private String sourceCityId;
    private String destinationCityId;
    private int noOfAvailableSeats;
    private Airplane carrier;

    public FlightInformation(String flightNo, String sourceCityId, String destinationCityId, Airplane carrier) {
        this.flightNo = flightNo;
        this.sourceCityId = sourceCityId;
        this.destinationCityId = destinationCityId;
        this.carrier = carrier;
        noOfAvailableSeats = this.carrier.getTotalNoOfSeats();
    }

    public FlightInformation(String flightNo, String sourceCityId, String destinationCityId) {
        this.flightNo = flightNo;
        this.sourceCityId = sourceCityId;
        this.destinationCityId = destinationCityId;
    }

    public boolean areSeatsAvailable(int noOfRequestedSeats){

        return (noOfRequestedSeats <= noOfAvailableSeats)? true:false;

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
        this.noOfAvailableSeats = this.carrier.getTotalNoOfSeats();
    }
}
