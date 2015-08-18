package com.example.acropolismuseum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserModeling extends Activity {
	
	String FILENAME = "userModel.um";
	String ANSWERONE,ANSWERTWO,ANSWERTHREE;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_modeling);
		
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		if (sharedPreferences.contains("level")) {
			Intent i = new Intent(UserModeling.this, MainActivity.class);
            startActivity(i);
            finish();
		} else {
			FirstQuestion();
		}
	}
	
	public void FirstQuestion() {
		setContentView(R.layout.question1);
		
		TextView txtQuestion1;
		Button button1, button2;
		
		txtQuestion1 = (TextView) findViewById(R.id.txtQuestion);	
		txtQuestion1.setText(R.string.questionOneText);
		
		button1 = (Button) findViewById(R.id.button1);
		button1.setText(R.string.questionOneAnswerOne);
		
		button2 = (Button) findViewById(R.id.button2);
		button2.setText(R.string.questionOneAnswerTwo);
		
		button1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				ANSWERONE = "Greece";
				SecondQuestion();
			}
			
		});
		
		button2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				ANSWERONE = "Visitor";
				SecondQuestion();
			}
			
		});
		
	}
	
	public void SecondQuestion() {
		setContentView(R.layout.question2);
		
		TextView txtQuestion1;
		Button button1, button2, button3, button4;
		
		txtQuestion1 = (TextView) findViewById(R.id.txtQuestion);	
		txtQuestion1.setText(R.string.questionTwoText);
		
		button1 = (Button) findViewById(R.id.button1);
		button1.setText(R.string.questionTwoAnswerOne);
		
		button2 = (Button) findViewById(R.id.button2);
		button2.setText(R.string.questionTwoAnswerTwo);
		
		button3 = (Button) findViewById(R.id.button3);
		button3.setText(R.string.questionTwoAnswerThree);
		
		button4 = (Button) findViewById(R.id.button4);
		button4.setText(R.string.questionTwoAnswerFour);
		
		button1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				ANSWERTWO = "Student";
				ThirdQuestion();
			}
			
		});
		
		button2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				ANSWERTWO = "Uni";
				ThirdQuestion();
			}
			
		});
		
		button3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				ANSWERTWO = "Worker";
				ThirdQuestion();
			}
			
		});
		
		button4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				ANSWERTWO = "Other";
				ThirdQuestion();
			}
			
		});
	}
	
	public void ThirdQuestion() {
		setContentView(R.layout.question3);
		
		TextView txtQuestion1;
		Button button1, button2, button3;
		
		txtQuestion1 = (TextView) findViewById(R.id.txtQuestion);	
		txtQuestion1.setText(R.string.questionThreeText);
		
		button1 = (Button) findViewById(R.id.button1);
		button1.setText(R.string.questionThreeAnswerOne);
		
		button2 = (Button) findViewById(R.id.button2);
		button2.setText(R.string.questionThreeAnswerTwo);
		
		button3 = (Button) findViewById(R.id.button3);
		button3.setText(R.string.questionThreeAnswerThree);
		
		button1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				ANSWERTHREE = "1";
				UserAssessment();
			}
			
		});
		
		button2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				ANSWERTHREE = "2";
				UserAssessment();
			}
			
		});
		
		button3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				ANSWERTHREE="3";
				UserAssessment();
			}
			
		});
		
	}
	
	public void UserAssessment() {
		if (ANSWERTWO == "Student") {
			SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
			SharedPreferences.Editor editor = sharedPreferences.edit(); 
			editor.putString("level", "1");
			editor.putString("student", "yes");
			editor.commit();
			Intent i = new Intent(UserModeling.this, MainActivity.class);
            startActivity(i);
            finish();
		} else if (ANSWERTHREE == "1") {
			SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
			SharedPreferences.Editor editor = sharedPreferences.edit(); 
			editor.putString("level", "1");
			editor.putString("student", "no");
			editor.commit();
			Intent i = new Intent(UserModeling.this, MainActivity.class);
            startActivity(i);
            finish();
		} else if (ANSWERTHREE == "2") {
			SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
			SharedPreferences.Editor editor = sharedPreferences.edit(); 
			editor.putString("level", "2");
			editor.putString("student", "no");
			editor.commit();
			Intent i = new Intent(UserModeling.this, MainActivity.class);
            startActivity(i);
            finish();
		} else if (ANSWERTHREE == "3") {
			SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
			SharedPreferences.Editor editor = sharedPreferences.edit(); 
			editor.putString("level", "3");
			editor.putString("student", "no");
			editor.commit();
			Intent i = new Intent(UserModeling.this, MainActivity.class);
            startActivity(i);
            finish();
		}
	}
}
