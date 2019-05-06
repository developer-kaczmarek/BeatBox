package kaczmarek.beatbox;

public class Sound {
    private String path;
    private String name;
    private Integer soundId;


    public Sound(String assetPath) {
        path = assetPath;
        String[] components = assetPath.split("/");
        String filename = components[components.length - 1];
        name = filename.replaceAll(".wav", "");
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public Integer getSoundId() {
        return soundId;
    }

    public void setSoundId(Integer soundId) {
        this.soundId = soundId;
    }
}
