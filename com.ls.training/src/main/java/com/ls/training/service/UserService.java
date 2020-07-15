package com.ls.training.service;
import java.util.List;

import com.ls.training.dto.UsersDTO;

public interface UserService {
	public UsersDTO save(UsersDTO usersDTO);
	public UsersDTO get(Long id);
	public UsersDTO update(UsersDTO usersDTO);
	public List<UsersDTO> getByEmail(String email);
	public UsersDTO delete(UsersDTO userDTO);
}
