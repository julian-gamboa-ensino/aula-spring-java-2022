package laboratorio._1.jpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PendingController {

    @GetMapping("/pending")
    public ModelAndView pending() {
        return new ModelAndView("pending/index"); 
    }
}
