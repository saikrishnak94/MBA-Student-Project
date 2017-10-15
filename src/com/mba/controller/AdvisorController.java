package com.mba.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mba.dao.UserDao;
import com.mba.form.AdvisorForm;
@Controller
public class AdvisorController {
		@RequestMapping(value = "/addAdvisor1", method = RequestMethod.POST)
		public ModelAndView addContact(@Valid	AdvisorForm form, BindingResult result, ModelMap model) {
			if(result.hasErrors()){
				System.out.println("true--->");
//				model.addAttribute("result", contact);
				return new ModelAndView("addAdvisor");
			}
			boolean b = dao.addAdvisor(form);
			if(b){
				
				return new ModelAndView("adminHome");
			}
			String msg="Invalid credentials try again";
			return new ModelAndView("addAdvisor","msg",msg);
		}
		@RequestMapping(value="/addAdvisor",method=RequestMethod.GET)
		public String addAdvisor(AdvisorForm form) {
			return "addAdvisor";
		}
		
		@RequestMapping(value="/activeinactive",method=RequestMethod.GET)
		public ModelAndView activeinactive() {
			System.out.println("controller----<>");
		    List<Map> map	= dao.activeinactive();
		    System.out.println(map);
			return new ModelAndView("activate","advisorlist",map);
		}
		@RequestMapping(value="/activateAdv",method=RequestMethod.POST)
		public void activateAdv(HttpServletRequest req,HttpServletResponse res) {
			System.out.println("controller----<>");
		    boolean b	= dao.activateAdv(req.getParameter("id"));
		    PrintWriter out=null;
			try {
				out = res.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
		    if(b){
		    	out.println("Activated successfully");
		    }else{
		    	out.println("Not Activated successfully");
		    }
		}
		@RequestMapping(value="/resetPassword",method=RequestMethod.GET)
		public ModelAndView resetPassword() {
			List<Map> list = dao.advList();
			StringBuilder stb = new StringBuilder();
			for(Map str:list){
				stb.append("<option value="+str.get("userid")+">"+str.get("userid")+"</option>");
			}
			return new ModelAndView("resetAdvPassword","msg",stb.toString());
		}
		@RequestMapping(value="/resetPwd",method=RequestMethod.POST)
		public void resetPwd(HttpServletRequest req,HttpServletResponse res) {
			boolean b	= dao.resetPwd(req.getParameter("oldpwd"),req.getParameter("newpwd"),req.getParameter("advid"));
		    PrintWriter out=null;
			try {
				out = res.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
		    if(b){
		    	out.println("reset successfully");
		    }else{
		    	out.println("Not reset successfully");
		    }
		}
		@RequestMapping(value="/editPwd",method=RequestMethod.GET)
		public ModelAndView editPwd(HttpServletRequest req) {
			String advId = req.getSession().getAttribute("User").toString();
			StringBuilder sb = new StringBuilder();
			sb.append("<option value="+advId+">"+advId+"</option>");
			return new ModelAndView("editAdvPassword","msg",sb.toString());
		}
		@RequestMapping(value="/retrieveStudent",method=RequestMethod.GET)
		public ModelAndView retrieveStudent(HttpServletRequest req) {
			String studProfile = dao.retrieveStudent();
			String mode = req.getParameter("mode");
			if(mode.equalsIgnoreCase("view"))
			  return new ModelAndView("retreiveStudent","msg",studProfile);
			else if(mode.equalsIgnoreCase("review"))
				return new ModelAndView("viewStudent","msg",studProfile);
			return null;
		}
		@RequestMapping(value="/enterNote",method=RequestMethod.GET)
		public ModelAndView enterNote(){
			return new ModelAndView("enterNote");
		}
		@RequestMapping(value="/saveNote",method=RequestMethod.POST)
		public String saveNote(HttpServletRequest req,HttpServletResponse res){
			String note = req.getParameter("note");
			int user = Integer.parseInt(req.getParameter("user"));
			boolean b	= dao.saveNote(note,user);
		    PrintWriter out=null;
			try {
				out = res.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		@RequestMapping(value="/advisorHome",method=RequestMethod.GET)
		public String advisorHome(){
			return "advisorHome";
		}
		@RequestMapping(value="/viewNote",method=RequestMethod.GET)
		public ModelAndView viewNote(HttpServletRequest req){
			HttpSession session = req.getSession();
			int user = Integer.parseInt((String)session.getAttribute("User"));
			List<Map> map = dao.viewNote(user);
			return new ModelAndView("viewNote","map",map);
		}
		@RequestMapping(value="/preRequisit",method=RequestMethod.POST)
		public void preRequisit(HttpServletRequest req,HttpServletResponse res){
			List<Map> map = dao.preRequisit(Integer.parseInt(req.getParameter("sid")));
			StringBuilder sb = new StringBuilder();
			sb.append("<table class=\"table table-striped table-bordered\" cellspacing=\"0\" width=\"100%\"><thead><tr><th>Id</th><th>Name</th><th>MarkMet</th></tr></thead><tbody>");
			for(Map m:map){
				sb.append("<tr><td>"+m.get("PID")+"</td><td>"+m.get("Name")+"</td>");
				sb.append("<td><input type='checkbox' id='ck' name='ck' value="+m.get("PID")+"></td></tr>");
			}
			sb.append("<td><button onclick='markmet()'>Ok</button>");
			sb.append("</tbody></table>");
			try {
				PrintWriter out = res.getWriter();
				out.print(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@RequestMapping(value="/markpreRequisit",method=RequestMethod.GET)
		public ModelAndView markpreRequisit(HttpServletRequest req){
			String msg = dao.retrieveStudent();
			return new ModelAndView("markpreRequisit","msg",msg);
		}
		@RequestMapping(value="/insertpreRequisit",method=RequestMethod.GET)
		public void insertpreRequisit(HttpServletRequest req,HttpServletResponse res){
			JSONArray json;
			PrintWriter out=null;
			try {
				out=res.getWriter();
				json = new JSONArray(req.getParameter("jsonObj"));
				int result = dao.insertpreRequisit(json);
				if(result>0){
					out.write("success");
				}else
					out.write("fail");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		@Autowired
		UserDao dao;
}
