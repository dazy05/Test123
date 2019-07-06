package com.example.android.scorekeeperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreBoard_a = 0;
    int scoreBoard_b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayForTeamB(int number)
    {
        TextView scoreB = (TextView) findViewById(R.id.team_b_score);
        scoreB.setText("" + number);
    }

    public void displayForTeamA(int number)
    {
        TextView score = (TextView) findViewById(R.id.team_a_score);
        score.setText("" + number);
    }

    public void pointsA3(View view)
    {
        scoreBoard_a = scoreBoard_a + 3;
        displayForTeamA(scoreBoard_a);
    }

    public void pointsA2(View view)
    {
        scoreBoard_a = scoreBoard_a + 2;
        displayForTeamA(scoreBoard_a);
    }

    public void freethrowA(View view)
    {
        scoreBoard_a = scoreBoard_a + 1;
        displayForTeamA(scoreBoard_a);
    }

    public void pointsB3(View view)
    {
        scoreBoard_b = scoreBoard_b + 3;
        displayForTeamB(scoreBoard_b);
    }

    public void pointsB2(View view)
    {
        scoreBoard_b = scoreBoard_b +2;
        displayForTeamB(scoreBoard_b);
    }

    public void freethrowB(View view)
    {
        scoreBoard_b = scoreBoard_b +1;
        displayForTeamB(scoreBoard_b);
    }

    public void scoreReset(View view)
    {
        displayForTeamA(0);
        displayForTeamB(0);
        scoreBoard_a = 0;
        scoreBoard_b = 0;
    }

}
