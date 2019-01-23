/**
 * @ClassName LonelyTwitterActivity
 *
 * @Version 1.0
 *
 * @Date 1/23/2019
 *
 * @Copyright(c) Ruoqi Yang, CMPUT301, University of Alberta

 */
package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Main activity for LonelyTwitter.
 *
 * @author ry
 * @version 1.0
 * @see Tweet
 * @since 1.0
 *
 */
public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file3.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;
	/**
	 * Called by java framework on creation of activity
	 * Link buttons to the response IDs in XML
	 * Sets up click listeners.
	 *
	 * @param savedInstanceState
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);


		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet tweet = new Tweet(text);
				tweetList.add(tweet);
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});
		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				tweetList.clear();
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});
	}
	/**
	 * Called by android framework on the start of the activity
	 * Loads Tweets from file
	 * Sets up the array adapter for the list view.
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();


		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}
	public void Clear(){

	}

	/**
	 * Loads the Tweets form the disk
	 */
	private void loadFromFile() {
		//ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			Type listtype = new TypeToken<ArrayList<Tweet>>(){}.getType();
			//String line = in.readLine();
			tweetList = gson.fromJson(in,listtype);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Save the Tweets to the disk
	 */
	private void saveInFile() {
		try {
			//FileOutputStream fos = openFileOutput(FILENAME,
					//Context.MODE_APPEND);
			//BufferedWriter out = new BufferedReader( new OutputStreamWriter(fos));
			FileWriter out = new FileWriter (FILENAME);
			Gson gson = new Gson();
			gson.toJson(tweetList,out);
			//fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}