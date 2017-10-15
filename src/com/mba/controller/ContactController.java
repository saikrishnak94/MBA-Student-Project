package com.mba.controller;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mba.dao.UserDao;
import com.mba.form.Contact;
@Controller 
@SessionAttributes("User")
public class ContactController  {
	@RequestMapping(value = "/addContact", method = RequestMethod.GET)
	public ModelAndView addContact(@Valid	Contact contact, BindingResult result, ModelMap model) {
		System.out.println("usename;;;"+contact.getUserId()+"  "+contact.getPassword());
		ModelAndView view = new ModelAndView();
		String msg="Invalid credentials try again";
		if(result.hasErrors()){
			System.out.println("true--->");
//			model.addAttribute("result", contact);
			
			return new ModelAndView("login","msg",msg);
		}
		String userType = dao.getUserType(contact);
		if(userType==null){
			
			return new ModelAndView("login","msg",msg);
		}
		if(userType.equalsIgnoreCase("admin")){
			view.setViewName("adminHome");
		}else if(userType.equalsIgnoreCase("student")){
			view.setViewName("studentHome");
		}else if(userType.equalsIgnoreCase("advisor")){
			view.setViewName("advisorHome");
		}
		 view.addObject("User", contact.getUserId());
		
		return view;
	}
	
	/*@RequestMapping("/contact")
	public ModelAndView showContacts() {
		return new ModelAndView("login", "command", new Contact());
	}*/
	@RequestMapping("/contact")
	public String showContacts(Contact contact) {
		/*Contact contact = new Contact();
		map.addAttribute("result", contact);*/
		return "login";
	}
	@Autowired
	UserDao dao;
}
