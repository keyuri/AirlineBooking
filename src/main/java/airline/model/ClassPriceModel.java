package airline.model;

/**
 * Created by Keyuri on 08-09-2017.
 */
public class ClassPriceModel {

    private int noOfTotalSeats;
    private int noOfAvailableSeats;
    private double basePrice;


    public ClassPriceModel(int noOfTotalSeats,  double basePrice) {
        this.noOfTotalSeats = noOfTotalSeats;
        this.noOfAvailableSeats = this.noOfTotalSeats;
        this.basePrice = basePrice;
    }

    public int getAvailableSeats() {
        return noOfAvailableSeats;
    }
}
