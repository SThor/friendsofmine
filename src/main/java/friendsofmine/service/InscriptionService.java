package friendsofmine.service;

import friendsofmine.domain.Inscription;
import friendsofmine.repositories.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
