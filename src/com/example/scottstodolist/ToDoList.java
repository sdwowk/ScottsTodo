package com.example.scottstodolist;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class ToDoList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ArrayList<ToDoItem> toDoList = null;
	protected transient ArrayList<Listener> listeners = null;
	public ToDoList() {
		toDoList = new ArrayList<ToDoItem>();		
		listeners = new ArrayList<Listener>();
	}
	
	private ArrayList<Listener> getListeners(){
		if(listeners == null){
			listeners = new ArrayList<Listener>();
		}
		return listeners;
	}
	
	public void addToDo(ToDoItem todo){
		toDoList.add(todo);
		notifyChanges();
	}

	private void notifyChanges() {
		for(Listener listener : getListeners()){
			listener.update();
		}
		
	}

	
	public ArrayList<ToDoItem> getList() {
		
		return toDoList;
	}
	public void addListener(Listener listen){
		getListeners().add(listen);
	}
	public void removeListener(Listener listen){
		getListeners().remove(listen);
	}
}
