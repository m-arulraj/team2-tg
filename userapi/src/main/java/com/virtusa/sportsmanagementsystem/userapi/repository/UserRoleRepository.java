package com.virtusa.sportsmanagementsystem.userapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.sportsmanagementsystem.userapi.domain.User;
import com.virtusa.sportsmanagementsystem.userapi.domain.UserRole;



@Repository
public interface UserRoleRepository extends JpaRepository<UserRole	, Integer>{
	@Modifying
	@Query("update UserRole u set u.user = :user  where u.id = :id ")
	 int updateuserRole(@Param("user") User user,@Param("id") int id);
	
	@Query("select u from UserRole u  where u.user = :user ")
	 UserRole findUserRole(@Param("user") User user);
	
	@Query("select u.role from UserRole u ")
	 List<String> findUserRoles();
}
