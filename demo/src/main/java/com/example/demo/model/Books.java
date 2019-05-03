package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="books")
@Getter
@Setter
public class Books {

	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="book_id")
	private Integer id;
	
	@Column(name="title")
	@NotNull
	private String title;
	
	@Column(name="author")
	@NotNull
	private String author;
}
