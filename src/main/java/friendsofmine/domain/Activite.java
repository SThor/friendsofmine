package friendsofmine.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by 21301646 on 01/03/2017.
 */
@Entity
public class Activite {
    @NotNull
    @NotEmpty
    private String titre;
    private String descriptif;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Activite(String titre, String descriptif) {
        this.titre = titre;
        this.descriptif = descriptif;
    }

    public Activite() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescriptif() {
        return descriptif;
    }


    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

}
