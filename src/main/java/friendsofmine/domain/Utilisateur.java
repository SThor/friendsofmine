package friendsofmine.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by 21301646 on 01/03/2017.
 */
@Entity
public class Utilisateur {
    @NotNull
    @NotEmpty
    private String nom;
    @NotNull
    @NotEmpty
    private String prenom;
    @NotNull
    @Pattern(regexp = "(.*)@(.*)")
    private String email;
    @NotNull
    @Pattern(regexp = "M|F")
    private String sexe;
    private Date date;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Utilisateur() {

    }

    public Utilisateur(String nom, String prenom, String email, String sexe, Date date) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
