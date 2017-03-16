package friendsofmine.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by 21301646 on 16/03/2017.
 */
@Entity
public class Inscription {

    @NotNull
    @ManyToOne
    private Utilisateur participant;
    @NotNull
    @ManyToOne
    private Activite activite;
    private Date dateInscription;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Inscription(Utilisateur participant, Activite activite, Date dateInscription) {
        this.participant = participant;
        this.activite = activite;
        this.dateInscription = dateInscription;
    }

    public Inscription() {
    }

    ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public Utilisateur getParticipant() {
        return participant;
    }

    public void setParticipant(Utilisateur participant) {
        this.participant = participant;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }
}
