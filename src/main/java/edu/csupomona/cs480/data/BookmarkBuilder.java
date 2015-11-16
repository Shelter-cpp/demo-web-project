package edu.csupomona.cs480.data;

public class BookmarkBuilder {
	private Bookmark bookmark;
	
	public BookmarkBuilder() {
		bookmark = new Bookmark();
	}
	
	public BookmarkBuilder name(String name) {
		bookmark.setName(name);
		return this;
	}
	public BookmarkBuilder url(String url) {
		bookmark.addUrl(url);
		return this;
	}
	public Bookmark build() {
		return bookmark;
	}
}
