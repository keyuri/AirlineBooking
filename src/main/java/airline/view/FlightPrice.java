package airline.view;

/**
 * Created by Keyuri on 09-09-2017.
 */
public class FlightPrice {
    private double pricePerPassenger;
    private double totalPrice;

    public FlightPrice(double pricePerPassenger, double totalPrice) {
        this.pricePerPassenger = pricePerPassenger;
        this.totalPrice = totalPrice;
    }

    public double getPricePerPassenger() {
        return pricePerPassenger;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
