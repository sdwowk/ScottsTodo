package com.example.scottstodolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddToDoItemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_item, menu);
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
	
	public void addToDoItem(View v){
		EditText title = (EditText) findViewById(R.id.AddTitleText);
		EditText date = (EditText) findViewById(R.id.AddDateText);
		EditText notes = (EditText) findViewById(R.id.NotesText);
		if(title.getText().toString().isEmpty() || date.getText().toString().isEmpty()){
			Toast.makeText(this, "Please make sure a title and date are entered", Toast.LENGTH_SHORT).show();
		
		}
		else{
			ToDoItem addItem = new ToDoItem();
			addItem.setTitle(title.getText().toString());
			addItem.setDueDate(date.getText().toString());
			addItem.setNotes(notes.getText().toString());
		
			Intent returnIntent = new Intent();
			returnIntent.putExtra("AddingToDoItem", addItem);
			setResult(Activity.RESULT_OK, returnIntent);
			finish();
		}
	}
}
