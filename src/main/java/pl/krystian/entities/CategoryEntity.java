package pl.krystian.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "categoryID")
	private Long id;
	
	@Column(name = "categoryName")
	private String name;
	
	@Column(name = "booksList")
	private List<BookEntity> listOfBooks = new ArrayList<>();
	
	
	public String getCategoryName() {
		return name;
	}
	public void setCategoryName(String categoryName) {
		this.name = categoryName;
	}
	public List<BookEntity> getListOfBooks() {
		return listOfBooks;
	}
	public void setListOfBooks(List<BookEntity> listOfBooks) {
		this.listOfBooks = listOfBooks;
	}
}
