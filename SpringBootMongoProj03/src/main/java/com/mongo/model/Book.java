package com.mongo.model;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "book1")
public class Book {

	@Id
	private String id;
	private String title;
	private String isbn;
	private Integer pageCount;
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private Date publishedDate;
	private String thumbnailUrl;
	private String shortDescription;
	private String longDescription;
	private String status;
	private String[] authors;
	private String[] categories;
}
