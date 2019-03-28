package com.cg.capbook.beans;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class UserStatus {
	@Id
	@GeneratedValue
	private int statusId;
	String emailId;
	String status;
	LocalDate dateOfPost;
	@ManyToOne
	 UserAccount userAccount;
	
	@OneToMany(mappedBy="userStatus")
	private List<UserLike> userLike;
	
	@OneToMany(mappedBy="userStatus")
	private List<UserPostComment> userComment;
	
	@OneToMany(mappedBy="userStatus")
	private List<UserTag> userTag;
	
	public UserStatus() {
		super();
		// TODO Auto-generated constructor stub
	}


}
