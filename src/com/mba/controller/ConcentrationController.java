package com.mba.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mba.dao.UserDao;
import com.mba.form.Concetration;
@Controller
public class ConcentrationController {
	@RequestMapping(value = "/addConcen1", method = RequestMethod.POST)
	public ModelAndView addContact(@Valid	Concetration conc, BindingResult result, ModelMap model) {
		if(result.hasErrors()){
			System.out.println("true--->");
//			model.addAttribute("result", contact);
			return new ModelAndView("addConcen");
		}
		boolean b = dao.addConcen(conc);
		if(b){
			
			return new ModelAndView("adminHome");
		}
		String msg="Invalid data try again";
		return new ModelAndView("addConcen","msg",msg);
	}
	@RequestMapping(value="/addConcen",method=RequestMethod.GET)
	public String addAdvisor(Concetration conc) {
		return "addConcen";
	}
	@Autowired
	UserDao dao;
}
