package marek.poznan.pagethymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showLogin")
	public String showMyLoginPage() {
		
		return "login";
		
	}
	
	@GetMapping("/accessDenied")
	public String showAccessDenied() {
		
		return "access-denied";
		
	}
	
}