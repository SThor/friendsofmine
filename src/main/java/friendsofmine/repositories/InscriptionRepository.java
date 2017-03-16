package friendsofmine.repositories;

import friendsofmine.domain.Inscription;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by 21301646 on 16/03/2017.
 */
public interface InscriptionRepository extends PagingAndSortingRepository<Inscription, Long> {
}
