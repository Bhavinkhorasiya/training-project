
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
import com.ls.training.dto.AuthorsDTO;
import com.ls.training.dto.BookDTO;
import com.ls.training.dto.OfficeDetailsDTO;
import com.ls.training.dto.UsersDTO;
import com.ls.training.service.UserService;

@SpringBootTest
@ContextConfiguration(classes = { TrainingApplication.class })
public class UserServiceTest {

	@Autowired
	private UserService usersService;

	@Autowired
	private OfficeDetailsService officeDetailsService;

	@Autowired
	private BookService bookService;
	

	@Test
	void save() {
		UsersDTO usersDTO = new UsersDTO(); // create userDTO object and set value of userdto
		usersDTO.setFirstName("JINAL");
		usersDTO.setLastName("JOSHI");
		usersDTO.setEmail("jinal@gmail.com");
		usersDTO.setMobile("7874423660");
		usersDTO.setPassword("admin");

		AddressDTO addressDTO = new AddressDTO(); // create AddressDTO object and set value of Addressdto
		addressDTO.setLine1("ratnadeep tower CP nagar");
		addressDTO.setLine2("Ghatlodia ");
		addressDTO.setCity("Ahmedabad");
		addressDTO.setState("Gujarat");
		addressDTO.setCountry("india");
		usersDTO.setAddressDTO(addressDTO);

		OfficeDetailsDTO officeDetailsDTO = officeDetailsService.get(448L);
		usersDTO.setOfficeDetailsDTO(officeDetailsDTO);
		
		BookDTO bookDTO = bookService.get(449L);
		usersDTO.setOfficeDetailsDTO(officeDetailsDTO);
		
		usersDTO.setBookDTO(bookDTO);
		usersDTO = usersService.save(usersDTO);// save the userdto
		
		
		assertTrue(usersDTO.getPassword().equals("admin"));
	}

	@Test
	void get() {
		UsersDTO usersDTO = usersService.get(436L); // get data from user service
		assertNotNull(usersDTO);
	}

	@Test
	void update() {
		UsersDTO usersDTO = usersService.get(392L);// get data from user service and store userDTO object and set data
		usersDTO.setFirstName("Aarohi");
		usersDTO.setLastName("Tiwari");
		usersDTO.setEmail("aarohi@gmail.com");
		usersDTO.setMobile("7874423660");
		usersDTO.setPassword("jinal");

		AddressDTO addressDTO = usersDTO.getAddressDTO();// create object for Address DTO and store data \
		addressDTO.setLine1("43/306 Laxmi bhavan");
		addressDTO.setLine2("ratnadepp tower");
		addressDTO.setCity("ahmedabad");
		addressDTO.setState("ahmedabad");
		addressDTO.setCountry("India");
		usersDTO.setAddressDTO(addressDTO);

		BookDTO bookDTO = bookService.get(382L);
		usersDTO.setBookDTO(bookDTO);

		usersDTO = usersService.update(usersDTO);// update userDTO
		assertTrue(usersDTO.getUid() > 0);
	}

	@Test
	void getByEmail() {
		List<UsersDTO> usersDTOs = usersService.getByEmail("aarohi@gmail.com"); // get data from userservice getbyemail
		assertTrue(usersDTOs.size() > 0);
	}

	@Test
	void delete() {
		UsersDTO usersDTO = usersService.get(407L);
		usersDTO = usersService.delete(usersDTO);
		assertTrue(usersDTO.getUid() > 0);
	}
}
