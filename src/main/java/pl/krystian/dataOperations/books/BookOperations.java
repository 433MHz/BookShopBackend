package pl.krystian.dataOperations.books;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.krystian.entities.BookEntity;
import pl.krystian.jpa.repositories.BookRepository;

@Component
public class BookOperations {
	
	@Autowired
	BookRepository bookRepo;

	public List<BookEntity> getAll() {
		return bookRepo.findAll();
	}

	public String edit(BookEntity book) {
		
		if(bookRepo.existsById(book.getId())) {
			bookRepo.save(book);
			return "Book updated";
		}
		else {
			return "There is not any book with this ID";
		}
	}
	
	public String delete(BookEntity book) {
		
		if(bookRepo.existsById(book.getId())) {
			bookRepo.deleteById(book.getId());
			return "Book removed";
		}
		else {
			return "There is not any book with this ID";
		}
	}

	public String add(BookEntity book) {
		
		try {
			bookRepo.save(book);
			return "Book saved";
			
		} catch (Exception e) {
			return e.toString();
		}
	}

	public BookEntity getById(Long id) {
		Optional<BookEntity> book = bookRepo.findById(id);
		
		try {
			return book.get();
			
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public BookEntity getByTitle(String title) {
				
		BookEntity book = bookRepo.findByTitle(title);
				
		if(book != null) {
			return book;
		}
		else {
			return null;
		}
	}
}
