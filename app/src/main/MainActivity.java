import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.lang.Override;

import myapp.jess.home.myapplication.R;

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
        scoreListener scoreListener = new scoreListener();
        playButton.setOnClickListener(playListener);
        scoreButton.setOnClickListener(scoreListener);
    }

    class playListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            int selectedId = radioLevelGroup.getCheckedRadioButtonId();

            // find the radiobutton by returned id
            radioLevelButton = (RadioButton) findViewById(selectedId);
            //activity d'origine vers nvlle activity

            Intent intent = new Intent(MainActivity.this, PlayActivity.class);
            int selectedId = radioLevelGroup.getCheckedRadioButtonId();
            intent.putExtra("level", findViewById(selectedId).getText());

            startActivity(intent);
        }
    }

    class scoreListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
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
        if (id == R.id.french) {
            LocaleHelper.setLocale(this, "fr");
            updateTranslate();
        }
        if (id == R.id.english) {
            LocaleHelper.setLocale(this, "en");
            updateTranslate();
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateTranslate() {

        Resources resources = getResources();

        this.scoreButton.setText(resources.getString(R.string.score));
        this.playButton.setText(resources.getString(R.string.play));
        this.radioLevelButton = (RadioButton) findViewById(0);
        this.radioLevelButton.setText(resources.getString(R.string.easyChoice));
        this.radioLevelButton = (RadioButton) findViewById(1);
        this.radioLevelButton.setText(resources.getString(R.string.hardChoice));
    }

}
