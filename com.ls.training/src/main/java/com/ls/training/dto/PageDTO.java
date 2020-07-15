package com.ls.training.dto;

import java.util.List;

public class PageDTO {

	private Long id;
	private int number;
	private String content;
	private String chapter;

//	private List<BookDTO> bookDTO;

	public PageDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

//	public List<BookDTO> getBookDTO() {
//		return bookDTO;
//	}
//
//	public void setBookDTO(List<BookDTO> bookDTO) {
//		this.bookDTO = bookDTO;
//	}

	@Override
	public String toString() {
		return "PageDTO [id=" + id + ", number=" + number + ", content=" + content + ", chapter=" + chapter
				+  "]";
	}

}
