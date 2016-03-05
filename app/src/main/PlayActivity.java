package myapp.jess.home.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {

    private String level;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.score=0;
        setContentView(R.layout.activity_play);
        TextView scoreText = (TextView) findViewById(R.id.scoreText);
        level = getIntent().getStringExtra("level");
        //easy
        if(level=="0"){

        }
        //hard
        if(level=="1"){

        }

    }

    public void scored(TextView scoreText){
        score++;
        scoreText.setText(""+score);
    }
}
