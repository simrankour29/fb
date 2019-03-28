package com.cg.capbook.services;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.beans.UserLogin;
import com.cg.capbook.beans.UserPhoto;
import com.cg.capbook.beans.UserPostComment;
import com.cg.capbook.beans.UserStatus;
import com.cg.capbook.beans.UserTag;
import com.cg.capbook.exceptions.EmailAlreadyExistException;
import com.cg.capbook.exceptions.UserNotFoundException;


public interface UserServices {
	UserAccount acceptUserDetails(UserAccount user) throws EmailAlreadyExistException;
	boolean removeUserDetails(String emailId);
	boolean CheckUserDetails(String emailId) throws EmailAlreadyExistException;
	UserAccount getUserDetails(String emailId)throws UserNotFoundException;
	UserAccount validateUser(UserLogin login);
	UserPhoto postPhoto(UserPhoto photo);
	UserStatus postStatus(UserStatus status);
	UserPostComment doCommentOnPost(UserPostComment usersComment);
	UserTag tagUsers(UserTag userTag);
}