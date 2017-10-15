package com.mba.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mba.dao.UserDao;
import com.mba.form.RegistrationForm;
@Controller
public class StudentController {
	@RequestMapping(value="/shome",method=RequestMethod.GET)
	public String studentHome(){
	   return "studentHome";
   }
    @RequestMapping(value="/editmail",method=RequestMethod.GET)
	public String editMail(RegistrationForm reg){
	   return "editMail";
   }
   @RequestMapping(value="/editEmail",method=RequestMethod.POST)
   public ModelAndView editEmail(@Valid RegistrationForm reg,BindingResult result){
	   System.out.println("email--->"+reg.getsID()+"  "+reg.getPerEmail());
	  boolean b = dao.editEmail(reg);
	  if(b){
		 
		  return new ModelAndView("adminHome");
	  }
	  else{
		  String msg="Invalid Student ID try again";
		  return new ModelAndView("editMail","msg",msg);
	  }
   }
   @RequestMapping(value="/editContration",method=RequestMethod.POST)
   public void editContration(HttpServletRequest req, HttpServletResponse res)
   {
	   PrintWriter out = null;
	    String stId = req.getParameter("studId");
	    List<Map> list = dao.editStudentConcen(stId);
	    StringBuilder sb = new StringBuilder();
	    sb.append("<table class=\"table table-striped table-bordered\" cellspacing=\"0\" width=\"100%\"><thead><tr><th>Student Concentrations</th><th>Change Concentrations</th></tr></thead>");
	    try {
			 out = res.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    int i=0;
	    for(Map m1:list){
	    	if(i==0){
	    		sb.append("<tr><td>"+m1.get("concentrations")+"</td>");
	    	    sb.append("<td><select id=\"concen\" multiple=\"true\">");
	    	    i++;
	    	}
	    	sb.append("<option>"+m1.get("DegreeCode")+"</option>");
	    }
	    sb.append("</td></tr><td><button onclick='changeConcen()'>ChangeConcen..</button></table>");
	    out.print(sb.toString());
   }
    @RequestMapping(value="/editStudentConcen",method=RequestMethod.GET)
	public ModelAndView editStudentConcen(){
		//List<Map> list = dao.editStudentConcen();
	   String studProfile = dao.retrieveStudent();
		//System.out.println("List--->"+list);
	   //return new ModelAndView("withdraw","msg",studProfile);
		return new ModelAndView("editStudentConcen","msg",studProfile);
	}
   @RequestMapping(value="/completeQ",method=RequestMethod.GET)
	public ModelAndView ecompleteQ(HttpServletRequest req, HttpServletResponse res){
	    HttpSession session = req.getSession(false);
		String user = (String)session.getAttribute("User");
		List<Map> list = dao.completeQ(user);
		System.out.println("List--->"+list);
		PrintWriter out = null;
		try {
			out = res.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer sb =new StringBuffer();
		if(list.size()==0){
			sb.append("Already Exam Completed");
		}
		else{
		sb.append("<table id='mytable'><tr><td>Questions</td>");
		
		int i=2;
		for(Map map:list){
			sb.append("<tr><td>"+map.get("QId")+").</td>");
			sb.append("<td>"+map.get("Question")+"</td>");
			sb.append("<td>");
			if(map.get("type").equals("radio")){
			    sb.append("<input type='radio' name='radi"+i+"'  value='No'>No&nbsp;&nbsp;&nbsp;<input type='radio' name='radi"+i+"' id='radiButton' value='YES'>Yes");
			    i++;
			}else if(map.get("type").equals("text")){
				sb.append("<input type='text'>");
			}else{
				if(map.get("QId").toString().equals("19")){
				sb.append("<select id='first' multiple><option>Internet search</option>");
				sb.append("<option>Referral by a friend/co-worker</option>");
				sb.append("<option>Referral by a manager at work</option>");
				sb.append("<option>Attended UCM before</option>");
				sb.append("<option>Other</option>");
				sb.append("</select>");
				}else if(map.get("QId").toString().equals("20")){
					sb.append("<select id='second' multiple><option>Cost</option>");
					sb.append("<option>Entrance requirements</option>");
					sb.append("<option>Reputation</option>");
					sb.append("<option>Proximity to work</option>");
					sb.append("<option>Proximity to home</option>");
					sb.append("<option>Familiarity with UCM</option>");
					sb.append("<option>Know other students</option>");
					sb.append("<option>AACSB Accreditation</option>");
					sb.append("<option>Other</option>");
					
					sb.append("</select>");
				}
				sb.append("</td></tr>");
			}
		}
		sb.append("<button onclick='submitExam()'>Submit</button>");
		sb.append("</table>");
		}
		return new ModelAndView("completeQuestion","question",sb.toString());
	}
   @RequestMapping(value="/studentProfile",method=RequestMethod.POST)
  	public void studentProfile(HttpServletRequest req, HttpServletResponse res){
	   int id = Integer.parseInt(req.getParameter("sid"));
	   String str = dao.studentProfile(id);
	   PrintWriter out=null;
	try {
		out = res.getWriter();
	} catch (IOException e) {
		e.printStackTrace();
	}
	   out.print(str);
   }
   @RequestMapping(value="/reviewstudentProfile",method=RequestMethod.POST)
	public void reviewstudentProfile(HttpServletRequest req, HttpServletResponse res) {
		 int id = Integer.parseInt(req.getParameter("sid"));
		 String studProfile = dao.reviewstudentProfile(id);
		   PrintWriter out=null;
		try {
			out = res.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		   out.print(studProfile);
	}
   @RequestMapping(value="/insertAns",method=RequestMethod.POST)
	public void insertAns(HttpServletRequest req, HttpServletResponse res) throws JSONException {
		 JSONArray jsonArray=new JSONArray(req.getParameter("jsonObj"));
		 HttpSession session = req.getSession(false);
		 String user = (String)session.getAttribute("User");
		 int result = dao.insertAns(jsonArray,user);
		   PrintWriter out=null;
		try {
			out = res.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(result>0)
		   out.print("success");
		else
			 out.print("failure");
	}
   @RequestMapping(value="/getCodeOfCoduct",method=RequestMethod.GET)
   public String getCodeOfCoduct(){
	   return "codeOfConduct";
   }
   @RequestMapping(value="/codeofConduct",method=RequestMethod.GET)
   public void codeofConduct(HttpServletRequest req,HttpServletResponse res){
	   HttpSession session = req.getSession(false);
		 String user = (String)session.getAttribute("User");
		 int result = dao.codeofConduct(user);
		   PrintWriter out=null;
		try {
			out = res.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(result>0)
		   out.print("success");
		else
			 out.print("failure");
		
   }
   @RequestMapping(value="/changeContration",method=RequestMethod.POST)
   public void changeContration(HttpServletRequest req,HttpServletResponse res){
	    String stuid = req.getParameter("studId");
	    String concen = req.getParameter("concen");
		 int result = dao.changeContration(stuid,concen);
		PrintWriter out=null;
		try {
			out = res.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(result>0)
		   out.print("success");
		else
			 out.print("failure");
		
   }
   @Autowired
   UserDao dao;
}
