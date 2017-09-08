package airline.datasource;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Keyuri on 09-09-2017.
 */
public class FlightsDSTest {

    @Test
    public void retrieveAllFlights(){
        Assert.assertEquals(11,FlightsDS.getAllFlights().size());
    }
}
