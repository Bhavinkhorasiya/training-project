package com.ls.training.dto;

import java.util.List;

public class BookDTO {

	private Long bid;
	private int version;
	private String title;
	private String author;
	private String isbn;
	private List<PageDTO> pageDTO;
//	private UsersDTO usersDTO;
//	private AuthorsDTO  authorsDTO;

//	
//	public AuthorsDTO getAuthorsDTO() {
//		return authorsDTO;
//	}
//
//	public void setAuthorsDTO(AuthorsDTO authorsDTO) {
//		this.authorsDTO = authorsDTO;
//	}
//
//	public UsersDTO getUsersDTO() {
//		return usersDTO;
//	}
//
//	public void setUsersDTO(UsersDTO usersDTO) {
//		this.usersDTO = usersDTO;
//	}

	public BookDTO() {
		super();
	}

	public Long getBid() {
		return bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<PageDTO> getPageDTO() {
		return pageDTO;
	}

	public void setPageDTO(List<PageDTO> pageDTO) {
		this.pageDTO = pageDTO;
	}

	@Override
	public String toString() {
		return "BookDTO [id=" + bid + ", version=" + version + ", title=" + title + ", author=" + author + ", isbn="
				+ isbn + ", pageDTO=" + pageDTO + "]";
	}

}
