package com.example.scottstodolist;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ToDoListManager.initManager(this.getApplicationContext());
		ListView checkboxView = (ListView) findViewById(R.id.listOfToDoView);
		final ArrayList<ToDoItem> checkboxList =  ToDoListController.getToDoList().getList();
		final ArrayAdapter<ToDoItem> arrayToCheckbox = new ArrayAdapter<ToDoItem>(this, android.R.layout.simple_list_item_1, checkboxList);
		checkboxView.setAdapter(arrayToCheckbox);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void addToDoItem(MenuItem select){
		
		 
		Intent intent = new Intent(MainActivity.this, AddToDoItemActivity.class);
		startActivityForResult(intent,RESULT_FIRST_USER);
		
	}
	
	protected void onActivityResult (int requestCode, int resultCode, Intent data){

		ToDoListController listController = new ToDoListController();
		ToDoItem item = (ToDoItem) data.getSerializableExtra("AddingToDoItem");
		
		listController.addToDoItem(item);
		ListView checkboxView = (ListView) findViewById(R.id.listOfToDoView);
		final ArrayList<ToDoItem> checkboxList =  ToDoListController.getToDoList().getList();
		final ArrayAdapter<ToDoItem> arrayToCheckbox = new ArrayAdapter<ToDoItem>(this, android.R.layout.simple_list_item_1, checkboxList);
		checkboxView.setAdapter(arrayToCheckbox);
		ToDoListController.getToDoList().addListener(new Listener() {			
			@Override
			public void update() {
				checkboxList.clear();
				ArrayList<ToDoItem> items = ToDoListController.getToDoList().getList();
				checkboxList.addAll(items);
				arrayToCheckbox.notifyDataSetChanged();
			}
		});
	}
	
	
}
