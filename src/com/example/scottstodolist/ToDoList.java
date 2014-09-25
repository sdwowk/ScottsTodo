package com.example.scottstodolist;

import java.io.Serializable;
import java.util.ArrayList;

public class ToDoList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ArrayList<ToDoItem> toDoList = null;
	public ToDoList() {
		toDoList = new ArrayList<ToDoItem>();		
		
	}
	
	public void addToDo(ToDoItem todo){
		toDoList.add(todo);
	}
}
