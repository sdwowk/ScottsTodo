package com.example.scottstodolist;

import java.io.Serializable;
import java.util.ArrayList;

public class ToDoList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ArrayList<ToDoItem> toDoList = null;
	protected ArrayList<Listener> listeners;
	public ToDoList() {
		toDoList = new ArrayList<ToDoItem>();		
		listeners = new ArrayList<Listener>();
	}
	
	public void addToDo(ToDoItem todo){
		toDoList.add(todo);
		notifyChanges();
	}

	private void notifyChanges() {
		for(Listener listener : listeners){
			listener.update();
		}
		
	}

	public ArrayList<ToDoItem> getList() {
		
		return toDoList;
	}
	public void addListener(Listener listen){
		listeners.add(listen);
	}
	public void removeListener(Listener listen){
		listeners.remove(listen);
	}
}
