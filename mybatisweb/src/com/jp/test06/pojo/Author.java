package com.jp.test06.pojo;

import java.util.List;

public class Author {
     private int id;
     private String name;
   
     private List<Blog>blogs;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Blog> getBlogs() {
		return blogs;
	}
	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", blogs=" + blogs + "]";
	}
	
     
}
