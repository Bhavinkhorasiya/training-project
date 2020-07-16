package com.ls.training.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ls.training.dto.OfficeDetailsDTO;
import com.ls.training.entity.OfficeDetails;
import com.ls.training.repository.OfficeDetailsRepository;
import com.ls.training.service.OfficeDetailsService;

@Service
@Transactional
@Component
public class OfficeDetailsServiceImpl implements OfficeDetailsService {

	@Autowired
	private OfficeDetailsRepository officeDetailsRepository;
	
	@Override
	public OfficeDetailsDTO get(Long id) {
		OfficeDetails officeDetails = officeDetailsRepository.getOne(id);
		OfficeDetailsDTO officeDetailsDTO = new OfficeDetailsDTO();
		BeanUtils.copyProperties(officeDetails, officeDetailsDTO);
		return officeDetailsDTO;
	}

	@Override
	public OfficeDetailsDTO save(OfficeDetailsDTO officeDetailsDTO) {
		OfficeDetails officeDetails = new OfficeDetails();
		BeanUtils.copyProperties(officeDetailsDTO, officeDetails);
		
		officeDetails = officeDetailsRepository.save(officeDetails);
		BeanUtils.copyProperties(officeDetails, officeDetailsDTO);
		
		return officeDetailsDTO;
	}

	@Override
	public OfficeDetailsDTO update(OfficeDetailsDTO officeDetailsDTO) {
		OfficeDetails officeDetails = officeDetailsRepository.getOne(officeDetailsDTO.getId());
		BeanUtils.copyProperties(officeDetailsDTO, officeDetails);
		officeDetails = officeDetailsRepository.save(officeDetails);
		BeanUtils.copyProperties(officeDetails, officeDetailsDTO);
		return officeDetailsDTO;
	}

	@Override
	public OfficeDetailsDTO delete(long id) {
		OfficeDetails officeDetails = officeDetailsRepository.getOne(id);// TODO Auto-generated method stub
		officeDetailsRepository.delete(officeDetails);
		OfficeDetailsDTO officeDetailsDTO = new OfficeDetailsDTO();
		BeanUtils.copyProperties(officeDetails, officeDetailsDTO);
		return officeDetailsDTO;
	}

}
