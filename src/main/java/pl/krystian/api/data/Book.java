package pl.krystian.api.data;

public class Book {

	private Long bookID;
	private String title;
	private String authorFirstName;
	private String authorSurename;
	private short yearOfPublishment;
	
	
	
	public Long getBookID() {
		return bookID;
	}
	public void setBookID(Long bookID) {
		this.bookID = bookID;
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
	public String getAuthorSurename() {
		return authorSurename;
	}
	public void setAuthorSurename(String authorSurename) {
		this.authorSurename = authorSurename;
	}
	public short getYearOfPublishment() {
		return yearOfPublishment;
	}
	public void setYearOfPublishment(short yearOfPublishment) {
		this.yearOfPublishment = yearOfPublishment;
	}
}
