package friendsofmine.service;

import friendsofmine.domain.Activite;
import friendsofmine.repositories.ActiviteRepository;
import friendsofmine.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by 21301646 on 07/03/2017.
 */
@Service
public class ActiviteService {
    @Autowired
    ActiviteRepository activiteRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;

    public void saveActivite(Activite activite) {
        if (activite == null) {
            throw new IllegalArgumentException();
        }
        activite.getResponsable().addActivite(activite);
        utilisateurRepository.save(activite.getResponsable());
        activiteRepository.save(activite);
    }

    public Activite findOneActivite(long id) {
        return activiteRepository.findOne(id);
    }

    public long countActivite() {
        long count = 0;
        for (Activite activite : activiteRepository.findAll()) {
            count++;
        }
        return count;
    }

    public ActiviteRepository getActiviteRepository() {
        return activiteRepository;
    }

    public ArrayList<Activite> findAllActivites() {
        return (ArrayList<Activite>) activiteRepository.findAllByOrderByTitreAsc();
    }
}
