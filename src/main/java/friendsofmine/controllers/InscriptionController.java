package friendsofmine.controllers;

import friendsofmine.Bootstrap;
import friendsofmine.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 21301646 on 16/03/2017.
 */
@RestController
@RequestMapping("/api/inscription")
public class InscriptionController {
    @Autowired
    Bootstrap bootstrap;
    @Autowired
    InscriptionService inscriptionService;

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void deleteInscription(@PathVariable Long id) {
        inscriptionService.deleteInscription(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    void
}
