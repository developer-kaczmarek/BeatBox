package kaczmarek.beatbox;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import kaczmarek.beatbox.databinding.ListItemSoundBinding;

public class SoundAdapter extends RecyclerView.Adapter<SoundAdapter.SoundHolder>{

    private List<Sound> sounds;
    private BeatBox beatBox;

    public SoundAdapter(List<Sound> sounds, BeatBox beatBox) {
        this.sounds = sounds;
        this.beatBox = beatBox;
    }

    @NonNull
    @Override
    public SoundAdapter.SoundHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ListItemSoundBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.list_item_sound,viewGroup,false);
        return new SoundAdapter.SoundHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SoundAdapter.SoundHolder soundHolder, int i) {
        Sound sound = sounds.get(i);
        soundHolder.bind(sound);
    }

    @Override
    public int getItemCount() {
        return sounds.size();
    }

    public class SoundHolder extends RecyclerView.ViewHolder{
        private ListItemSoundBinding mBinding;


        public SoundHolder(ListItemSoundBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            mBinding.setViewModel(new SoundViewModel(beatBox));
        }

        public void bind(Sound sound){
            mBinding.getViewModel().setSound(sound);
            mBinding.executePendingBindings();
        }
    }
}


