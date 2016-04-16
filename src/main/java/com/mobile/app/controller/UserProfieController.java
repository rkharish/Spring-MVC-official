package com.mobile.app.controller;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.mobile.app.controller.model.ui.UserProfile;
import com.mobile.app.dao.entity.UserProfileEntity;
import com.mobile.app.service.IAuthService;

@Controller  ///@Component,@Repository,@Service
//@Controller - means this class is working as model for spring mvc
public class UserProfieController {
	
	@Autowired
	@Qualifier("AuthService")
	private IAuthService iAuthService;
	
	@RequestMapping(value="kill",method=RequestMethod.GET)
	public String killPage() {
		return "kill";
	}
	
	@RequestMapping(value="sortByUsernameAsc",method=RequestMethod.GET)
	public String sortUserProfileUserName(Model model) {
		List<UserProfile> userProfiles=iAuthService.findUserProfiles();
		Collections.sort(userProfiles);
		model.addAttribute("userProfiles",userProfiles);
		return "users";
	}
	
	@RequestMapping(value="editProfile",method=RequestMethod.GET)
	public String editUserProfile(@RequestParam("uid") String uid,Model model) {
		//creating blank object of user profile
		UserProfile userProfile=iAuthService.findUserProfileByPid(uid);
		model.addAttribute("profile",userProfile);
		return "editUserProfile";
	}
	
	@RequestMapping(value="editProfile",method=RequestMethod.POST)
	public String editUserProfileSubmit(@ModelAttribute("profile") UserProfile profile,Model model) {
		//creating blank object of user profile
		String userProfile=iAuthService.updateProfile(profile);
		 List<UserProfile> userProfiles=iAuthService.findUserProfiles();
		model.addAttribute("userProfiles",userProfiles);
		return "users";
	}
	
	@RequestMapping(value="deleteUserProfile",method=RequestMethod.GET)
	public String profiles(@RequestParam("uid") String uid,Model model) {
		//creating blank object of user profile
		String result=iAuthService.deleteUserProfileById(uid);
	     List<UserProfile> userProfiles=iAuthService.findUserProfiles();
		model.addAttribute("userProfiles",userProfiles);
		return "users";
	}
	
	@RequestMapping(value="profiles",method=RequestMethod.GET)
	public String profiles(Model model) {
		//creating blank object of user profile
		 List<UserProfile> userProfiles=iAuthService.findUserProfiles();
		model.addAttribute("userProfiles",userProfiles);
		return "users";
	}
	
	@RequestMapping(value="userProfile",method=RequestMethod.GET)
	public String userProfilePage(Model model) {
		//creating blank object of user profile
		UserProfileEntity profile=new UserProfileEntity();
		model.addAttribute("profileCommand",profile);
		return "userProfile";
	}
	
	@RequestMapping(value="userProfile",method=RequestMethod.POST)
	public String userProfileSubmit(@ModelAttribute("profileCommand") UserProfile profile,Model model) {
		//creating blank object of user profile
		System.out.println(profile);
		profile.setDoe(new Timestamp(new Date().getTime()));
		iAuthService.addProfile(profile);
		model.addAttribute("ApplicationMessage", "User profile is created successfully for username "+profile.getUsername());
		return "login";
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
             // to actually be able to convert Multipart instance to byte[]
             // we have to register a custom editor
             binder.registerCustomEditor(byte[].class,
                                new ByteArrayMultipartFileEditor());
             // now Spring knows how to handle multipart object and convert them
    }

}
