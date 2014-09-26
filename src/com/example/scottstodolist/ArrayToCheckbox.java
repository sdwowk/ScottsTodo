package com.example.scottstodolist;

import java.util.ArrayList;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

public class ArrayToCheckbox extends ArrayAdapter<ToDoItem> {
	ArrayList<ToDoItem> toDoList;
	Context context;
	
	public ArrayToCheckbox(Context context, int resource, ArrayList<ToDoItem> objects) {
		super(context, resource, objects);
		this.toDoList = ToDoListController.getToDoList().getList();
		this.context = context;
	}

	//@Override
/*	public View getView(int position, View convertView, ViewGroup parent){
		View newView = convertView;
		if(convertView == null){
			LayoutInflater inflater = 
		}
		CheckBox checkbox = (CheckBox) convertView.findViewById(R.id.checkBox_id);
		
		
	}*/
}
