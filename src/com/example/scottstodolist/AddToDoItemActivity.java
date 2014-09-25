package com.example.scottstodolist;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class AddToDoItemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

	public ToDoItem addToDoItem(View v){
		ToDoListController toDos = new ToDoListController();
		ToDoItem addItem = new ToDoItem();
		//addItem.setTitle(title);
		//addItem.setDate(date);
		toDos.addToDoItem(addItem);
		
		return addItem;
	}
}
