package kaczmarek.beatbox;

import android.content.Context;
import android.media.AudioManager;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

public class BeatBoxActivity extends AppCompatActivity {
    private BeatBox beatBox;
    private RecyclerView recyclerView;
    BottomAppBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = findViewById(R.id.bottom_app_bar);
        setSupportActionBar(bar);
        beatBox = new BeatBox(this);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(new SoundAdapter(beatBox.getSounds(), beatBox));

    }

    @Override
    protected void onResume() {
        super.onResume();
        AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        audioManager.setStreamMute(AudioManager.STREAM_SYSTEM, true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        audioManager.setStreamMute(AudioManager.STREAM_SYSTEM, false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        beatBox.release();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.item_release){
            beatBox.stop();
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_bottomappbar, menu);
        return true;
    }
}
