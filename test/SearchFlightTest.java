import airline.model.FlightInformation;
import airline.view.SearchFlightCriteria;
import airline.services.SearchFlightService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Keyuri on 31-08-2017.
 */
public class SearchFlightTest {
    @Test
    public void testFlightsForSourcetoDestination() {
        SearchFlightService service = new SearchFlightService();
        SearchFlightCriteria filter = new SearchFlightCriteria();
        filter.setSourceId("DEL");
        filter.setDestinationId("BOM");
        List<FlightInformation> selectedFlights = service.searchFlights(filter);
        Assert.assertEquals(1, selectedFlights.size());

    }
}
