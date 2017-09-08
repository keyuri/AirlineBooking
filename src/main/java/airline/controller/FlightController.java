package airline.controller;

import airline.datasource.LocationDS;
import airline.model.FlightInformation;
import airline.model.SearchCriteria;
import airline.model.TravelClassType;
import airline.services.SearchFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajashrk on 8/8/17.
 */
@Controller
public class FlightController {

    @Autowired
    SearchFlightService searchFlightService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchFlights(@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, Model model) {
        List<FlightInformation> flights = searchFlightService.searchFlights(searchCriteria);
        model.addAttribute("searchCriteria", new SearchCriteria());
        model.addAttribute("cityList", LocationDS.getLocations());
        model.addAttribute("travelClassTypes", TravelClassType.values());
        model.addAttribute("flights", flights);
        return "flightSearch";
    }

    @RequestMapping(value = {"/","/search"}, method = RequestMethod.GET)
    public String getLocations(Model model) {
        model.addAttribute("cityList", LocationDS.getLocations());
        model.addAttribute("travelClassTypes", TravelClassType.values());
        model.addAttribute("searchCriteria", new SearchCriteria());
        model.addAttribute("flights",new ArrayList<>());
        return "flightSearch";
    }
}
