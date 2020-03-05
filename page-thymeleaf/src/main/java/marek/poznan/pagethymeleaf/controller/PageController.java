package marek.poznan.pagethymeleaf.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import marek.poznan.pagethymeleaf.entity.Page;
import marek.poznan.pagethymeleaf.service.PageService;

@Controller
@RequestMapping("/show")
public class PageController {

	@Autowired
	PageService theService;

	@RequestMapping("/page")
	public String page() {

		return "mainpage";
	}

	@GetMapping("/infoStudents")
	public String infoStudents(Model theModel) {
		List<Page> thePage = theService.findAll();
		theModel.addAttribute("page", thePage);

		return "InfoForMyStudents";
	}

	@GetMapping("/opinions")
	public String opinions(Model theModel) {
		List<Page> thePage = theService.findAll();
		theModel.addAttribute("page", thePage);

		return "opinion";
	}

	@GetMapping("/signUp")
	public String sign(Model theModel) {
		Page thePage = new Page();
		theModel.addAttribute("page", thePage);

		return "sign";
	}

	@PostMapping("/saveStudent")
	public String saveStudent(@Valid @ModelAttribute("page") Page thePage, BindingResult theBindingResult) {
		List<Page> lista = theService.findAll();
		for (Page list : lista) {
			if (list.getEmail().equals(thePage.getEmail())) {
				return "sign";
			}
		}
		if (theBindingResult.hasErrors()) {
			return "sign";
		} else {
			theService.save(thePage);
			return "mainpage";
		}
	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("pageId") int theId) {
		theService.deleteById(theId);

		return "redirect:/show/infoStudents";
	}

	@GetMapping("/forUpdate")
	public String forUpdate(@RequestParam("pageId") int theId, Model theModel) {
		Page thePage = theService.findById(theId);
		theModel.addAttribute("page", thePage);

		return "update";
	}

	@GetMapping("/update")
	public String updateStudent(@ModelAttribute("page") Page thePage) {
		theService.save(thePage);

		return "redirect:/show/infoStudents";
	}

}
