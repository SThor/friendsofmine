package friendsofmine.repositories;

import friendsofmine.domain.Inscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by 21301646 on 16/03/2017.
 */
public interface InscriptionRepository extends PagingAndSortingRepository<Inscription, Long> {
    Page<Inscription> findByParticipantNomAndActiviteTitreAllIgnoreCase(String nom, String titre, Pageable pageable);

    Page<Inscription> findByParticipantNomAllIgnoreCase(String nom, Pageable pageable);

    Page<Inscription> findByActiviteTitreAllIgnoreCase(String titre, Pageable pageable);
}
