package com.ls.training.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ls.training.dto.PageDTO;
@Service
@Component
public interface PageService {
	public PageDTO delete(long id);
	public PageDTO get(long id);
	public PageDTO update(PageDTO pageDTO);
}
