package com.mba.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mba.dao.UserDao;
import com.mba.form.Concetration;
import com.mba.form.RegistrationForm;
@Controller
public class RegistrationController {
	@RequestMapping(value="/addStudent",method=RequestMethod.POST)
	public String addStudent(@Valid RegistrationForm registration,BindingResult result,HttpServletRequest req){
		System.out.println("student details-->"+registration.getfName()+" "+registration.getlName());
		if(result.hasErrors()){
			return "regiform";
		}
		boolean b = dao.insertStudent(registration);
		if(b){
			try {
				MimeMessage message = this.mailSender.createMimeMessage();
				MimeMessageHelper email = new MimeMessageHelper(message, true, "UTF-8");
				email.setTo(registration.getPerEmail());
				email.setSubject("MBA Student Profile System");
				String url = req.getRequestURL().toString();
				url = url.substring(0,url.lastIndexOf("/"))+"/addContact.html?userId="+registration.getsID()+"&password="+registration.getfName()+"@123";
				System.out.println("url is --->"+url);
				StringBuilder sb = new StringBuilder();
				String body = "<a href="+url+">"+url+"</a>";
				//sb.append("<h3>User Details</h3>");
				sb.append("<table><tr><td>Dear</td><td>"+ registration.getfName()+"</td></tr>"+ registration.getlName()+",");
				
				String conc[]=registration.getConcentrations();
				for(String c:conc)
				//sb.append("<tr><td colspan='2'>"+c+"</td></tr></table>");
				
				sb.append("<tr><td>We are glad you have been accepted into the MBA Program - " +c+
                " Concentration at the University of Central Missouri and are looking forward to your participation in the program.</td></tr>");
				sb.append("<tr><td>Your next step is to access the web site linked below and answer questions which will"+" "+
                "enable your advisor to better serve you. This information is shared between and MBA Program Director and the Program Advisors. It is"+" "+ 
                "not made available to outside parties.</td></tr>");
				sb.append("<tr><td>Even if your plans change and you decide not to attend, we ask that you indicate such at the web site.<br/></tr></td>");
				
				sb.append("<tr><td>Student ID:"+registration.getsID()+"</td></tr>");
				//sb.append("<tr><td>Password:"+registration.getpassword()+"</td></tr>");
				sb.append("<tr><td>Questions about the questionnaire or the MBA program should be directed to Dr. Kerry	Henson, MBA Program Director at"
						+" "+"MBA@UCMO.EDU</td></tr>");
				sb.append("<tr><td>Please do not reply to this message.<br/></td></tr>");		
				sb.append("<tr><td>Thanks!<br/></td></tr>");		
				sb.append("<tr><td>Kerry Henson, PhD</td></tr>");
				sb.append("<tr><td>Assistant Dean</td></tr>");
				sb.append("<tr><td>MBA Program Director</td></tr>");
				sb.append("<tr><td>Harmon College of Business and Professional Studies</td></tr>");
				sb.append("<tr><td>University of Central Missouri</td></tr>");
				sb.append("<tr><td>Dockery 300C</td></tr>");
				sb.append("<tr><td>Warrensburg, Missouri 64093<br/></td></tr>");
				sb.append("<tr><td>660-422-2705</td></tr>");
				sb.append("<tr><td>mba@ucmo.edu</td></tr>");
			    //sb.append("<tr><td colspan='2'>Concetrations :</td></tr>");
				
				sb.append("<tr><td>URL:"+" "+"</td></tr>");
				sb.append(body);
				email.setText(sb.toString(),true);
				
				this.mailSender.send(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return "adminHome";
	}
	@RequestMapping("/regiform")
	public String helloWorld(RegistrationForm registrationForm) {
		//return new ModelAndView("regiform", "command", new RegistrationForm());
		return "regiform";
	}
	@RequestMapping(value="/getConcetration",method=RequestMethod.POST)
	public void getConcetration(HttpServletRequest req, HttpServletResponse res){
		System.out.println("hi welcome to");
		String resp = dao.getConcetration();
		try {
			PrintWriter out = res.getWriter();
			out.print(resp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value="/listConcentration",method=RequestMethod.GET)
	public ModelAndView listConcetration(Concetration conc){
		List<Map> list = dao.listConcetration();
		return new ModelAndView("concList","list",list);
	}
	@RequestMapping(value="/editConcentration",method=RequestMethod.POST)
	public ModelAndView editConcetration(Concetration conc,HttpServletResponse res){
		boolean b = dao.editConcetration(conc);
		PrintWriter out=null;
		try {
			out = res.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(b){
			out.println("update successfully");
		}else{
			out.println("problem occured");
		}
		return null;
	}
	@Autowired
	UserDao dao;
	@Autowired
	 private JavaMailSender mailSender;
	
}
