package com.example.scottstodolist;

import java.io.Serializable;

public class ToDoItem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title = "";
	private String dueDate = "";
	private String notes = "";

	public ToDoItem(String title, String dueDate, String notes) {
		super();
		this.setTitle(title);
		this.setDueDate(dueDate);
		this.setNotes(notes);
	}
	
	public ToDoItem(String title, String date){
		this.title = title;
		this.dueDate = date;
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public String toString(){
		String wantedOutput = getTitle() + " , " + getDueDate();
		return wantedOutput;
	}
	
}
