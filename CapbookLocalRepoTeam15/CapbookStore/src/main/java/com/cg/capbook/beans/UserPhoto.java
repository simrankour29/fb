package com.cg.capbook.beans;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
@Entity
public class UserPhoto {
	@Id
	@GeneratedValue
	private int photoId;
	private String imageURL;
	private String emailId;
	private File photoFile;
	LocalDate dateOfPost;
	@ManyToOne
	UserAccount userAccount;
	
	@OneToMany(mappedBy="userPhoto")
	private List<UserLike> userLike;
	
	@OneToMany(mappedBy="userPhoto")
	private List<UserPostComment> userComment;
	
	@OneToMany(mappedBy="userPhoto")
	private List<UserTag> userTag;

	public UserPhoto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
