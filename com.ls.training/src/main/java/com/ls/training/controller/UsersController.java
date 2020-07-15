package com.ls.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ls.training.dto.UsersDTO;
import com.ls.training.service.UserService;

@RestController
@RequestMapping(path = "/users")
public class UsersController {

	@Autowired
	private UserService userService;

	@GetMapping("/{uid}")
	public UsersDTO get(@PathVariable("uid") Long uid) {
		return userService.get(uid);
	}

	@PostMapping()
	public UsersDTO save(@RequestBody UsersDTO usersDTO) {
		return userService.save(usersDTO);
	}

	@PutMapping()
	public UsersDTO update(@RequestBody UsersDTO usersDTO) {
		return userService.update(usersDTO);
	}

	@GetMapping("/email/{email}")
	public List<UsersDTO> getByEmail(@PathVariable("email") String email) {
		return userService.getByEmail(email);
	}

	@DeleteMapping("/delete/{uid}")
	public UsersDTO delete(@PathVariable("uid") UsersDTO uid) {
		return userService.delete(uid);
	}

}
