package com.cg.capbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capbook.beans.UserStatus;

public interface UserStatusDao extends JpaRepository<UserStatus, String> {

}
