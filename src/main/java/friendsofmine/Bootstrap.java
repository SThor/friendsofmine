package friendsofmine;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Utilisateur;
import friendsofmine.service.InitialisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by 21301646 on 01/03/2017.
 */
@Component
public class Bootstrap {
    @Autowired
    InitialisationService initialisationService;

    @PostConstruct
    void init() {
        initialisationService.initDonnees();
    }

    public List<Utilisateur> getUtilisateurs() {
        return initialisationService.getUtilisateurs();
    }

    public List<Activite> getActivites() {
        return initialisationService.getActivites();
    }
}
