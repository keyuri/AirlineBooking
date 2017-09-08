package airline;

import airline.datasource.AirplanesDS;
import airline.model.Airplane;
import airline.model.FlightInformation;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keyuri on 06-09-2017.
 */
public class FlightsDS {

    private static List<FlightInformation> flightList = null;

    public static List<FlightInformation> getAllFlights() {

        if (flightList == null) {
            flightList = new ArrayList<FlightInformation>();

            List<Airplane> planeList = AirplanesDS.getAllPlanes();
            try {
                URL url = LocationDS.class.getResource("/flightsDB.csv");
                CSVReader reader = new CSVReader(new FileReader(url.getFile()));
                String[] line;
                while ((line = reader.readNext()) != null) {
                    FlightInformation flight = new FlightInformation(line[0], line[1], line[2]);
                    flight.setDepartureDate(ZonedDateTime.parse(line[3]).toLocalDate());
                    flight.setCarrier(planeList.get((int) reader.getLinesRead() % 3));
                    flightList.add(flight);
                }
            } catch (IOException e) {
                generateDummyData(flightList);
            }
        }

        return flightList;
    }

    private static void generateDummyData(List<FlightInformation> flightList) {
        List<Airplane> planeList = AirplanesDS.getAllPlanes();
        LocalDate deptDate = ZonedDateTime.parse("09-09-2017").toLocalDate();
        flightList.add(new FlightInformation("AI0010", "DEL", "BOM",deptDate, planeList.get(0)));
        flightList.add(new FlightInformation("BA1123", "HYD", "PUN", deptDate,planeList.get(1)));
        flightList.add(new FlightInformation("AI0030", "HYD", "BLR",deptDate, planeList.get(2)));
        flightList.add(new FlightInformation("AI0031", "HYD", "BOM",deptDate, planeList.get(0)));
        flightList.add(new FlightInformation("AI0032", "HYD", "DEL",deptDate, planeList.get(1)));
        flightList.add(new FlightInformation("AI0040", "BLR", "HYD",deptDate, planeList.get(2)));
        flightList.add(new FlightInformation("AI0042", "BLR", "PUN",deptDate, planeList.get(0)));
        flightList.add(new FlightInformation("AI0045", "BLR", "DEL",deptDate, planeList.get(0)));
        flightList.add(new FlightInformation("AI0046", "BLR", "BOM",deptDate, planeList.get(1)));
        flightList.add(new FlightInformation("AI0050", "PUN", "BOM",deptDate, planeList.get(2)));
        flightList.add(new FlightInformation("AI0052", "PUN", "BLR",deptDate, planeList.get(1)));
        flightList.add(new FlightInformation("AI0060", "DEL", "BOM",deptDate, planeList.get(0)));
    }

}
