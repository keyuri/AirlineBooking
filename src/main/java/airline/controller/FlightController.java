package airline.controller;

import airline.datasource.LocationDS;
import airline.model.Flight;
import airline.view.FlightPrice;
import airline.view.SearchFlightCriteria;
import airline.model.TravelClassType;
import airline.services.SearchFlightService;
import airline.view.SearchFlightResult;
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
    public String searchFlights(@ModelAttribute("searchCriteria") SearchFlightCriteria searchCriteria, Model model) {
        List<Flight> flights = searchFlightService.searchFlights(searchCriteria);
        List<FlightPrice> flightPrices = searchFlightService.getPriceForFlights(flights,searchCriteria);
        List<SearchFlightResult> searchResults = new ArrayList<>();
        for (int counter = 0; counter < flights.size(); counter++) {
            searchResults.add(new SearchFlightResult(flights.get(counter),
                                                        flightPrices.get(counter)));
        }


        model.addAttribute("searchCriteria", new SearchFlightCriteria());
        model.addAttribute("cityList", LocationDS.getLocations());
        model.addAttribute("travelClassTypes", TravelClassType.values());
        model.addAttribute("searchResults",searchResults);
        if(searchResults.size() > 0)
            model.addAttribute("gotresults", true);
        else
            model.addAttribute("gotresults", false);

        return "flightSearch";
    }

    @RequestMapping(value = {"/","/search"}, method = RequestMethod.GET)
    public String getLocations(Model model) {
        model.addAttribute("cityList", LocationDS.getLocations());
        model.addAttribute("travelClassTypes", TravelClassType.values());
        model.addAttribute("searchCriteria", new SearchFlightCriteria());
        //model.addAttribute("searchResults",new ArrayList<>());
        return "flightSearch";
    }
}
