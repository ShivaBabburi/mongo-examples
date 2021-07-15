package com.mongo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.model.Book;
import com.mongo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookSvc;
	
	@GetMapping("/all")
	public List<Book> getAllBooks(){
		return bookSvc.getAllBooks();
	}
	
	@GetMapping("/init")
	public Book getInitData() {
		return bookSvc.getInitData();
	}
	@PostMapping("/create")
	public String createBook(@RequestBody Book book) {
		return bookSvc.createBook(book);
	}
	@PostMapping("/createAll")
	public String createAllBooks(@RequestBody List<Book> books) {
		return bookSvc.createAllBooks(books);
	}
	
	//Pagination
	@GetMapping("/page")
	public List<Book> getAllBooksByPage(@RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
			@RequestParam(value = "fields",defaultValue = "title,pageCount") String[] fields,
			@RequestParam(value="sortBy",defaultValue = "id") String sortBy){
		return bookSvc.getAllBooksByPage(pageNo,pageSize,fields,sortBy);
		
	}
	
	@GetMapping("/countPage")
	public Map<String, Object> countPage(){
		return bookSvc.countPage();
	}
	
	@GetMapping("/category")
	public Map<String,Object> getByCategory(@RequestParam String[] categories){
		return bookSvc.getByCategories(categories);
	}
}
