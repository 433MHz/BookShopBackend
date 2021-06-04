package pl.krystian.dataOperations.books;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pl.krystian.api.BookCategoryIdHolder;
import pl.krystian.entities.BookEntity;
import pl.krystian.entities.CategoryEntity;
import pl.krystian.jpa.repositories.BookRepository;
import pl.krystian.jpa.repositories.CategoryRepository;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookOperationsTest {
	
	@Mock
	BookRepository bookRepo;
	
	@Mock
	CategoryRepository categoryRepo;
	
	@InjectMocks
	BookOperations bookOperations = new BookOperations();

	private final BookEntity defaultBookEntity = new BookEntity(1L, "Book title", "Author First Name", "Author Last Name", (short) 1999, null);
	private final CategoryEntity defaultCategoryEntity = new CategoryEntity(2L, "Komedia", null);
	
	@BeforeAll
	void set() {
		MockitoAnnotations.openMocks(this);
	}
	
	
//	EditConnections class tests
	@Nested
	@DisplayName("editConnections method test")
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	class testEditConnections {
		
		private BookEntity bookFetchedFromDatabase;
		private CategoryEntity categoryFetchedFromDatabase;
		
		private String messageWhenCategoryIdNotFound = "There is not any category with this ID";
		private String messageWhenBookIdNotFound = "There is not any book with this ID";
		private String messageWhenBookUpdated = "Book category added";
		
		@BeforeAll
		void setEditConnections() {
			bookFetchedFromDatabase = defaultBookEntity;
			categoryFetchedFromDatabase = defaultCategoryEntity;
			
			when(bookRepo.existsById(1L)).thenReturn(true);
			when(bookRepo.getById(1L)).thenReturn(bookFetchedFromDatabase);
			when(categoryRepo.existsById(2L)).thenReturn(true);
			when(categoryRepo.getById(2L)).thenReturn(categoryFetchedFromDatabase);
			
			when(bookRepo.existsById(3L)).thenReturn(true);
			when(bookRepo.getById(3L)).thenReturn(null);
			
			when(categoryRepo.existsById(4L)).thenReturn(true);
			when(categoryRepo.getById(4L)).thenReturn(null);
		}
		
		@Test
		void shouldReturn_BookUpdated() {
//			given		
			BookCategoryIdHolder idHolder = new BookCategoryIdHolder(1L, 2L);
			
//			then
			String returnMessage = bookOperations.editConnections(idHolder);
			
//			when			
			assertEquals(messageWhenBookUpdated, returnMessage);
		}
		
		
		@Test
		void shouldReturn_BookIdNotFound() {
//			given
			BookCategoryIdHolder idHolder = new BookCategoryIdHolder(2L, 2L);
			
//			then
			String returnMessage = bookOperations.editConnections(idHolder);
			
//			when
			assertEquals(messageWhenBookIdNotFound, returnMessage);
		}
		
		@Test
		void shouldReturn_CategoryIdNotFound() {
//			given
			BookCategoryIdHolder idHolder = new BookCategoryIdHolder(1L, 1L);
			
//			then
			String returnMessage = bookOperations.editConnections(idHolder);
			
//			when
			assertEquals(messageWhenCategoryIdNotFound, returnMessage);
		}
	}

//	Update class tests
	@Nested
	@DisplayName("update method test")
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	class testUpdate{
		
		private BookEntity bookEntityFromDatabase;
		
		private String entityEditedMessage = "Entity edited";
		private String entityWithoutID = "Entity need to have id";
		
		@BeforeAll
		void setUpdateTest() {
			bookEntityFromDatabase = new BookEntity(1L, "From database", "From database", "From databse", (short) 1990, null);
					
			when(bookRepo.existsById(1L)).thenReturn(true);
			when(bookRepo.getById(1L)).thenReturn(bookEntityFromDatabase);
			
		}
		
		@Test
		void shouldReturn_EntityEdited() {
//			given
			BookEntity entity = defaultBookEntity;
			entity.setId(1L);
						
//			then
			String resultMessage = bookOperations.update(entity);
			
//			when
			assertEquals(entityEditedMessage, resultMessage);
			
		}

		
		@Test
		void shouldReturn_EntityHasNoID() {
//			given
			BookEntity entity = defaultBookEntity;
			entity.setId(null);
			
//			then
			String resultMessage = bookOperations.update(entity);
			
//			when
			assertEquals(entityWithoutID, resultMessage);
		}
		
	}
}
