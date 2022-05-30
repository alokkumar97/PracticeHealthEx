package com.Spring.HcE.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Spring.HcE.Model.Specialization;
import com.Spring.HcE.Model.User_Details;
import com.Spring.HcE.Service.ISpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {

	@Autowired
	ISpecializationService specService;

	/* Login Page */
	
	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}
	/* *
	 * login Authentication and authorization 
	 * */
	
	@PostMapping("/signin")
	public String signInPage(@ModelAttribute ) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username=null;
		if(principal instanceof UserDetails) {
			username=((User_Details) principal).getEmail();
		}else {
			username = principal.toString();
		}
		StringBuilder redirectAll= new  StringBuilder();
		if(username != null) {
			redirectAll.append("redirect:/spec/all");
		}else {
			redirectAll.append("redirect:/spec/login");
		}
		return redirectAll.toString();
		
	}
	
	/* *
	 * 1. Show Register Page 
	 * */
	@GetMapping("/register")
	public String registerSpecialization(@ModelAttribute Specialization spec) {
		return "SpecializationRegister";	
	}
	/* *
	 * 2. On submit form save data 
	 * */
	@PostMapping("/save")
	public String saveSpecializationdetails(@ModelAttribute Specialization spec,Model model) {
		Long id=specService.saveSpecialization(spec);
		String message="Record ("+id+") is saved ";
		model.addAttribute("message", message);
		return "SpecializationRegister";
	}
	/**
	 * 3. Display All Specialization
	 * */

	@GetMapping("/all")
	public String getAllSpecialization(Model model, @RequestParam(value="message", required = false) String message) {
		List<Specialization> list=specService.getAllSpecialization();
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "SpecializationData";
	} 
	/**
	 * 4. Delete by Id
	 * */
	
	@GetMapping("/delete")
	public String deleteSpecialization(@RequestParam Long Id,
					RedirectAttributes attributes  ) {
		specService.removeSpecialization(Id);
		attributes.addAttribute("message", "Record ("+Id+") is deleted.");
		return "redirect:all";
	}
	/* 
	 * 5. Fetch data into Edit Page
	 */
	@GetMapping("/edit")
	public String showEditPage(@RequestParam Long Id, Model model) {
		Specialization spec=  specService.getOneSpecialization(Id);
		model.addAttribute("specialization", spec);
		return "SpecializationEdit";
	}
	/**
	 * 6. Update data and Show in all page
	 * */
	@PostMapping("/update")
	public String updateData(@ModelAttribute Specialization spec,RedirectAttributes attributes) {
		specService.updateSpecialization(spec);
		attributes.addAttribute("message", "Record ("+spec.getSpecId()+") is updated.");
		return "redirect:all";
	}
	
	/**
	 * 7. Read code and check with service
	 *     Return message to UI
	 */
	@GetMapping("/checkCode")
	public @ResponseBody String validateSpecCode(@RequestParam String code) {
		String message="";
		if(specService.isSpecCodeExist(code)) {
			message= code+", altready exist";
		}
		return message;	
	}
}

