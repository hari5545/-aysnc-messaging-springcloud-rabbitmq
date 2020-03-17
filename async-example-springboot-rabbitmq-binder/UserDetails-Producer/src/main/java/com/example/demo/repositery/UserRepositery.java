package com.example.demo.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserDetail;



@Repository
public interface UserRepositery extends JpaRepository<UserDetail,Integer>{

}