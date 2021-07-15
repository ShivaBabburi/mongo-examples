package com.mongo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mongo.model.Book;
import com.mongo.repository.BookRepository;
import com.mongodb.BasicDBObject;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	public String createAllBooks(List<Book> books) {
		List<Book> books1 = bookRepo.saveAll(books);

		if (books1 != null) {
			return "Books all saved";
		} else {
			return "Books are not saved";
		}
	}

	public Book getInitData() {
		Book book = new Book();
		return book;
	}

	public String createBook(Book book) {
		Book book1 = bookRepo.save(book);
		if (book1 != null)
			return "Book saved ";
		else
			return "Book not saved";
	}

	public List<Book> getAllBooksByPage(int pageNo, int pageSize, String[] fields, String sortBy) {
		List<Book> books = new ArrayList<Book>();
		Sort sort = Sort.by(sortBy);
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Book> bookPage = bookRepo.findAll(pageable);
		books.addAll(bookPage.getContent());
    	return books;
	}

	public Map<String, Object> countPage() {
		Map<String, Object> response=new HashMap<String,Object>();
		response.put("totalNoOfE :: ", bookRepo.count());
		return response;
		
	}

	public Map<String, Object> getByCategories(String[] categories) {
		Map<String, Object> response=new HashMap<String, Object>();
		
		List<Book> listOfBooks=bookRepo.findByCategories(categories);
		response.put("data", listOfBooks);
		return response;
	}

}
