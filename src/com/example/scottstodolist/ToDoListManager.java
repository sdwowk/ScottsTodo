package com.example.scottstodolist;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;

public class ToDoListManager {
	static final String savfile = "ToDoList";
	static final String listKey = "toDoList";
	static Context context;
	static private ToDoListManager toDoListManager = null;
	
	public static void initManager(Context context){
		if(toDoListManager == null){
			if(context == null){
				throw new RuntimeException("Manager not initialized");
			}
			toDoListManager = new ToDoListManager(context);
		}
	}
	
	public static ToDoListManager getManager(){
		if(toDoListManager == null){
			toDoListManager = new ToDoListManager(context);
		}
		return toDoListManager; 
	}
	public ToDoListManager(Context c){
		context = c;
	}
	public ToDoList loadToDoList() throws StreamCorruptedException, IOException, ClassNotFoundException{
		SharedPreferences list = context.getSharedPreferences(savfile, Context.MODE_PRIVATE);
		String toDoData = list.getString(listKey, "");
		if(toDoData.equals("")){
			return new ToDoList();
		}
		else{
			return toDoListFromString(toDoData);
		}
	}
	public ToDoList toDoListFromString(String toDoData) throws StreamCorruptedException, IOException, ClassNotFoundException {

		ByteArrayInputStream byteIn = new ByteArrayInputStream(Base64.decode(toDoData, Base64.DEFAULT));
		ObjectInputStream objectIn = new ObjectInputStream(byteIn);
		return (ToDoList) objectIn.readObject();
				}
	
	public void saveToDoList(ToDoList todo) throws IOException{
		SharedPreferences list = context.getSharedPreferences(savfile, Context.MODE_PRIVATE);
		Editor editor = list.edit();
		editor.putString(listKey, toDoListToString(todo));
		editor.commit();

	}
	public String toDoListToString(ToDoList todo) throws IOException {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ObjectOutputStream objectOut = new ObjectOutputStream(byteOut);
		objectOut.writeObject(todo);
		objectOut.close();
		byte objectByte[] = byteOut.toByteArray();
		return Base64.encodeToString(objectByte, Base64.DEFAULT);
		
	}
}
