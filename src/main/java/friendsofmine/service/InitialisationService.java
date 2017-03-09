package friendsofmine.service;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by 21301646 on 01/03/2017.
 */
@Service
@Transactional
public class InitialisationService {
    /*List<Utilisateur> utilisateurs = new ArrayList<>();
    List<Activite> activites = new ArrayList<>();*/
    @Autowired
    ActiviteService activiteService;
    @Autowired
    UtilisateurService utilisateurService;
    private Utilisateur thom;
    private Utilisateur mary;
    private Activite randonnee;
    private Activite lindyhop;
    private Activite taekwondo;

    public void initDonnees() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date date = cal.getTime();

        /*Utilisateur paul = new Utilisateur("Paul", "Givel", "paulgivel@gmail.com", "M", date);
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
        activites.add(new Activite("Regarder la TV", "", morty));*/

        initThom();
        initMary();
        initRandonnee();
        initLindyhop();
        initTaekwondo();
    }

    private void initTaekwondo() {
        taekwondo = new Activite("Taekwondo", "le lundi soir", thom);
        activiteService.saveActivite(taekwondo);
    }

    private void initLindyhop() {
        lindyhop = new Activite("LindyHop", "le dimanche soir", mary);
        activiteService.saveActivite(lindyhop);
    }

    private void initRandonnee() {
        randonnee = new Activite("Randonnée", "le jeudi soir", thom);
        activiteService.saveActivite(randonnee);
    }

    private void initMary() {
        mary = new Utilisateur("mary", "yorke", "mary@yorke.fr", "F");
        utilisateurService.saveUtilisateur(mary);
    }

    private void initThom() {
        thom = new Utilisateur("thom", "yorke", "thom@yorke.fr", "M");
        utilisateurService.saveUtilisateur(thom);
    }

    /*public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public List<Activite> getActivites() {
        return activites;
    }*/

    public Utilisateur getThom() {
        return thom;
    }

    public Utilisateur getMary() {
        return mary;
    }

    public Activite getRandonnee() {
        return randonnee;
    }

    public Activite getLindyhop() {
        return lindyhop;
    }

    public Activite getTaekwondo() {
        return taekwondo;
    }
}
