package com.ls.training.dto;

import java.util.List;


public class AuthorsDTO {

	
	private Long aid;
	private String author;
	private List<BookDTO> bookDTO;
	public Long getAid() {
		return aid;
	}
	public void setAid(Long aid) {
		this.aid = aid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public List<BookDTO> getBookDTO() {
		return bookDTO;
	}
	public void setBookDTO(List<BookDTO> bookDTO) {
		this.bookDTO = bookDTO;
	}
	@Override
	public String toString() {
		return "AuthorsDTO [aid=" + aid + ", author=" + author + ", bookDTO=" + bookDTO + "]";
	}
	
	
	
	
	
}
