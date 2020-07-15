package com.ls.training.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ls.training.dto.AuthorsDTO;

@Service
@Component
public interface AuthorsService {
	public AuthorsDTO save(AuthorsDTO authorsDTO);

	public AuthorsDTO get(long id);

	public AuthorsDTO update(AuthorsDTO authorsDTO);

	public AuthorsDTO delete(AuthorsDTO authorsDTO);
}
