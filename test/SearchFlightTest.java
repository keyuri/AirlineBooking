import airline.model.FlightInformation;
import airline.services.SearchFlightService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Keyuri on 31-08-2017.
 */
public class SearchFlightTest {
    @Test
    public void testFlightsForSourcetoDestionation(){
        SearchFlightService service = new SearchFlightService();
        List<FlightInformation> selectedFlights = service.searchFlights("DEL","BOM");
        Assert.assertEquals(1,selectedFlights.size());

    }
}
