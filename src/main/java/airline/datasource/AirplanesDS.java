package airline.datasource;

import airline.model.Airplane;
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

    public static List<Airplane> getAllPlanes() {


        List<Airplane> airplaneList = new ArrayList<Airplane>();

        try {
            URL url = LocationDS.class.getResource("/planesDB.csv");
            CSVReader reader = new CSVReader(new FileReader(url.getFile()));
            String[] line;
            while ((line = reader.readNext()) != null) {
                airplaneList.add(new Airplane(line[0], line[1], Integer.parseInt(line[2])));

            }
        } catch (IOException e) {
            generateDummyData(airplaneList);
        }

        return airplaneList;
    }

    private static void generateDummyData(List<Airplane> planeList) {
        planeList.add(new Airplane("BOEING747", "BOEING747", 10));
        planeList.add(new Airplane("BOEING777", "BOEING777", 20));
        planeList.add(new Airplane("AIRBUSA319", "AIRBUS A319 V2", 30));
        planeList.add(new Airplane("AIRBUSA321", "AIRBUS A321", 40));
    }

}
