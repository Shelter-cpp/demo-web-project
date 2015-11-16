package edu.csupomona.cs480.data;

public class UserBuilder {
	private User user;
	
	public UserBuilder() {
		user = new User();
	}
	public UserBuilder username(String username) {
		user.setUsername(username);
		return this;
	}
	public UserBuilder password(String password) {
		user.setPassword(password);
		return this;
	}
	public UserBuilder creationTime(String creationTime) {
		user.setCreationTime(creationTime);
		return this;
	}
	public UserBuilder bookmark(Bookmark bookmark) {
		user.addBookmark(bookmark);
		return this;
	}
	public User build() {
		return user;
	}
}
