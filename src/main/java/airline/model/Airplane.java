package airline.model;

/**
 * Created by Keyuri on 06-09-2017.
 */
public class Airplane {
    private String id;
    private String model;
    private int totalNoOfSeats;

    public Airplane(String id, String model, int totalNoOfSeats) {
        this.id = id;
        this.model = model;
        this.totalNoOfSeats = totalNoOfSeats;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getTotalNoOfSeats() {
        return totalNoOfSeats;
    }
}
