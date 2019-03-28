package com.cg.capbook.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.beans.UserLogin;
import com.cg.capbook.beans.UserPhoto;
import com.cg.capbook.beans.UserPostComment;
import com.cg.capbook.beans.UserTag;
import com.cg.capbook.exceptions.EmailAlreadyExistException;
import com.cg.capbook.services.UserServices;

@Controller
public class UserServiceController {
	
	@Autowired
	private UserServices userServices;
	
	@RequestMapping("/registerUser")//action in JSP page
	public ModelAndView registerUser(@Valid @ModelAttribute UserAccount userAccount,BindingResult result) throws EmailAlreadyExistException {
		if(result.hasErrors())
			return new ModelAndView("RegistrationPage");
		userAccount=userServices.acceptUserDetails(userAccount);
		return new ModelAndView("RegistrationSuccessPage","userAccount",userAccount);//JSP page name
	} 
	@RequestMapping("/doCommentOnPost")
	public ModelAndView userCommenting(@RequestParam UserPostComment userPostComment) {
		UserPostComment userComment=userServices.doCommentOnPost(userPostComment);
		return new ModelAndView("UserPostCommentPage","userComment",userComment);
	}
	@RequestMapping("/postPhoto")
	public ModelAndView postPhoto(@RequestParam UserPhoto photo){
		UserPhoto userPhoto=userServices.postPhoto(photo);
		return new ModelAndView("userWallPage","userPhoto",photo);
	}
	@RequestMapping("/postPhoto")
	public ModelAndView tagUsers(@RequestParam UserTag userTag) {
		UserTag tag=userServices.tagUsers(userTag);
		return new ModelAndView("userWallPage","userPhoto",tag);
	}
}
