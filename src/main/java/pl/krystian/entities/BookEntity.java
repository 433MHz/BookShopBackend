package pl.krystian.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookID")
	private Long id;
	
	@Column(name = "bookTitle")
	private String title;
	
	@Column(name = "bookAuthorFirstName")
	private String authorFirstName;
	
	@Column(name = "bookAuthorSurename")
	private String authorSurname;
	
	@Column(name = "bookPublishmentYear")
	private short year;
	
	@Column(name = "categoryID")
	private CategoryEntity category;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorFirstName() {
		return authorFirstName;
	}
	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}
	public String getAuthorSurname() {
		return authorSurname;
	}
	public void setAuthorSurname(String authorSurname) {
		this.authorSurname = authorSurname;
	}
	public short getYear() {
		return year;
	}
	public void setYear(short year) {
		this.year = year;
	}
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
}
