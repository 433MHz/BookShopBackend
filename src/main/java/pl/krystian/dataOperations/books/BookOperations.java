package pl.krystian.dataOperations.books;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.krystian.api.BookCategoryIdHolder;
import pl.krystian.entities.BookEntity;
import pl.krystian.entities.CategoryEntity;
import pl.krystian.jpa.repositories.BookRepository;
import pl.krystian.jpa.repositories.CategoryRepository;

@Component
public class BookOperations {
	
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;

	public List<BookEntity> getAll() {
		return bookRepo.findAll();
	}

	public String editConnections(BookCategoryIdHolder book) {
		
		if(bookRepo.existsById(book.getBookID())) {
			if(categoryRepo.existsById(book.getCategoryID())) {
				BookEntity bookEntity = bookRepo.getById(book.getBookID());
				CategoryEntity categoryEntity = categoryRepo.getById(book.getCategoryID());
				
				bookEntity.setCategory(categoryEntity);
								
				try {
					bookRepo.save(bookEntity);
					return "Book category added";
				}catch (Exception e) {
					return "Unknown exception";
				}
			}
			else {
				return "There is not any category with this ID";
			}
		}
		else {
			return "There is not any book with this ID";
		}
	}
	
	public String update(BookEntity book) {
		if(bookRepo.existsById(book.getId())) {
			BookEntity originalBook = bookRepo.getById(book.getId());
			
			if(book.getTitle() != null) {
				originalBook.setTitle(book.getTitle());
			}
			if(book.getAuthorFirstName() != null) {
				originalBook.setAuthorFirstName(book.getAuthorFirstName());
			}
			if(book.getAuthorSurname() != null) {
				originalBook.setAuthorSurname(book.getAuthorSurname());
			}
			if(book.getYear() != 0) {
				originalBook.setYear(book.getYear());
			}
			
			try {
				bookRepo.save(originalBook);
				return "Entity edited";
			} catch (Exception e) {
				return "Database error";
			}
		}
		else {
			return "Entity need to have id";
		}
	}
	
	public String delete(BookCategoryIdHolder book) {
		
		if(bookRepo.existsById(book.getBookID())) {
		
			try {
				bookRepo.deleteById(book.getBookID());
				return "Book removed";
			} catch (Exception e) {
				return "Problem with database";
			}
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
