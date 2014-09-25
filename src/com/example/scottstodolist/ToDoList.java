package com.example.scottstodolist;

import java.util.ArrayList;

public class ToDoList {
	protected ArrayList<ToDoItem> toDoList = null;
	public ToDoList() {
		toDoList = new ArrayList<ToDoItem>();		
		
	}
	
	public void addToDo(ToDoItem todo){
		toDoList.add(todo);
	}
}
