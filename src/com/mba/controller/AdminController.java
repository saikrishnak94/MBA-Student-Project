package com.mba.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mba.dao.UserDao;
import com.mba.form.AdvisorForm;
import com.mba.form.Contact;

@Controller
public class AdminController {
	@RequestMapping(value="adminHome1",method=RequestMethod.GET)
    public String adminHome(){
    	return "adminHome";
    }
	
	@RequestMapping(value="withdrawnprogram",method=RequestMethod.GET)
    public ModelAndView withdrawnprogram(HttpServletRequest req){
		String type = req.getParameter("type");
		req.setAttribute("type", type);
		String studProfile = dao.retrieveStudent();
		return new ModelAndView("withdraw","msg",studProfile);
    }
	@RequestMapping(value="/withdrawstudentProfile",method=RequestMethod.POST)
  	public void studentProfile(HttpServletRequest req, HttpServletResponse res){
	   int id = Integer.parseInt(req.getParameter("sid"));
	   String type = req.getParameter("type");
	   String str = dao.withdrawstudentProfile(id,type);
	   PrintWriter out=null;
	try {
		out = res.getWriter();
	} catch (IOException e) {
		e.printStackTrace();
	}
	   out.print(str);
   }
	@RequestMapping(value="/pullstudlist",method=RequestMethod.GET)
  	public ModelAndView pullstudlist(HttpServletRequest req, HttpServletResponse res){
	   String str = dao.pullstudlist();
	   return new ModelAndView("pullreport","msg",str);
   }
	
	
	@RequestMapping(value="/chnageStudentStatus",method=RequestMethod.POST)
  	public void chnageStudentStatus(HttpServletRequest req, HttpServletResponse res){
	   int id = Integer.parseInt(req.getParameter("sid"));
	   String type = req.getParameter("type");
	   String str = dao.chnageStudentStatus(id,type);
	   PrintWriter out=null;
	try {
		out = res.getWriter();
	} catch (IOException e) {
		e.printStackTrace();
	}
	   out.print(str);
   }
	@RequestMapping(value="/addprerequisit",method=RequestMethod.GET)
  	public String addprerequisit(Contact contact){
	   return "addprerequisity";
   }
	@RequestMapping(value = "/addPrerequi", method = RequestMethod.POST)
	public ModelAndView addContact(@Valid	Contact form, BindingResult result, ModelMap model) {
		if(result.hasErrors()){
			System.out.println("true--->");
//			model.addAttribute("result", contact);
			return new ModelAndView("addprerequisit");
		}
		boolean b = dao.addPrerequist(form);
		if(b){
			
			return new ModelAndView("adminHome");
		}
		String msg="Invalid credentials try again";
		return new ModelAndView("addAdvisor","msg",msg);
	}
	
	@RequestMapping(value="editprerequisit",method=RequestMethod.GET)
    public ModelAndView editprerequisit(HttpServletRequest req){
		String studProfile = dao.editprerequisit();
		return new ModelAndView("editPrerequisit1","msg",studProfile);
    }
	
	@RequestMapping(value="/editPrereq",method=RequestMethod.POST)
  	public void editPrereq(HttpServletRequest req, HttpServletResponse res){
	   String newid = req.getParameter("newpid");
	   String oldpid = req.getParameter("oldpid");
	   String name = req.getParameter("name");
	   String str = dao.chnageStudentStatus(newid,oldpid,name);
	   PrintWriter out=null;
	try {
		out = res.getWriter();
	} catch (IOException e) {
		e.printStackTrace();
	}
	   out.print(str);
   }
	@RequestMapping(value="/activateInactivate",method=RequestMethod.POST)
  	public void activateInactivate(HttpServletRequest req, HttpServletResponse res){
	   String status = req.getParameter("status");
	   String pid = req.getParameter("pid");
	   String str = dao.activateInactivate(status,pid);
	   PrintWriter out=null;
	try {
		out = res.getWriter();
	} catch (IOException e) {
		e.printStackTrace();
	}
	   out.print(str);
   }
	
	@Autowired
	UserDao dao;
}
