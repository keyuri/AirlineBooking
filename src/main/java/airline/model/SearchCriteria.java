package airline.model;

/**
 * Created by Keyuri on 31-08-2017.
 */
public class SearchCriteria {

    private Location source;
    private Location destination;
    private int noOfTravellers;


    public SearchCriteria() {
        source = Location.DEFAULT;
        destination = Location.DEFAULT;
    }


    public int getNoOfTravellers() {
        return noOfTravellers;
    }

    public void setNoOfTravellers(int noOfTravellers) {
        this.noOfTravellers = noOfTravellers;
    }

    public String getSource() {
        return source.getId();
    }


    public String getDestination() {
        return destination.getId();
    }


    public void setSource(Location source) {
        this.source = source;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }
}
