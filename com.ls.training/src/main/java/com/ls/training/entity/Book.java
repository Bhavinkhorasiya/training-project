package com.ls.training.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@SuppressWarnings("serial")
@Entity
public class Book implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bid;

	@Version
	private int version;
	@Basic
	private String title;
	@Basic
	private String author;
	@Basic
	private String isbn;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn
	private List<Page> page;

//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
//	private Authors authors;

	public Book() {
		super();
	}

	public Long getBid() {
		return bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

//	public Authors getAuthors() {
//		return authors;
//	}
//
//	public void setAuthors(Authors authors) {
//		this.authors = authors;
//	}

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

	public List<Page> getPage() {
		return page;
	}

	public void setPage(List<Page> page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", version=" + version + ", title=" + title + ", author=" + author + ", isbn="
				+ isbn + ", page=" + page + "]";
	}

}