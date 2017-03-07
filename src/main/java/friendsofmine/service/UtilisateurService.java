package friendsofmine.service;

import friendsofmine.domain.Utilisateur;
import friendsofmine.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 21301646 on 07/03/2017.
 */
@Service
public class UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    public void saveUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    public Utilisateur findOneUtilisateur(long id) {
        return utilisateurRepository.findOne(id);
    }

    public long countUtilisateur() {
        long count = 0;
        for (Utilisateur utilisateur : utilisateurRepository.findAll()) {
            count++;
        }
        return count;
    }

    public UtilisateurRepository getUtilisateurRepository() {
        return utilisateurRepository;
    }
}
