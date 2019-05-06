package kaczmarek.beatbox;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class SoundViewModel extends BaseObservable {
    private Sound sound;
    private BeatBox beatBox;

    public SoundViewModel(BeatBox beatBox) {
        this.beatBox = beatBox;
    }

    @Bindable
    public String getTitle() {
        return sound.getName();
    }

    public void setSound(Sound sound) {
        this.sound = sound;
        notifyChange();
    }

    public void onButtonClick(){
        beatBox.play(sound);
    }

}
