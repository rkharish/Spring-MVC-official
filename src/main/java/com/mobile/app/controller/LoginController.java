package com.mobile.app.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mobile.app.service.IAuthService;

@Controller  ///@Component,@Repository,@Service
//@Controller - means this class is working as model for spring mvc
public class LoginController {
	
	@Autowired
	@Qualifier("AuthService")
	private IAuthService iAuthService;
	
	@RequestMapping(value="homePage",method = RequestMethod.GET)
    public String handleRequestInternal(Model model) throws Exception {
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       //retrieving the role of the logged in user.
       Collection<? extends GrantedAuthority> grantedList=authentication.getAuthorities();
       //Here we are assuming last role present inside the list will be actual role of
       //logged in user.
       String nextPage="";
       if(grantedList!=null && grantedList.size()>0){
         Iterator<? extends GrantedAuthority> iterator=grantedList.iterator();
         if(iterator.hasNext()){
             GrantedAuthority ga=iterator.next();
             nextPage=ga.getAuthority(); //admin,user
         }
       }
       return "redirect:/mobile/profiles";
    }
	
	@RequestMapping(value="denied",method=RequestMethod.GET)
	public String denied(HttpServletRequest request) {
		return "accessDenied";
	}
	
	
	@RequestMapping(value="invalidLogin",method=RequestMethod.GET)
	public String invalidLogin() {
		return "invalidLogin";
	}
	
	@RequestMapping(value="auth",method=RequestMethod.GET)
	public String authLogin(HttpServletRequest request) {
		return "login";
	}
	
	@RequestMapping(value="auth",method=RequestMethod.POST)
	public String auth(HttpServletRequest request) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//here we are calling dao layer which is authentication with db
		String result=iAuthService.authUser(username, password);
		request.setAttribute("username",username);
		if("success".equalsIgnoreCase(result)){
			 return "redirect:/mobile/profiles";
			//request.setAttribute("ApplicationMessage","Hey "+username+" , you are a valid user for our app. we welcome you..");
		}	
		else{
			request.setAttribute("ApplicationMessage","Hey "+username+" , you are not a valid user for our app. Sorry try again..");
		}
		return "login";
	}
	
	
	@RequestMapping(value="findImageByUsername",method=RequestMethod.GET)
	public void  showImage(HttpServletRequest request,HttpServletResponse response) {
		String username=request.getParameter("username");
		if(username==null || username.length()==0){
			return;
		}
		//here we are calling dao layer which is authentication with db
		byte[] image=iAuthService.findUserImageByUserName(username);
		response.setContentType("image/jpg");
		try {
			ServletOutputStream outputStream	=response.getOutputStream();
			if(image!=null)
			outputStream.write(image);
			outputStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
