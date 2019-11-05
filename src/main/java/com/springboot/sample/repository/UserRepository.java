package com.springboot.sample.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.sample.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
	User findByEmail(String email);
    
    /*
     * Will return encrypted password using mysql function()
     */
    @Query(value = "SELECT password(?1)", nativeQuery = true)
    String encryptPass(String password);
}
