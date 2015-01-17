package com.example.listviewusingstringsfile;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	//String of data is declared in values folder in strings file
	String [] cars;
	//Defining Listview
	ListView lv;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Referring the ListView
		lv=(ListView)findViewById(R.id.listView1);
		//Binding the value from strings file 		
		cars=getResources().getStringArray(R.array.cars);
		//Adapter to used to adapt the value from datasource(here data source is from array), so we are using ArrayAdapter the array is of type string 	
		ArrayAdapter<String>adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,cars);
		//Setting the adapter to Listview
		lv.setAdapter(adapter);
		//Creating listener for ListView , we are going to Click a item from ListView so we are using itemclick listener
		lv.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) 
				
			{
				// TODO Auto-generated method stub
				//Getting the value of item clicked
				String itemselected=arg0.getItemAtPosition(arg2).toString();
				//Showing the clicked item from in Toast
				Toast.makeText(MainActivity.this,"Your favourite is "+itemselected,Toast.LENGTH_LONG).show();
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
