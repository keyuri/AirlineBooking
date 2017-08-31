package airline.model;

/**
 * Created by Keyuri on 30-08-2017.
 */

public class FlightInformation {
    private String flightNo;
    private String sourceCityId;
    private String destinationCityId;

    public FlightInformation(String iFlightNo, String inputSourceId, String inputDestinationId) {
        flightNo = iFlightNo;
        sourceCityId = inputSourceId;
        destinationCityId = inputDestinationId;
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
}
