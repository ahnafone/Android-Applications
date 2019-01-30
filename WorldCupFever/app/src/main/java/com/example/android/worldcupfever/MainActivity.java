package com.example.android.worldcupfever;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int braGoal = 0;
    int argGoal = 0;
    int braFoul = 0;
    int argFoul = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitBraGoal (View view) {
        braGoal += 1;
        TextView score = (TextView) findViewById(R.id.braGoal);
        score.setText("" + braGoal);
    }

    public void submitArgGoal (View view) {
        argGoal += 1;
        TextView score = (TextView) findViewById(R.id.argGoal);
        score.setText("" + argGoal);
    }

    public void submitBraFoul (View view) {
        braFoul += 1;
        TextView score = (TextView) findViewById(R.id.braFoul);
        score.setText("" + braFoul);
    }

    public void submitArgFoul (View view) {
        argFoul += 1;
        TextView score = (TextView) findViewById(R.id.argFoul);
        score.setText("" + argFoul);
    }

    public void reset (View view) {
        braGoal = 0; argGoal = 0; braFoul = 0; argFoul = 0;

        TextView score = (TextView) findViewById(R.id.braGoal);
        score.setText("" + braGoal);
        score = (TextView) findViewById(R.id.argGoal);
        score.setText("" + argGoal);
        score = (TextView) findViewById(R.id.braFoul);
        score.setText("" + braFoul);
        score = (TextView) findViewById(R.id.argFoul);
        score.setText("" + argFoul);
        TextView matchResult = (TextView) findViewById(R.id.result);
        matchResult.setText("");
    }

    public void finishMatch (View view) {
        String comentary = "";

        if(braGoal == argGoal)
            comentary += "A fair game! Both sides fought hard.\n";
        else if(braGoal > argGoal)
            comentary += "A fabulous game! Brazil emerges victorious!\n";
        else
            comentary += "A marvelous game! Argentina emerges victorious!\n";

        if(braFoul > argFoul)
            comentary += "Brazil should've played less aggressively.";
        else if (argFoul > braFoul)
            comentary += "Argentina should've played with more honour.";

        TextView matchResult = (TextView) findViewById(R.id.result);
        matchResult.setText(comentary);
    }
}
