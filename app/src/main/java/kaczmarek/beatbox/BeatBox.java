package kaczmarek.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {
    private static Context context;
    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "packs";
    private static final int MAX_SOUNDS = 5;

    private AssetManager assets;
    private List<Sound> sounds = new ArrayList<>();
    private SoundPool soundPool;

    public BeatBox(Context context) {
        this.context = context;
        assets = context.getAssets();
        soundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC,0);
        loadSounds();
    }

    private void loadSounds() {
        String[] soundNames;
        try {
            soundNames = assets.list(SOUNDS_FOLDER);
        }
        catch (IOException ioe) {
            Log.e(TAG, context.getResources().getString(R.string.error_list), ioe);
            return;
        }
    try {
        for (String filename : soundNames) {
            String assetPath = SOUNDS_FOLDER + "/" + filename;
            Sound sound = new Sound(assetPath);
            load(sound);
            sounds.add(sound);

        }
    } catch (IOException ioe){
        Log.e(TAG, context.getResources().getString(R.string.error_load), ioe);
    }

    }
    public void load(Sound sound) throws IOException {
        AssetFileDescriptor afd = assets.openFd(sound.getPath());
        int soundId = soundPool.load(afd, 1);
        sound.setSoundId(soundId);
    }

    public List<Sound> getSounds() {

        return sounds;
    }

    public void play(Sound sound) {
        Integer soundId = sound.getSoundId();
        if (soundId == null) {
            return;
        }
        soundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void release() {
        soundPool.release();
    }

    public void stop() {
        soundPool.autoPause();
    }
}
