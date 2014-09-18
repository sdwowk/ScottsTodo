package com.example.scottstodolist;

public class ToDoItem {
	
	private String title = "";
	private String dueDate = "";

	public ToDoItem(String title, String dueDate) {
		super();
		this.title = title;
		this.dueDate = dueDate;
	}
	
	public ToDoItem(String title){
		this.title = title;
	}
	public ToDoItem(){
		
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
}
