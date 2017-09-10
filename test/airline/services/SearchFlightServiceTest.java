package airline.services;

import airline.model.Flight;
import airline.model.TravelClassType;
import airline.view.SearchFlightCriteria;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.time.LocalDate;
import java.util.List;

/**
 * Created by Keyuri on 09-09-2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = SearchFlightService.class)
public class SearchFlightServiceTest {
    @Autowired
    SearchFlightService searchFlightService;

    SearchFlightCriteria searchFlightCriteria;


    @Before
    public void initialize(){
        searchFlightCriteria = new SearchFlightCriteria();
        searchFlightCriteria.setNoOfTravellers(1);
    }

    @Test
    public void searchFlightsHydToPun(){
        searchFlightCriteria.setSourceId("HYD");
        searchFlightCriteria.setDestinationId("PUN");
        List<Flight> availableFlights = searchFlightService.searchFlights(searchFlightCriteria);
        Assert.assertEquals(1,availableFlights.size());
    }

    @Test
    public void searchFlightsHydToPunWithDepartureDate(){
        searchFlightCriteria.setSourceId("HYD");
        searchFlightCriteria.setDestinationId("PUN");
        searchFlightCriteria.setDepartureDate(LocalDate.now().withMonth(9).withDayOfMonth(21).withYear(2017));
        List<Flight> availableFlights = searchFlightService.searchFlights(searchFlightCriteria);
        Assert.assertEquals(1,availableFlights.size());
    }

    @Test
    public void searchFlightsHydToBlrWithTravelClass(){
        searchFlightCriteria.setSourceId("HYD");
        searchFlightCriteria.setDestinationId("BLR");
        searchFlightCriteria.setTravelClass(TravelClassType.BUSINESS);
        List<Flight> availableFlights = searchFlightService.searchFlights(searchFlightCriteria);
        Assert.assertEquals(1,availableFlights.size());
    }


}
