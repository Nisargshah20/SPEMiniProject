package com.spe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spe.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    User findByEmail(String email);

    User findByUsername(String username);

}