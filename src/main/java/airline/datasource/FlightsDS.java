package airline.datasource;

import airline.model.Airplane;
import airline.model.Flight;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keyuri on 06-09-2017.
 */
public class FlightsDS {

    private static List<Flight> flightList = null;

    public static List<Flight> getAllFlights() {

        if (flightList == null) {
            flightList = new ArrayList<Flight>();

            List<Airplane> planeList = AirplanesDS.getAllPlanes();
            try {
                URL url = LocationDS.class.getResource("/flightsDB.csv");
                CSVReader reader = new CSVReader(new FileReader(url.getFile()));
                String[] line;
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                while ((line = reader.readNext()) != null) {
                    Flight flight = new Flight(line[0], line[1], line[2]);
                    flight.setDepartureDate(LocalDate.parse(line[3],dateTimeFormatter));
                    flight.setCarrier(planeList.get((int) reader.getLinesRead() % 3));
                    flightList.add(flight);
                }
            } catch (IOException e) {
                generateDummyData(flightList);
            }
        }

        return flightList;
    }

    private static void generateDummyData(List<Flight> flightList) {
        List<Airplane> planeList = AirplanesDS.getAllPlanes();
        LocalDate deptDate = ZonedDateTime.parse("09-09-2017").toLocalDate();
        flightList.add(new Flight("AI0010", "DEL", "BOM",deptDate, planeList.get(0)));
        flightList.add(new Flight("BA1123", "HYD", "PUN", deptDate,planeList.get(1)));
        flightList.add(new Flight("AI0030", "HYD", "BLR",deptDate, planeList.get(2)));
        flightList.add(new Flight("AI0031", "HYD", "BOM",deptDate, planeList.get(0)));
        flightList.add(new Flight("AI0032", "HYD", "DEL",deptDate, planeList.get(1)));
        flightList.add(new Flight("AI0040", "BLR", "HYD",deptDate, planeList.get(2)));
        flightList.add(new Flight("AI0042", "BLR", "PUN",deptDate, planeList.get(0)));
        flightList.add(new Flight("AI0045", "BLR", "DEL",deptDate, planeList.get(0)));
        flightList.add(new Flight("AI0046", "BLR", "BOM",deptDate, planeList.get(1)));
        flightList.add(new Flight("AI0050", "PUN", "BOM",deptDate, planeList.get(2)));
        flightList.add(new Flight("AI0052", "PUN", "BLR",deptDate, planeList.get(1)));
        flightList.add(new Flight("AI0060", "DEL", "BOM",deptDate, planeList.get(0)));
    }

}
