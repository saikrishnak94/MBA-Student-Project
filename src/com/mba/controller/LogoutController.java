package com.mba.controller;

import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mba.form.Contact;

@Controller
public class LogoutController {
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(Contact contact,HttpServletRequest request){
       
        HttpSession hs = request.getSession();
        Enumeration e = hs.getAttributeNames();
        while (e.hasMoreElements()) {
            String attr = (String) e.nextElement();
            hs.setAttribute(attr, null);
        }
        hs.invalidate();
        return "login";
	}
}
