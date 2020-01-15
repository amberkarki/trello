package com.trello.trello.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trello.trello.domai.Developer;
import com.trello.trello.domai.DeveloperRepository;
import com.trello.trello.domai.Project;
import com.trello.trello.domai.ProjectRepository;
import com.trello.trello.domai.Registration;
import com.trello.trello.domai.User;
import com.trello.trello.domai.UserRepository;






@Controller

public class DeveloperController {
@Autowired
private DeveloperRepository drepository;

@Autowired ProjectRepository prorepository;
@ Autowired UserRepository userRepo; 

@RequestMapping(value="/login")
public String login() {	
    return "login";
}		

@RequestMapping(value = "/signup")
public String addNewUser(Model model){
 model.addAttribute("registration", new Registration());
return "signup";

 }
@PostMapping(value = "/saveuser")
public String save(@Valid @ModelAttribute("registration") Registration registration, BindingResult bindingResult) {
	if (!bindingResult.hasErrors()) { // validation errors
		if (registration.getPassword().equals(registration.getRepassword())) { // check password match
			String pwd = registration.getPassword();
			BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
			String hashPwd = bc.encode(pwd);

			User newUser = new User();
			newUser.setPasswordHash(hashPwd);
			newUser.setUsername(registration.getUsername());
			newUser.setRole("USER");
			if (userRepo.findByUsername(registration.getUsername()) == null) { // Check if user exists
				userRepo.save(newUser);
			} else {
				
				return "signup";
			}
		} else {
			
			return "signup";
		}
	} else {
		return "signup";
	}
	return "redirect:/login";
}






@RequestMapping(value="/adddeveloper")
public String adddeveloper() {	
    return "adddeveloper";
}

@GetMapping("/developerlist")
public String developerStore(Model model) {
	model.addAttribute("developers", drepository.findAll());

return "developerlist";
}

@RequestMapping(value ="/add")
public String addDeveloper(Model model) {
	model.addAttribute("developer", new Developer());
	model.addAttribute("project", prorepository.findAll());
	return "adddeveloper";
}
@RequestMapping(value = "/save", method = RequestMethod.POST)
public String save(Developer developer) {
	drepository.save(developer);

	return "redirect:developerlist";
}

@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
public String deleteDevelpoer(@PathVariable("id") Long developerId, Model model) {
	drepository.deleteById(developerId);
	
	return "redirect:../developerlist";
}

@RequestMapping(value = "/edit/{id}")
public String updateDeveloper(@PathVariable("id") Long developerId, Model model) {
	model.addAttribute("developer", drepository.findById(developerId));
	model.addAttribute("project", prorepository.findAll());
	return "editdeveloper";
}

/*@GetMapping(value="/search")
public String searchProjectName (@RequestParam (name = "byName") String byName, Model model){
	model.addAttribute("projects", prorepository.findByNameIgnoreCaseContaining(byName));
	return "developerlist";
	
}
*/
@GetMapping(value="/search")
public String searchDevName (@RequestParam (name = "byFirstname") String byFirstname, Model model){
	model.addAttribute("developers", drepository.findByFirstnameIgnoreCaseContaining(byFirstname));
	return "developerlist";
	
}


@RequestMapping(value = "/addpro")
public String addProject(Model model) {
	model.addAttribute("project", new Project());
	return "addpro";

}

@RequestMapping(value = "/savepro", method = RequestMethod.POST)
public String save(Project project) {
	prorepository.save(project);
	return "redirect:developerlist";
}

//Search by project name 


// RESTful Services
//@RequestMapping(value="/developers", method= RequestMethod.GET)
@GetMapping("/developers")
public @ResponseBody List<Developer> developerList(){
	return (List<Developer>) drepository.findAll();
}
@GetMapping("/projects")
public @ResponseBody List<Project> projectList(){
	return (List<Project>) prorepository.findAll();
}
//RESTful services for all users
@GetMapping(value="/users")
public @ResponseBody List<User> getAllUsers(){
	return (List<User>) userRepo.findAll();
}
}
