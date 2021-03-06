package friendsofmine.controllers;

import friendsofmine.Bootstrap;
import friendsofmine.domain.Activite;
import friendsofmine.domain.Inscription;
import friendsofmine.domain.Utilisateur;
import friendsofmine.service.ActiviteService;
import friendsofmine.service.InscriptionService;
import friendsofmine.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    ActiviteService activiteService;

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public HttpStatus deleteInscription(@PathVariable Long id) {
        inscriptionService.deleteInscription(id);
        return HttpStatus.OK;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Inscription getInscription(@PathVariable Long id) {
        Inscription inscription = inscriptionService.findOneInscription(id);
        if (inscription == null) {
            throw new ResourceNotFoundException();
        }
        return inscription;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Inscription> postInscription(@RequestParam Long utilisateur_id, @RequestParam Long activite_id) {
        Utilisateur utilisateur = utilisateurService.findOneUtilisateur(utilisateur_id);
        Activite activite = activiteService.findOneActivite(activite_id);
        Inscription inscription = inscriptionService.saveInscription(new Inscription(utilisateur, activite, null));
        return new ResponseEntity<>(inscription, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public Page<Inscription> search(@RequestParam(required = false) String nom_utilisateur, @RequestParam(required = false) String titre_activite, Pageable pageable) {
        if (nom_utilisateur != null && titre_activite != null) {
            return inscriptionService.findByUtilisateurActivite(nom_utilisateur, titre_activite, pageable);
        } else if (nom_utilisateur != null) {
            return inscriptionService.findByUtilisateur(nom_utilisateur, pageable);
        } else if (titre_activite != null) {
            return inscriptionService.findByActivite(titre_activite, pageable);
        }
        return inscriptionService.findAll(pageable);
    }
}
