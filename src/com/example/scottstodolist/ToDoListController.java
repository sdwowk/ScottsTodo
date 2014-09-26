package com.example.scottstodolist;

import java.io.IOException;
import java.io.StreamCorruptedException;

public class ToDoListController {
	private static ToDoList toDoList = null;

	 
	public void addToDoItem(ToDoItem addItem) {
		getToDoList().addToDo(addItem);
		
	}

	static public ToDoList getToDoList() {
		if(toDoList == null){
			try {
				toDoList = ToDoListManager.getManager().loadToDoList();
				toDoList.addListener(new Listener(){

					@Override
					public void update() {
						saveToDoList();
					}
					
				});
			} catch (StreamCorruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return toDoList;
	}

	static public void saveToDoList() {
			try {
				ToDoListManager.getManager().saveToDoList(getToDoList());
			} catch (StreamCorruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}
