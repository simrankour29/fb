package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class UserFriend {
	@Id
	String EmailId;
	@ManyToOne
	UserAccount userAccount;
}
