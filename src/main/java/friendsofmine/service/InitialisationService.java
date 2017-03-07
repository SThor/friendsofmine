package friendsofmine.service;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Utilisateur;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by 21301646 on 01/03/2017.
 */
@Service
public class InitialisationService {
    List<Utilisateur> utilisateurs = new ArrayList<>();
    List<Activite> activites = new ArrayList<>();

    public void initDonnees() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date date = cal.getTime();

        Utilisateur paul = new Utilisateur("Paul", "Givel", "paulgivel@gmail.com", "M", date);
        Utilisateur morty = new Utilisateur("Smith", "Morty", "mortysmith@gmail.com", "M", date);
        utilisateurs.add(paul);
        utilisateurs.add(morty);
        utilisateurs.add(new Utilisateur("Sanchez", "Rick", "ricksanchez@gmail.com", "M"));
        utilisateurs.add(new Utilisateur("Smith", "Summer", "summersmith@gmail.com", "F", date));
        utilisateurs.add(new Utilisateur("WAYNE", "Bruce", "imbatman@darkknight.com", "M"));

        activites.add(new Activite("Kick some ass", "Chill out until you find thugs and beat the shit out of them without mercy", morty));
        activites.add(new Activite("Time/Space travel", "Go on a journey into parallel dimensions", morty));
        activites.add(new Activite("Be an honorable man", "Protect your nephew from your best friend by pretending he's your bastard son with a lack of knowledge", paul));
        activites.add(new Activite("Break the 4th wall", "Be a crazy lunatic who shoot first and then talk to an invisible audience of idiots", paul));
        activites.add(new Activite("Dress well", "Always wear fine clothes because you're a beautiful motherf*cker", morty));
        activites.add(new Activite("Skip Snape's class", "Miss Snape potions class on purpose because he's mean as f*ck, son of bitch of Slytherin", morty));
        activites.add(new Activite("Regarder la TV", "", morty));
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public List<Activite> getActivites() {
        return activites;
    }
}
