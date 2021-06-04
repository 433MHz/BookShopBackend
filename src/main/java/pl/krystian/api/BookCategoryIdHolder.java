package pl.krystian.api;

public class BookCategoryIdHolder {
	
	private Long bookID;
	private Long categoryID;
	
	
	public Long getBookID() {
		return bookID;
	}
	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}
	public Long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}
	public BookCategoryIdHolder(Long bookID, Long categoryID) {
		super();
		this.bookID = bookID;
		this.categoryID = categoryID;
	}
}
