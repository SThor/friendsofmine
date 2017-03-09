package friendsofmine.controllers;

import friendsofmine.Bootstrap;
import friendsofmine.service.ActiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 21301646 on 02/03/2017.
 */
@Controller
public class ActiviteController {
    @Autowired
    Bootstrap bootstrap;
    @Autowired
    ActiviteService activiteService;

    @RequestMapping(value = "/activites", method = RequestMethod.GET)
    String list(Model model) {
        model.addAttribute("activites", activiteService.findAllActivites());
        return "activites";
    }
}
