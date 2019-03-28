package com.cg.capbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.beans.UserLogin;
import com.cg.capbook.beans.UserPhoto;
import com.cg.capbook.beans.UserPostComment;
import com.cg.capbook.beans.UserStatus;
import com.cg.capbook.beans.UserTag;
import com.cg.capbook.dao.UserCommentDao;
import com.cg.capbook.dao.UserDAO;
import com.cg.capbook.dao.UserLikesDao;
import com.cg.capbook.dao.UserPhotoDao;
import com.cg.capbook.dao.UserProfilePictureDao;
import com.cg.capbook.dao.UserStatusDao;
import com.cg.capbook.dao.UserTagsDao;
import com.cg.capbook.exceptions.EmailAlreadyExistException;
import com.cg.capbook.exceptions.UserNotFoundException;

@Component("userServices")
public class UserServicesImpl implements UserServices{

	@Autowired
	private UserDAO userDao;
	@Autowired
	private UserCommentDao commentDao;
	@Autowired
	private UserLikesDao likeDao;
	@Autowired
	private UserTagsDao tagDao;
	@Autowired
	private UserStatusDao statusDao;
	@Autowired
	private UserPhotoDao photoDao;
	@Autowired
	private UserProfilePictureDao profilePiccDao;
	
	private UserAccount userAccount = new UserAccount();
	
	@Override
	public UserAccount acceptUserDetails(UserAccount user) {
		return userDao.save(user);
	}

	@Override
	public boolean removeUserDetails(String emailId) {
		userDao.deleteById(emailId);
		return true;
	}

	@Override
	public boolean CheckUserDetails(String emailId) throws EmailAlreadyExistException {
		if(emailId==userAccount.getEmailId())
			throw new EmailAlreadyExistException();
		return true;
	}

	@Override
	public UserAccount getUserDetails(String emailId) throws UserNotFoundException {
		return userDao.findById(emailId).orElseThrow(()->new UserNotFoundException("user not found"));
	}

	public UserAccount validateUser(UserLogin login) {
	    return userDao.findById(login.getEmailId()).get();
	  }

	@Override
	public UserPhoto postPhoto(UserPhoto photo) {
		return photoDao.save(photo);
	}

	@Override
	public UserStatus postStatus(UserStatus status) {
		return statusDao.save(status);
	}

	@Override
	public UserPostComment doCommentOnPost(UserPostComment usersComment) {
		return commentDao.save(usersComment);
	}

	@Override
	public UserTag tagUsers(UserTag userTag) {
		return tagDao.save(userTag);
	}
}
