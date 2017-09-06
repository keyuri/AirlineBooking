package airline.controller;

import airline.datasource.LocationDS;
import airline.model.FlightInformation;
import airline.model.SearchCriteria;
import airline.services.SearchFlightService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by rajashrk on 8/8/17.
 */
@Controller
@SpringBootApplication
public class FlightController {

     public static void main(String[] args) {
        SpringApplication.run(FlightController.class, args);
    }

    /*@RequestMapping("/")
    public String welcomeMessage() {
        return "flightSearch";
    }
*/

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchFlights(@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, Model model) {
        List<FlightInformation> flights = new SearchFlightService().searchFlights(searchCriteria);
        model.addAttribute("flights", flights);
        return "flightList";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getLocations(Model model) {
        model.addAttribute("cityList", LocationDS.getLocations());
        model.addAttribute("searchCriteria", new SearchCriteria());
        return "flightSearch";
    }
}
