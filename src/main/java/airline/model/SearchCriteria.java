package airline.model;

import javafx.util.converter.LocalDateStringConverter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Created by Keyuri on 31-08-2017.
 */
public class SearchCriteria {

    private String sourceId;
    private String destinationId;
    private int noOfTravellers;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;
    private TravelClassType travelClass;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }


    public void setDepartureDate(LocalDate departureDate) {
       this.departureDate = departureDate;
    }

    public TravelClassType getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(TravelClassType travelClass) {
        this.travelClass = travelClass;
    }

    public int getNoOfTravellers() {
        return noOfTravellers;
    }

    public void setNoOfTravellers(int noOfTravellers) {
        this.noOfTravellers = noOfTravellers;
    }


}
