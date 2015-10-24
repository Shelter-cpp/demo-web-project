package edu.csupomona.cs480.data;

public interface UserInterface {
	
	public boolean checkPassword(String password);
	public Bookmark getBookmark(int bookmarkNumber);
	public int getBookmarkCount();
	public int addBookmark(Bookmark newBookmark);
	public int deleteBookmark(int index);
	public void swapBookmarks(int index1, int index2);
}
