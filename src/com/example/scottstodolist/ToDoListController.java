package com.example.scottstodolist;

public class ToDoListController {
	private static ToDoList toDoList = null;

	 
	public void addToDoItem(ToDoItem addItem) {
		getToDoList().addToDo(addItem);
		
	}

	static public ToDoList getToDoList() {
		if(toDoList == null){
			toDoList = new ToDoList();
		}
		return toDoList;
	}

}
