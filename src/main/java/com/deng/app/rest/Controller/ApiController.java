package com.deng.app.rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.deng.app.rest.Model.User;
import com.deng.app.rest.Repo.UserRepo;

@RestController
public class ApiController {
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping(value = "/")
	public String getPage() {
		return "Hello there!";
	}
	
	@GetMapping(value = "/users")
	public List<User> getUsers() {
		return userRepo.findAll();
	}
	
	@PostMapping(value = "/save")
	public String saveUser(@RequestBody User user) {
		userRepo.save(user);
		return "Save successfully.";
	}
	
	@PutMapping(value = "/update/{id}")
	public String updateUser(@PathVariable long id, @RequestBody User user) {
		User updateUser = userRepo.findById(id).get();
		updateUser.setFirstName(user.getFirstName());
		updateUser.setLastName(user.getLastName());
		updateUser.setAge(user.getAge());
		updateUser.setOccupation(user.getOccupation());
		userRepo.save(updateUser);
		return "Update successfully.";
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteUser(@PathVariable long id) {
		User deleteUser = userRepo.findById(id).get();
		userRepo.delete(deleteUser);		
		return "Delete successfully.";
	}
	
}
