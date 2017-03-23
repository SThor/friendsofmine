package friendsofmine.service;

import friendsofmine.domain.Inscription;
import friendsofmine.repositories.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by 21301646 on 16/03/2017.
 */
@Service
public class InscriptionService {
    @Autowired
    InscriptionRepository inscriptionRepository;


    public Inscription saveInscription(Inscription ins) {
        if (ins.getDateInscription() == null) {
            ins.setDateInscription(new Date());
        }
        return inscriptionRepository.save(ins);
    }

    public Inscription findOneInscription(Long id) {
        return inscriptionRepository.findOne(id);
    }

    public long countInscription() {
        return inscriptionRepository.count();
    }

    public InscriptionRepository getInscriptionRepository() {
        return inscriptionRepository;
    }

    public void deleteInscription(Long id) {
        inscriptionRepository.delete(id);
    }

    public Page<Inscription> findAll(Pageable pageable) {
        return inscriptionRepository.findAll(pageable);
    }

    public Page<Inscription> findByUtilisateurActivite(String nom, String titre, Pageable pageable) {
        return inscriptionRepository.findByParticipantNomAndActiviteTitreAllIgnoreCase(nom, titre, pageable);
    }

    public Page<Inscription> findByUtilisateur(String nom, Pageable pageable) {
        return inscriptionRepository.findByParticipantNomAllIgnoreCase(nom, pageable);
    }

    public Page<Inscription> findByActivite(String titre, Pageable pageable) {
        return inscriptionRepository.findByActiviteTitreAllIgnoreCase(titre, pageable);
    }
}
