package app.src.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.Override;

public class MainActivity extends AppCompatActivity {
    private Button playButton;
    private Button scoreButton;
    private RadioGroup radioLevelGroup;
    private RadioButton radioLevelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        playButton = (Button) findViewById(R.id.playButton);
        scoreButton = (Button) findViewById(R.id.scoreButton);
        playListener playListener = new playListener();
        scoreListener playListener = new scoreListener();
        playButton.setOnClickListener(playListener);
        scoreButton.setOnClickListener(scoreListener);
    }

    class playListener extends View.OnClickListener{
        @Override
        public void onClick(View v){
            //activity d'origine vers nvlle activity
            int selectedId = radioLevelGroup.getCheckedRadioButtonId();

            // find the radiobutton by returned id
            radioLevelButton = (RadioButton) findViewById(selectedId);

            Intent intent = new Intent(MainActivity.this, PlayActivity.class);
            intent.putExtra("level",int selectedId = radioLevelGroup.getCheckedRadioButtonId();

            // find the radiobutton by returned id
            radioSexButton = (RadioButton) findViewById(selectedId);
            );
            startActivity(intent);
        }
}
    class scoreListener extends View.OnClickListener{
        @Override
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
