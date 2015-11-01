package com.example.acropolismuseum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.R.color;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quiz extends Activity {

	int score = 0;
	TextView text;
	String[] question, answerA, answerB, answerC, answerD, correctanswer;
	Button buttona, buttonb, buttonc, buttond;
	int answer[];
	List<Integer> list = new ArrayList<Integer>();
	int a = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		question = getResources().getStringArray(R.array.questions);
		answerA = getResources().getStringArray(R.array.answerA);
		answerB = getResources().getStringArray(R.array.answerB);
		answerC = getResources().getStringArray(R.array.answerC);
		answerD = getResources().getStringArray(R.array.answerD);
		correctanswer = getResources().getStringArray(R.array.correctanswer);
				
		buttona = (Button) findViewById(R.id.button1);
		buttonb = (Button) findViewById(R.id.button2);
		buttonc = (Button) findViewById(R.id.button3);
		buttond = (Button) findViewById(R.id.button4);
				
		text = (TextView) findViewById(R.id.textView1);	
		
		int max = question.length;
				
		for(int i=0; i<max; i++)
			list.add(i);
		
		Collections.shuffle(list);
		
		setQuestionView();	
	}

	private void setQuestionView() {
		
		buttona.setBackgroundResource(android.R.drawable.btn_default);
		buttonb.setBackgroundResource(android.R.drawable.btn_default);
		buttonc.setBackgroundResource(android.R.drawable.btn_default);
		buttond.setBackgroundResource(android.R.drawable.btn_default);
		
		text.setText(question[list.get(a)]);
		buttona.setText(answerA[list.get(a)]);
		buttonb.setText(answerB[list.get(a)]);
		buttonc.setText(answerC[list.get(a)]);
		buttond.setText(answerD[list.get(a)]);
		
		final int answer[] = new int[correctanswer.length];
		for(int i=0; i<correctanswer.length; i++){
			answer[i]=Integer.parseInt(correctanswer[i]);
		}

		
		buttona.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
            	buttona.setEnabled(false);
            	buttonb.setEnabled(false);
            	buttonc.setEnabled(false);
            	buttond.setEnabled(false);
                if(answer[list.get(a)] == 1){
                	buttona.setBackgroundResource(color.holo_green_light);
                	a=a+1;
                	score=score+1;
                	Handler handler = new Handler(); 
                    handler.postDelayed(new Runnable() { 
                         public void run() { 
                        	 buttona.setBackgroundResource(android.R.drawable.btn_default);
                        	 if(a<10){
                        		 buttona.setEnabled(true);
                        		 buttonb.setEnabled(true);
                             	 buttonc.setEnabled(true);
                             	 buttond.setEnabled(true);
                        		 setQuestionView();
                        	 }
                        	 else{
                        		 openAlert(v);
                        	 }
                         } 
                    }, 3000); 
                }
                else if(answer[list.get(a)] == 2){
                	buttona.setBackgroundResource(color.holo_red_light);
                	buttonb.setBackgroundResource(color.holo_green_light);
                	a=a+1;
                	Handler handler = new Handler();
                	handler.postDelayed(new Runnable() {
                		public void run() {
                			buttona.setBackgroundResource(android.R.drawable.btn_default);
                			buttonb.setBackgroundResource(android.R.drawable.btn_default);
                			if(a<10){
                				buttona.setEnabled(true);
                       		 	buttonb.setEnabled(true);
                            	buttonc.setEnabled(true);
                            	buttond.setEnabled(true);
                				setQuestionView();
                			}
                			else{
                				openAlert(v);
                			}
                		}
                	}, 3000);
                }
                else if(answer[list.get(a)] == 3){
                	buttona.setBackgroundResource(color.holo_red_light);
                	buttonc.setBackgroundResource(color.holo_green_light);
                	a=a+1;
                	Handler handler = new Handler();
                	handler.postDelayed(new Runnable() {
                		public void run() {
                			buttona.setBackgroundResource(android.R.drawable.btn_default);
                			buttonc.setBackgroundResource(android.R.drawable.btn_default);
                			if(a<10){
                				buttona.setEnabled(true);
                       		 	buttonb.setEnabled(true);
                            	buttonc.setEnabled(true);
                            	buttond.setEnabled(true);
                				setQuestionView();
                			}
                			else{
                				openAlert(v);
                			}
                		}
                	}, 3000);
                }
                else if(answer[list.get(a)] == 4){
                	buttona.setBackgroundResource(color.holo_red_light);
                	buttond.setBackgroundResource(color.holo_green_light);
                	a=a+1;
                	Handler handler = new Handler();
                	handler.postDelayed(new Runnable() {
                		public void run() {
                			buttona.setBackgroundResource(android.R.drawable.btn_default);
                			buttond.setBackgroundResource(android.R.drawable.btn_default);
                			if(a<10){
                				buttona.setEnabled(true);
                       		 	buttonb.setEnabled(true);
                            	buttonc.setEnabled(true);
                            	buttond.setEnabled(true);
                				setQuestionView();
                			}
                			else{
                				openAlert(v);
                			}
                		}
                	}, 3000);
                }
            }
		});
		
		buttonb.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
            	buttona.setEnabled(false);
            	buttonb.setEnabled(false);
            	buttonc.setEnabled(false);
            	buttond.setEnabled(false);
                if(answer[list.get(a)] == 2){
                	buttonb.setBackgroundResource(color.holo_green_light);
                	a=a+1;
                	score=score+1;
                	Handler handler = new Handler(); 
                    handler.postDelayed(new Runnable() { 
                         public void run() { 
                        	 buttonb.setBackgroundResource(android.R.drawable.btn_default);
                        	 if(a<10){
                        		 buttona.setEnabled(true);
                        		 buttonb.setEnabled(true);
                             	 buttonc.setEnabled(true);
                             	 buttond.setEnabled(true);
                        		 setQuestionView();
                        	 }
                        	 else{
                        		 openAlert(v);
                        	 }
                         } 
                    }, 3000); 
                }
                else if(answer[list.get(a)] == 1){
                	buttonb.setBackgroundResource(color.holo_red_light);
                	buttona.setBackgroundResource(color.holo_green_light);
                	a=a+1;
                	Handler handler = new Handler();
                	handler.postDelayed(new Runnable() {
                		public void run() {
                			buttona.setBackgroundResource(android.R.drawable.btn_default);
                			buttonb.setBackgroundResource(android.R.drawable.btn_default);
                			if(a<10){
                				buttona.setEnabled(true);
                       		 	buttonb.setEnabled(true);
                            	buttonc.setEnabled(true);
                            	buttond.setEnabled(true);
                				setQuestionView();
                			}
                			else{
                				openAlert(v);
                			}
                		}
                	}, 3000);
                }
                else if(answer[list.get(a)] == 3){
                	buttonb.setBackgroundResource(color.holo_red_light);
                	buttonc.setBackgroundResource(color.holo_green_light);
                	a=a+1;
                	Handler handler = new Handler();
                	handler.postDelayed(new Runnable() {
                		public void run() {
                			buttonb.setBackgroundResource(android.R.drawable.btn_default);
                			buttonc.setBackgroundResource(android.R.drawable.btn_default);
                			if(a<10){
                				buttona.setEnabled(true);
                       		 	buttonb.setEnabled(true);
                            	buttonc.setEnabled(true);
                            	buttond.setEnabled(true);
                				setQuestionView();
                			}
                			else{
                				openAlert(v);
                			}
                		}
                	}, 3000);
                }
                else if(answer[list.get(a)] == 4){
                	buttonb.setBackgroundResource(color.holo_red_light);
                	buttond.setBackgroundResource(color.holo_green_light);
                	a=a+1;
                	Handler handler = new Handler();
                	handler.postDelayed(new Runnable() {
                		public void run() {
                			buttonb.setBackgroundResource(android.R.drawable.btn_default);
                			buttond.setBackgroundResource(android.R.drawable.btn_default);
                			if(a<10){
                				buttona.setEnabled(true);
                       		 	buttonb.setEnabled(true);
                            	buttonc.setEnabled(true);
                            	buttond.setEnabled(true);
                				setQuestionView();
                			}
                			else{
                				openAlert(v);
                			}
                		}
                	}, 3000);
                }
            }
		});
		
		buttonc.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
            	buttona.setEnabled(false);
            	buttonb.setEnabled(false);
            	buttonc.setEnabled(false);
            	buttond.setEnabled(false);
                if(answer[list.get(a)] == 3){
                	buttonc.setBackgroundResource(color.holo_green_light);
                	a=a+1;
                	score=score+1;
                	Handler handler = new Handler(); 
                    handler.postDelayed(new Runnable() { 
                         public void run() { 
                        	 buttonc.setBackgroundResource(android.R.drawable.btn_default);
                        	 if(a<10){
                        		 buttona.setEnabled(true);
                        		 buttonb.setEnabled(true);
                             	 buttonc.setEnabled(true);
                             	 buttond.setEnabled(true);
                        		 setQuestionView();
                        	 }
                        	 else{
                        		 openAlert(v);
                        	 }
                         } 
                    }, 3000); 
                }
                else if(answer[list.get(a)] == 2){
                	buttonc.setBackgroundResource(color.holo_red_light);
                	buttonb.setBackgroundResource(color.holo_green_light);
                	a=a+1;
                	Handler handler = new Handler();
                	handler.postDelayed(new Runnable() {
                		public void run() {
                			buttonc.setBackgroundResource(android.R.drawable.btn_default);
                			buttonb.setBackgroundResource(android.R.drawable.btn_default);
                			if(a<10){
                				buttona.setEnabled(true);
                       		 	buttonb.setEnabled(true);
                            	buttonc.setEnabled(true);
                            	buttond.setEnabled(true);
                				setQuestionView();
                			}
                			else{
                				openAlert(v);
                			}
                		}
                	}, 3000);
                }
                else if(answer[list.get(a)] == 1){
                	buttonc.setBackgroundResource(color.holo_red_light);
                	buttona.setBackgroundResource(color.holo_green_light);
                	a=a+1;
                	Handler handler = new Handler();
                	handler.postDelayed(new Runnable() {
                		public void run() {
                			buttona.setBackgroundResource(android.R.drawable.btn_default);
                			buttonc.setBackgroundResource(android.R.drawable.btn_default);
                			if(a<10){
                				buttona.setEnabled(true);
                       		 	buttonb.setEnabled(true);
                            	buttonc.setEnabled(true);
                            	buttond.setEnabled(true);
                				setQuestionView();
                			}
                			else{
                				openAlert(v);
                			}
                		}
                	}, 3000);
                }
                else if(answer[list.get(a)] == 4){
                	buttonc.setBackgroundResource(color.holo_red_light);
                	buttond.setBackgroundResource(color.holo_green_light);
                	a=a+1;
                	Handler handler = new Handler();
                	handler.postDelayed(new Runnable() {
                		public void run() {
                			buttonc.setBackgroundResource(android.R.drawable.btn_default);
                			buttond.setBackgroundResource(android.R.drawable.btn_default);
                			if(a<10){
                				buttona.setEnabled(true);
                       		 	buttonb.setEnabled(true);
                            	buttonc.setEnabled(true);
                            	buttond.setEnabled(true);
                				setQuestionView();
                			}
                			else{
                				openAlert(v);
                			}
                		}
                	}, 3000);
                }
            }
		});
		
		buttond.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
            	buttona.setEnabled(false);
            	buttonb.setEnabled(false);
            	buttonc.setEnabled(false);
            	buttond.setEnabled(false);
                if(answer[list.get(a)] == 4){
                	buttond.setBackgroundResource(color.holo_green_light);
                	a=a+1;
                	score=score+1;
                	Handler handler = new Handler(); 
                    handler.postDelayed(new Runnable() { 
                         public void run() { 
                        	 buttond.setBackgroundResource(android.R.drawable.btn_default);
                        	 if(a<10){
                        		 buttona.setEnabled(true);
                        		 buttonb.setEnabled(true);
                             	 buttonc.setEnabled(true);
                             	 buttond.setEnabled(true);
                        		 setQuestionView();
                        	 }
                        	 else{
                        		 openAlert(v);
                        	 }
                         } 
                    }, 3000); 
                }
                else if(answer[list.get(a)] == 2){
                	buttond.setBackgroundResource(color.holo_red_light);
                	buttonb.setBackgroundResource(color.holo_green_light);
                	a=a+1;
                	Handler handler = new Handler();
                	handler.postDelayed(new Runnable() {
                		public void run() {
                			buttond.setBackgroundResource(android.R.drawable.btn_default);
                			buttonb.setBackgroundResource(android.R.drawable.btn_default);
                			if(a<10){
                				buttona.setEnabled(true);
                       		 	buttonb.setEnabled(true);
                            	buttonc.setEnabled(true);
                            	buttond.setEnabled(true);
                				setQuestionView();
                			}
                			else{
                				openAlert(v);
                			}
                		}
                	}, 3000);
                }
                else if(answer[list.get(a)] == 3){
                	buttond.setBackgroundResource(color.holo_red_light);
                	buttonc.setBackgroundResource(color.holo_green_light);
                	a=a+1;
                	Handler handler = new Handler();
                	handler.postDelayed(new Runnable() {
                		public void run() {
                			buttond.setBackgroundResource(android.R.drawable.btn_default);
                			buttonc.setBackgroundResource(android.R.drawable.btn_default);
                			if(a<10){
                				buttona.setEnabled(true);
                       		 	buttonb.setEnabled(true);
                            	buttonc.setEnabled(true);
                            	buttond.setEnabled(true);
                				setQuestionView();
                			}
                			else{
                				openAlert(v);
                			}
                		}
                	}, 3000);
                }
                else if(answer[list.get(a)] == 1){
                	buttond.setBackgroundResource(color.holo_red_light);
                	buttona.setBackgroundResource(color.holo_green_light);
                	a=a+1;
                	Handler handler = new Handler();
                	handler.postDelayed(new Runnable() {
                		public void run() {
                			buttond.setBackgroundResource(android.R.drawable.btn_default);
                			buttona.setBackgroundResource(android.R.drawable.btn_default);
                			if(a<10){
                				buttona.setEnabled(true);
                       		 	buttonb.setEnabled(true);
                            	buttonc.setEnabled(true);
                            	buttond.setEnabled(true);
                				setQuestionView();
                			}
                			else{
                				openAlert(v);
                			}
                		}
                	}, 3000);
                }
            }
		});
	}
	
	private void openAlert(View view) {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Quiz.this);
		
		alertDialogBuilder.setTitle(getString(R.string.ScoreTitle));
		alertDialogBuilder.setMessage(getString(R.string.ScoreText1) + score +".\n" +  getString(R.string.ScoreText2));
		
		alertDialogBuilder.setPositiveButton(getString(R.string.ScoreYes),new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				Intent newQuiz = new Intent(getApplicationContext(), Quiz.class);
				startActivity(newQuiz);
				finish();
			}
		});
		
		alertDialogBuilder.setNegativeButton(getString(R.string.ScoreNo),new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
//				Intent back = new Intent(getApplicationContext(), MainActivity.class);
//				startActivity(back);
				finish();
			}
		});
		
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == android.R.id.home) { 
			this.finish();
			return true;
		}else if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
