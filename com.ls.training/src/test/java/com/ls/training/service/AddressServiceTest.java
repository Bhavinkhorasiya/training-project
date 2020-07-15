package com.ls.training.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.ls.training.TrainingApplication;
import com.ls.training.dto.AddressDTO;
import com.ls.training.service.AddressService;

@SpringBootTest
@ContextConfiguration(classes = { TrainingApplication.class })
public class AddressServiceTest {

	@Autowired
	private AddressService addressService;

	@Test
	void save() {
		AddressDTO addressDTO = new AddressDTO();// create object for storing data
		addressDTO.setLine1("57, shak market");
		addressDTO.setLine2("Meghani nagar");
		addressDTO.setCity("Ahmedabad");
		addressDTO.setState("Gujarat");
		addressDTO.setCountry("India");
		addressDTO = addressService.save(addressDTO); // save data in address DTO
		assertTrue(addressDTO.getId() > 0);
	}

	@Test
	void get() {
		AddressDTO addressDTO = addressService.get(11L); // get data from address service and store in addressDTO
		assertNotNull(addressDTO);
	}

	@Test
	void update() {
		AddressDTO addressDTO = addressService.get(11L); // get data from address service and store in addressDTO
		addressDTO.setLine1("block");
		addressDTO.setLine2("Netajinagar");
		addressDTO = addressService.update(addressDTO); // update method call
		assertTrue(addressDTO.getLine2().equals("Navarangpura"));
	}

	@Test
	void getByState() {
		List<AddressDTO> addressDTOs = addressService.getByState("Gujarat"); // get List from AddressService and store
																				// in list of addressDTO
		assertTrue(addressDTOs.size() > 0);
	}

	@Test
	void delete() {
		AddressDTO addressDTO = addressService.get(362L);
		addressDTO = addressService.delete(addressDTO);
		assertTrue(addressDTO.getId() > 0);
	}

}