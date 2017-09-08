package airline.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Keyuri on 06-09-2017.
 */
public class Airplane {
    private String id;
    private String modelDescription;
    private int totalNoOfSeats;
    Map<TravelClassType,ClassPriceModel> travelClassMap;

    public Airplane(String id, String model, int totalNoOfSeats) {
        this.id = id;
        this.modelDescription = model;
        this.totalNoOfSeats = totalNoOfSeats;
    }

    public Airplane(String id, String modelDesc) {
        this.id = id;
        this.modelDescription = modelDesc;
    }

    public void addTravelClass(TravelClassType classType,ClassPriceModel classPriceModel){
        if(travelClassMap == null)
            travelClassMap = new HashMap<TravelClassType,ClassPriceModel>();
        travelClassMap.put(classType,classPriceModel);
    }

    public String getId() {
        return id;
    }

    public String getModelDescription() {
        return modelDescription;
    }

    public int getTotalNoOfSeats() {
        return totalNoOfSeats;
    }

    public boolean areSeatsAvailable(TravelClassType travelClass, int noOfRequestedSeats) {
        return travelClassMap.get(travelClass).getAvailableSeats() >= noOfRequestedSeats;

    }

    public double getBasePriceForClass(TravelClassType travelClass) {
        return travelClassMap.get(travelClass).getBasePrice();
    }
}
