package com.jp.test06.pojo;



public class Blog {
      private int id;
      private String title;
      private int author_id ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", author_id=" + author_id + "]";
	}

	
      
}
