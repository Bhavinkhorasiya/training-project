package com.ls.training.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.ls.training.dto.AddressDTO;
import com.ls.training.dto.BookDTO;
import com.ls.training.dto.OfficeDetailsDTO;
import com.ls.training.dto.UsersDTO;
import com.ls.training.entity.Address;
import com.ls.training.entity.Book;
import com.ls.training.entity.OfficeDetails;
import com.ls.training.entity.Users;
import com.ls.training.repository.BookRepository;
import com.ls.training.repository.OfficeDetailsRepository;
import com.ls.training.repository.UsersRepository;
import com.ls.training.service.UserService;

@Service
@Transactional
@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UsersRepository userRepository;
	@Autowired
	private OfficeDetailsRepository officeDetailsRepository;
	
	@Autowired
	private BookRepository bookRepository;
	

	@Override
	public UsersDTO save(UsersDTO usersDTO) {
		Users users = new Users();// create blank user entity object
		BeanUtils.copyProperties(usersDTO, users);// copy properties userDTO in Users entity

		Address address = new Address();// create blank address entity object
		BeanUtils.copyProperties(usersDTO.getAddressDTO(), address);// copy properties in address entity from addressDTO

		OfficeDetails  officeDetails = officeDetailsRepository.getOne(usersDTO.getOfficeDetailsDTO().getId());
		Book book = bookRepository.getOne(usersDTO.getBookDTO().getBid());
		
		users.setBook(book);
		users.setOfficeDetails(officeDetails);
		users.setAddress(address);// set address in user
		
		users = userRepository.save(users);// save users
		BeanUtils.copyProperties(users, usersDTO);// copy property in DTO from object
		return usersDTO;
	}

	@Override
	public UsersDTO get(Long id) {

		Users users = userRepository.getOne(id);// get id from user repository
		UsersDTO usersDTO = new UsersDTO();// creare userdto object
		BeanUtils.copyProperties(users, usersDTO);// copy property in DTO from object
		
		Address address = users.getAddress();// create address entity object
		AddressDTO addressDTO = new AddressDTO();// create address DTO ibject
		BeanUtils.copyProperties(address, addressDTO);// copy property in DTO from object
		
		OfficeDetails officeDetails  = users.getOfficeDetails();
		OfficeDetailsDTO officeDetailsDTO = new OfficeDetailsDTO();
		BeanUtils.copyProperties(officeDetails, officeDetailsDTO);
		
		Book book =users.getBook();
		BookDTO bookDTO = new BookDTO();
		BeanUtils.copyProperties(book, bookDTO);
		
		usersDTO.setBookDTO(bookDTO);
		usersDTO.setOfficeDetailsDTO(officeDetailsDTO);
		usersDTO.setAddressDTO(addressDTO);// set addressDTO in userDTO
		
		return usersDTO;
	}

	@Override
	public UsersDTO update(UsersDTO usersDTO) {
		Users users = userRepository.getOne(usersDTO.getUid());// get data from user repository and store in entity object
		BeanUtils.copyProperties(usersDTO, users);// copy property in object from DTO
		
		Address address = new Address();// create user entity object
		BeanUtils.copyProperties(usersDTO.getAddressDTO(), address);// copy property in entity object from DTO
		
		Book book =  new Book();
		BeanUtils.copyProperties(usersDTO.getBookDTO(), book);

		users.setBook(book);
		users.setAddress(address);
		
		users = userRepository.save(users);// save data and store in user entity
		BeanUtils.copyProperties(users, usersDTO);// copy property in DTO from entity Object
		
		return usersDTO;

	}

	@Override
	public List<UsersDTO> getByEmail(String email) {
		List<Users> userses = userRepository.getByEmail(email); // get list of user entity whichever i getr fron user
		List<UsersDTO> usersDTOs = new ArrayList<UsersDTO>(); // create new object of userDTO create foreach for getting data in users entity and copy in usersDTO
		userses.stream().forEach(users -> {
			UsersDTO usersDTO = new UsersDTO();// create new dto storing data
			BeanUtils.copyProperties(users, usersDTO);
			usersDTOs.add(usersDTO); // add dto in userdto list
		});
		return usersDTOs;
	}

	@Override
	public UsersDTO delete(long uid) {//long che 
		Users users = userRepository.getOne(uid);
		userRepository.delete(users);
		UsersDTO usersDTO = new UsersDTO();
		BeanUtils.copyProperties(users, usersDTO);
		return usersDTO;
	}

}
