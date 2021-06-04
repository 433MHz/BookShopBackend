package pl.krystian.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.boot.context.properties.bind.DefaultValue;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
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
	
	@ManyToOne
	@JoinColumn(name = "category_id" ,nullable = true)
	private CategoryEntity category;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	
	
	
	public BookEntity() {
	}
	
	public BookEntity(Long id, String title, String authorFirstName, String authorSurname, short year,
			CategoryEntity category) {
		super();
		this.id = id;
		this.title = title;
		this.authorFirstName = authorFirstName;
		this.authorSurname = authorSurname;
		this.year = year;
		this.category = category;
	}
	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", title=" + title + ", authorFirstName=" + authorFirstName + ", authorSurname="
				+ authorSurname + ", year=" + year + ", category=" + category + "]";
	}
	
	
	
}
