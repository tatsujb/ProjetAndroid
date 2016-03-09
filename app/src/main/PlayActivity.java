package myapp.jess.home.myapplication;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {

    private String level;
    private int score;
    private int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.score=0;
        setContentView(R.layout.activity_play);
        TextView scoreText = (TextView) findViewById(R.id.scoreText);
        TextView timerTextView = (TextView) findViewById(R.id.timerTextView);
        level = getIntent().getStringExtra("level");

        //easy
        if(level.equals(R.string.easy)){
            this.time=40000;
        }
        //hard
        if(level.equals(R.string.hard)){
            this.time=30000;
        }
        //game timer
        new CountDownTimer(this.time,1000){
            final TextView timerTextView=(TextView) findViewById(R.id.timerTextView);
            public void onTick(long millisUntilFinished){
                timerTextView.setText(""+ millisUntilFinished/1000);
            }
            public void onFinish(){
                timerTextView.setText(R.string.finished);
            }
        }.start();
        //actual gameplay
        while(!timerTextView.getText().equals(R.string.finished)){

        }

    }

    public void scored(TextView scoreText){
        score++;
        scoreText.setText(""+score);
    }
}
