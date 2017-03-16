package friendsofmine.controllers;

import friendsofmine.Bootstrap;
import friendsofmine.domain.Utilisateur;
import friendsofmine.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by 21301646 on 01/03/2017.
 */
@Controller
public class UtilisateurController {
	@Autowired
	Bootstrap bootstrap;
	@Autowired
	UtilisateurService utilisateurService;

	@RequestMapping(value = "/utilisateurs", method = RequestMethod.GET)
	String list(Model model) {
		model.addAttribute("utilisateurs", utilisateurService.findAllUtilisateurs());
		return "utilisateurs";
	}

	@RequestMapping(value = "/utilisateur/{id}", method = RequestMethod.GET)
	String show(@PathVariable Long id, Model model) {
		Utilisateur utilisateur = utilisateurService.findOneUtilisateur(id);
		if (utilisateur == null) {
			model.addAttribute("message", "Utilisateur non trouvé.");
			return "error";
		}
		model.addAttribute("utilisateur", utilisateur);
		return "utilisateurShow";
	}

	@RequestMapping(value = "/utilisateur/new")
	String createForm(Utilisateur utilisateur) {
		return "utilisateurForm";
	}

	@RequestMapping(value = "/utilisateur", method = RequestMethod.POST)
	String create(@Valid Utilisateur utilisateur, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "utilisateurForm";
		}
		utilisateur = utilisateurService.saveUtilisateur(utilisateur);
		return "redirect:/utilisateur/" + utilisateur.getId();
	}

	@RequestMapping(value = "utilisateur/edit/{id}", method = RequestMethod.GET)
	String edit(@PathVariable Long id, Model model) {
		Utilisateur utilisateur = utilisateurService.findOneUtilisateur(id);
		if (utilisateur == null) {
			model.addAttribute("message", "Utilisateur non trouvé.");
			return "error";
		}
		model.addAttribute("utilisateur", utilisateur);
		return "utilisateurForm";
	}

    @RequestMapping(value = "utilisateur/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    String delete(@PathVariable Long id, Model model) {
		Utilisateur utilisateur = utilisateurService.findOneUtilisateur(id);
		if (utilisateur == null) {
			model.addAttribute("message", "Utilisateur non trouvé.");
			return "error";
		} else if (utilisateur.getActivites().size() > 0) {
			model.addAttribute("message", "Impossible. L'utilisateur est responsable d'activités.");
			return "error";
		}
		utilisateurService.deleteUtilisateur(utilisateur);
		return "redirect:/utilisateurs";
	}
}
