package friendsofmine.repositories;

import friendsofmine.domain.Utilisateur;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by 21301646 on 07/03/2017.
 */
public interface UtilisateurRepository extends PagingAndSortingRepository<Utilisateur, Long> {
    public List<Utilisateur> findAllByOrderByNomAsc();
}
