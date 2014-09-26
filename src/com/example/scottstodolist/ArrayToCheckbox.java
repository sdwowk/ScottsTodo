package com.example.scottstodolist;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

public class ArrayToCheckbox extends ArrayAdapter<ToDoItem> {
	ArrayList<ToDoItem> toDoList;
	Context context;
	
	public ArrayToCheckbox(Context context, int resource, List<ToDoItem> objects) {
		super(context, resource, objects);
		this.toDoList = ToDoListController.getToDoList().getList();
		this.context = context;
	}

	@Override
	public View getView(){
		
	}
}
