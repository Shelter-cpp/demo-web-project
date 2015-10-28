package edu.csupomona.cs480.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import junit.framework.Assert;

public class BookmarkTest {
	@Test
	public void testBookmarkName() {
		Bookmark bookmarkTest = new Bookmark("BookmarkTest1");
		Assert.assertEquals("BookmarkTest1", bookmarkTest.getName());
	}
	@Test
	public void testBookmarkSetName() {
		Bookmark bookmarkTest = new Bookmark("BookmarkTest1");
		bookmarkTest.setName("BookmarkTest2");
		Assert.assertEquals("BookmarkTest2", bookmarkTest.getName());
	}
	@Test
	public void testBookmarkUrl() {
		Bookmark bookmarkTest = new Bookmark("BookmarkTest", "www.test.com");
		Assert.assertEquals(1, bookmarkTest.getUrlCount());
		Assert.assertEquals("www.test.com", bookmarkTest.getUrls().get(0));
	}
	@Test
	public void testBookmarkAddUrl() {
		Bookmark bookmarkTest = new Bookmark("BookmarkTest", "www.test.com");
		bookmarkTest.addUrl("www.test.io");
		Assert.assertEquals(2, bookmarkTest.getUrlCount());
		Assert.assertEquals("www.test.com", bookmarkTest.getUrls().get(0));
		Assert.assertEquals("www.test.io", bookmarkTest.getUrls().get(1));
	}
	@Test
	public void testBookmarkChangeUrl() {
		Bookmark bookmarkTest = new Bookmark("BookmarkTest", "www.test.com");
		bookmarkTest.addUrl("www.test.io");
		Assert.assertEquals(false, bookmarkTest.changeUrl(2, "www.testFail.com"));
		Assert.assertEquals(true, bookmarkTest.changeUrl(1, "www.testNew.io"));
		Assert.assertEquals(2, bookmarkTest.getUrlCount());
		Assert.assertEquals("www.test.com", bookmarkTest.getUrls().get(0));
		Assert.assertEquals("www.testNew.io", bookmarkTest.getUrls().get(1));
	}
	@Test
	public void testBookmarkRemove() {
		Bookmark bookmarkTest = new Bookmark("BookmarkTest", "www.testA.com");
		bookmarkTest.addUrl("www.testB.com");
		bookmarkTest.addUrl("www.testC.com");
		Assert.assertEquals(3, bookmarkTest.getUrlCount());
		Assert.assertEquals(2, bookmarkTest.remove(2));
		Assert.assertEquals("www.testA.com", bookmarkTest.getUrls().get(0));
		Assert.assertEquals("www.testB.com", bookmarkTest.getUrls().get(1));
		Assert.assertEquals(1, bookmarkTest.remove(0));
		Assert.assertEquals("www.testB.com", bookmarkTest.getUrls().get(0));
	}
}
