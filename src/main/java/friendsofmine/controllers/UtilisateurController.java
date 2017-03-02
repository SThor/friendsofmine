package friendsofmine.controllers;

import friendsofmine.Bootstrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 21301646 on 01/03/2017.
 */
@Controller
public class UtilisateurController {
    @Autowired
    Bootstrap bootstrap;

    @RequestMapping(value = "/utilisateurs", method = RequestMethod.GET)
    String list(Model model) {
        model.addAttribute("utilisateurs", bootstrap.getUtilisateurs());
        return "utilisateurs";
    }
}
