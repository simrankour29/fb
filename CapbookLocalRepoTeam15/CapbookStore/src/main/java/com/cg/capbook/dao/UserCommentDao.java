package com.cg.capbook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capbook.beans.UserPostComment;

public interface UserCommentDao extends JpaRepository<UserPostComment, String>{
	@Query("from UserPostComment where photoId=:photoId")
	public List<UserPostComment> getAllCommentsfromPhoto(@Param("photoId")Integer photoId);
	
	@Query("from UserPostComment where statusId=:statusId")
	public List<UserPostComment> getAllCommentsfromStatus(@Param("statusId")Integer statusId);
}
