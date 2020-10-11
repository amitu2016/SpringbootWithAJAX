package com.app.SpringbootWithAJAX.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.SpringbootWithAJAX.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
