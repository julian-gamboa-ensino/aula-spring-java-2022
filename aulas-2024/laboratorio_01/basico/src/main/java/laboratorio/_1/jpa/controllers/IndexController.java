package laboratorio._1.jpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "views/index"; // Retorna o arquivo index.html em templates/
    }
}

