package friendsofmine.service;

import friendsofmine.domain.Activite;
import friendsofmine.repositories.ActiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 21301646 on 07/03/2017.
 */
@Service
public class ActiviteService {
    @Autowired
    ActiviteRepository activiteRepository;

    public void saveActivite(Activite activite) {
        if (activite == null) {
            throw new IllegalArgumentException();
        }
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
}
