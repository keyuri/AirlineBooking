package airline;

import airline.model.Airplane;
import airline.model.ClassPriceModel;
import airline.model.TravelClassType;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keyuri on 06-09-2017.
 */
public class AirplanesDS {

    private static List<Airplane> airplaneList = null;

    public static List<Airplane> getAllPlanes() {

        if (airplaneList == null) {
            airplaneList = new ArrayList<Airplane>();

            try {
                URL url = LocationDS.class.getResource("/planesDB.csv");
                CSVReader reader = new CSVReader(new FileReader(url.getFile()));
                String[] line;
                while ((line = reader.readNext()) != null) {
                    Airplane plane = new Airplane(line[0], line[1]);
                    for (int counter = 2; counter < line.length; counter += 3)
                        plane.addTravelClass(TravelClassType.valueOf(line[counter]),
                                new ClassPriceModel(Integer.parseInt(line[counter + 1]),
                                        Double.parseDouble(line[counter + 2])));

                    airplaneList.add(plane);
                }
            } catch (IOException e) {
                generateDummyData(airplaneList);
            }
        }

        return airplaneList;
    }

    private static void generateDummyData(List<Airplane> planeList) {
        Airplane plane1 = new Airplane("BOEING777", "BOEING777");
        plane1.addTravelClass(TravelClassType.FIRST, new ClassPriceModel(8, 20000.0));
        plane1.addTravelClass(TravelClassType.BUSINESS, new ClassPriceModel(35, 13000.0));
        plane1.addTravelClass(TravelClassType.ECONOMY, new ClassPriceModel(195, 6000.0));
        planeList.add(plane1);

        Airplane plane2 = new Airplane("AIRBUSA319", "AIRBUSA319");
        plane2.addTravelClass(TravelClassType.ECONOMY, new ClassPriceModel(144, 4000.0));
        planeList.add(plane2);

        Airplane plane3 = new Airplane("AIRBUSA321", "AIRBUSA321");
        plane3.addTravelClass(TravelClassType.BUSINESS, new ClassPriceModel(20, 10000.0));
        plane3.addTravelClass(TravelClassType.ECONOMY, new ClassPriceModel(152, 5000.0));
        planeList.add(plane3);

    }

}
