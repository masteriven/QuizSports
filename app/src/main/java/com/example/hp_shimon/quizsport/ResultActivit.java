package com.example.hp_shimon.quizsport;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResultActivit extends ActionBarActivity {
    TextView Results;
    Button Restart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Results = (TextView) findViewById(R.id.Results);
        Restart = (Button) findViewById(R.id.Restart);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct Answers: " +QuizActivitys.correct + "   ");


        sb.append("Wrong Answers: " +QuizActivitys.wrong);
        Results.setText(sb);

        QuizActivitys.correct = 0;
        QuizActivitys.wrong = 0;

        Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View args0) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
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
        getMenuInflater().inflate(R.menu.menu_result, menu);
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
