package friendsofmine.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by 21301646 on 01/03/2017.
 */
public class Activite {
    @NotNull
    @NotEmpty
    private String titre;
    private String descriptif;

    public Activite(String titre, String descriptif) {
        this.titre = titre;
        this.descriptif = descriptif;
    }

    public Activite() {
    }

    public String getTitre() {
        return titre;
    }

    public String getDescriptif() {
        return descriptif;
    }
}
