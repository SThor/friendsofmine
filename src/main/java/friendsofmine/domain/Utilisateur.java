package friendsofmine.domain;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 21301646 on 01/03/2017.
 */
@Entity
public class Utilisateur {
    @NotNull
    @Size(min = 1, max = 20)
    private String nom;
    @NotNull
    @Size(min = 1, max = 20)
    private String prenom;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Pattern(regexp = "M|F")
    private String sexe;
    private Date dateNaissance;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "responsable")
    private List<Activite> activites = new ArrayList<>();

    public Utilisateur() {

    }

    public Utilisateur(String nom, String prenom, String email, String sexe, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
    }

    public Utilisateur(String nom, String prenom, String email, String sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Activite> getActivites() {
        return activites;
    }

    public void setActivites(List<Activite> activites) {
        this.activites = activites;
    }

    public void addActivite(Activite activite) {
        if (!activites.contains(activite))
            activites.add(activite);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utilisateur that = (Utilisateur) o;

        if (dateNaissance != null ? !dateNaissance.equals(that.dateNaissance) : that.dateNaissance != null)
            return false;
        if (!email.equals(that.email)) return false;
        if (!id.equals(that.id)) return false;
        if (!nom.equals(that.nom)) return false;
        if (!prenom.equals(that.prenom)) return false;
        if (!sexe.equals(that.sexe)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nom.hashCode();
        result = 31 * result + prenom.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + sexe.hashCode();
        result = 31 * result + (dateNaissance != null ? dateNaissance.hashCode() : 0);
        result = 31 * result + id.hashCode();
        return result;
    }
}
