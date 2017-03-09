package friendsofmine.repositories;

import friendsofmine.domain.Activite;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by 21301646 on 07/03/2017.
 */
public interface ActiviteRepository extends PagingAndSortingRepository<Activite, Long> {

    public List<Activite> findAllByOrderByTitreAsc();

}
