package airline.controller;

import airline.DataSource;
import airline.model.FlightInformation;
import airline.services.SearchFlightService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rajashrk on 8/8/17.
 */
@Controller
@SpringBootApplication
public class FlightController {

    // @Autowired
    // private SearchFlightService searchFlightService;

    public static void main(String[] args) {
        SpringApplication.run(FlightController.class, args);
    }

    /*@RequestMapping("/")
    public String welcomeMessage() {
        return "flightSearch";
    }
*/

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchFlights(@RequestParam("fromCityId") String fromCityId,
                                @RequestParam("toCityId") String toCityId,
                                Model model) {
        List<FlightInformation> flights = new SearchFlightService().searchFlights(fromCityId.toUpperCase().trim(), toCityId.toUpperCase().trim());
        model.addAttribute("flights", flights);
        return "flightList";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getLocations(Model model) {
        model.addAttribute("cityList", DataSource.getLocations());
        return "flightSearch";
    }
}
