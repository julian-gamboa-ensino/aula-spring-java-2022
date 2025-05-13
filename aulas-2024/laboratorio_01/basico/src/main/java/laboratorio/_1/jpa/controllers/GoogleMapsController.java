package laboratorio._1.jpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GoogleMapsController {

    @GetMapping("/google-maps")
    public ModelAndView googleMaps() {
        return new ModelAndView("google-maps/index"); 
    }
}
