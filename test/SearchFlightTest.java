import airline.model.FlightInformation;
import airline.model.SearchCriteria;
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
        SearchCriteria filter = new SearchCriteria();
        filter.setSourceCityId("DEL");
        filter.setDestCityId("BOM");
        List<FlightInformation> selectedFlights = service.searchFlights(filter);
        Assert.assertEquals(1,selectedFlights.size());

    }
}
