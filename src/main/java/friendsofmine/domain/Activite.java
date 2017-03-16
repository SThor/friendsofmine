package friendsofmine.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by 21301646 on 01/03/2017.
 */
@Entity
public class Activite {
    @NotNull
    @ManyToOne
    @JsonIgnore
    private Utilisateur responsable;
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
        this.responsable = responsable;
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

    public Utilisateur getResponsable() {
        return responsable;
    }

    public void setResponsable(Utilisateur responsable) {
        this.responsable = responsable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activite activite = (Activite) o;

        if (descriptif != null ? !descriptif.equals(activite.descriptif) : activite.descriptif != null) return false;
        if (!id.equals(activite.id)) return false;
        if (!titre.equals(activite.titre)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = responsable.hashCode();
        result = 31 * result + titre.hashCode();
        result = 31 * result + (descriptif != null ? descriptif.hashCode() : 0);
        result = 31 * result + id.hashCode();
        return result;
    }
}
