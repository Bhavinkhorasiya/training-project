package com.ls.training.service;

import com.ls.training.dto.OfficeDetailsDTO;

public interface OfficeDetailsService {
	public OfficeDetailsDTO get(Long id);
	public OfficeDetailsDTO save(OfficeDetailsDTO officeDetailsDTO);
	public OfficeDetailsDTO update(OfficeDetailsDTO officeDetailsDTO);
	public OfficeDetailsDTO delete(OfficeDetailsDTO officeDetailsDTO);

}
