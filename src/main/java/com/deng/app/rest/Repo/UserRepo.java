package com.deng.app.rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deng.app.rest.Model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
