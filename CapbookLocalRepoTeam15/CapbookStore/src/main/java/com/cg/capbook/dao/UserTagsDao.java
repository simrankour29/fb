package com.cg.capbook.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capbook.beans.UserTag;

public interface UserTagsDao extends JpaRepository<UserTag, String>{
	@Query("from UserTag where photoId=:photoId")
	public List<UserTag>getAllTags(@Param("photoId")Integer photoId);
	
}
