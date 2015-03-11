package com.example.hp_shimon.quizsport;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivitys extends ActionBarActivity {

    TextView Questions;
    Button btnNext;
    RadioGroup rg;
    RadioButton rb1,rb2,rb3,rb4;
    String questions[] = {"What is the most puplar sport in the world?"
            ,"Which team got the most cups in  the football champions league?"
            ,"How much Goals scored the football player Zinedine Zidane?",
            "Which player took the most world snooker champions ship trophys?","Which tennis player took the most grand slam titles? ",
            "Which cyclist took drugs?","Which BasketBall team  in NBA took the most championship titles?",
            "How much Nba champions titles took Boston Celtics?","Which Football Player scored the most goals?","" +
            "Which Country got the most medals in 2012 Summer Olympics?"};

    String ans[] = {"Soccer","Real madrid","156","stephen hendry","Roger Federer","Lance Armstrong","Boston Celtics","17","Josef Bican","United States"};

    String opt[] = {"Tennis","Soccer","FootBall","VollyBall","Barcelona"
            ,"Real Madrid","Manchester United","Psj","156","210","75","250",
            "stephen hendry","roonie o'sullivan","steve davies","mark williams",
            "Pete Sampras","Rafael Nadal","Roger Federer","Roy Emerson","Maurice Garin","Lance Armstrong","Eddy Merckx","Miguel Indurain"
            ,"San Antonio Spurs","Chicago Bulls","Los Angeles Lakers","Boston Celtics","17","15","23","10","Gerd Müller",
            "Josef Bican","Arthur Friedenreich","Pele","United States","China","Russia","Great Britain"};

    int flag = 0;
    public static int marks,correct,wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_activitys);

        Questions = (TextView)findViewById(R.id.Questions);
        rg =(RadioGroup)findViewById(R.id.rg);
        btnNext = (Button)findViewById(R.id.btnNext);
        rb1 =(RadioButton)findViewById(R.id.radio1);
        rb2 = (RadioButton)findViewById(R.id.radio2);
        rb3 =(RadioButton)findViewById(R.id.radio3);
        rb4 = (RadioButton)findViewById(R.id.radio4);

        Questions.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                RadioButton uans = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                if (ansText.equalsIgnoreCase(ans[flag])) {


                    correct++;

                    try{
                        Toast.makeText(getApplicationContext(), "Your answer is correct", Toast.LENGTH_LONG).show();
                        Thread.sleep(1100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                } else {

                    wrong++;
                    try {
                        Toast.makeText(getApplicationContext(),"Your answer is Worng, The correct answer is " + ans[flag],Toast.LENGTH_LONG).show();
                        Thread.sleep(1100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                flag++;

                if (flag < questions.length) {

                    Questions.setText(questions[flag]);
                    rb1.setText(opt[flag * 4]);
                    rb2.setText(opt[(flag * 4)+1]);
                    rb3.setText(opt[(flag * 4)+2]);
                    rb4.setText(opt[(flag * 4)+3]);

                }else{
                    if(MainActivity.tbflag){
                        marks = wrong;
                    }
                    else
                    {
                        marks = correct;
                    }
                    Intent Result = new Intent(getApplicationContext(),ResultActivit.class);
                    startActivity(Result);
                }

            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return(keyCode == KeyEvent.KEYCODE_BACK ? true : super.onKeyDown(keyCode,event));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz_activitys, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
