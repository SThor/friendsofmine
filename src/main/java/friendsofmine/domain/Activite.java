package friendsofmine.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by 21301646 on 01/03/2017.
 */
@Entity
public class Activite {
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_responsable")
    private Utilisateur responsable = new Utilisateur();
    @NotNull
    @NotEmpty
    private String titre;
    private String descriptif;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Activite(String titre, String descriptif, Utilisateur responsable) {
        this.titre = titre;
        this.descriptif = descriptif;
        responsable.addActivite(this);
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

    public void setResponsable(Utilisateur responsable) {
        this.responsable = responsable;
    }
}
