package pl.krystian.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.krystian.dataOperations.books.BookOperations;
import pl.krystian.entities.BookEntity;

@RestController
@RequestMapping(path = "/books")
public class BooksApi {
	
	@Autowired
	BookOperations operation;

	@PostMapping("/add")
	public String addCategory(@RequestBody BookEntity book) {
		return operation.add(book);
	}
	
	@PatchMapping("/update")
	public String editCategory(@RequestBody BookEntity book) {
		return operation.edit(book);
	}
	
	@DeleteMapping("/delete")
	public String deleteCategory(@RequestBody BookEntity book) {
		return operation.delete(book);
	}
	
	@GetMapping("/getAll")
	public List<BookEntity> getAllCategories() {
		return operation.getAll();
	}
	
	@GetMapping("/getById")
	public BookEntity getById(@RequestBody Long id) {		
		return operation.getById(id);
	}
	
	@GetMapping("/getByTitle")
	public BookEntity getByName(@RequestBody String title) {
		return operation.getByTitle(title);
	}

}
