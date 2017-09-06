package airline.model;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Keyuri on 31-08-2017.
 */
public class SearchCriteria {

    private String sourceCityId;
    private String destCityId;
    private int noOfTravellers;


    public SearchCriteria() {
        sourceCityId = "DEFAULT";
        destCityId = "DEFAULT";
    }


    public int getNoOfTravellers() {
        return noOfTravellers;
    }

    public void setNoOfTravellers(int noOfTravellers) {
        this.noOfTravellers = noOfTravellers;
    }

    public String getSourceCityId() {
        return sourceCityId;
    }

    public void setSourceCityId(String sourceCityId) {
        this.sourceCityId = sourceCityId;
    }

    public String getDestCityId() {
        return destCityId;
    }

    public void setDestCityId(String destCityId) {
        this.destCityId = destCityId;
    }
}
