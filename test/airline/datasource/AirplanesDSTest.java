package airline.datasource;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Keyuri on 09-09-2017.
 */
public class AirplanesDSTest {

    @Test
    public void retrieveAirplanesList(){
        Assert.assertEquals(3,AirplanesDS.getAllPlanes().size());
    }
}
