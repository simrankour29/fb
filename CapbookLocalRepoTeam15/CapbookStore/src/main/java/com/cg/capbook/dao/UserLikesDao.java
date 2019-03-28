package com.cg.capbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capbook.beans.UserLike;

public interface UserLikesDao extends JpaRepository<UserLike, String>{
	@Modifying
	@Query("Update UserLike SET likesNum=1 where statusId=:statusId and emailId=:emailId")
	public Integer UpdateStatusLike(@Param("statusId")Integer statusId,@Param("emailId")String emailId);
	
	@Modifying
	@Query("Update UserLike SET likesNum=0 where statusId=statusId and emailId=:emailId")
	public Integer UpdateStatusDisLike(@Param("statusId")Integer statusId,@Param("emailId")String emailId);
	
	@Query("Select count(*) from userLike where likesNum=1 and statusId=:statusId and emailId=:emailId")
	public Integer getLikesCount(@Param("statusId")Integer statusId,@Param("emailId")String emailId);
}
