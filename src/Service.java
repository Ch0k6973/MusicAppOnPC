

import java.util.List;

public class Service {

    private static List<Sound> sounds = SoundBank.soundBank();

    private static int indexOfSoundPlayed = 0;
    private boolean isPlay = false;

    public Service(){
        sounds.get(indexOfSoundPlayed).load();
    }

    public static List<Sound> getSounds(){
        return sounds;
    }

    public int getIndexOfSoundPlayed(){
        return indexOfSoundPlayed;
    }

    public void setPlay(boolean isPlay){
        this.isPlay = isPlay;
    }

    public boolean getPlay(){
        return isPlay;
    }

    public static void loadText() {
        Screen.updateText(sounds.get(indexOfSoundPlayed).getTitle(), sounds.get(indexOfSoundPlayed).getArtist());
    }

    public static void loadTime() {
        Screen.updateTime(sounds.get(indexOfSoundPlayed).getMinLenght(), sounds.get(indexOfSoundPlayed).getSecLenght());
    }

    public void play() {
        sounds.get(indexOfSoundPlayed).play();
    }

    public static void pause() {
        sounds.get(indexOfSoundPlayed).pause();

    }

    public static void next() {
        sounds.get(indexOfSoundPlayed).close();
        indexOfSoundPlayed++;
        if (indexOfSoundPlayed > (sounds.size() - 1))
            indexOfSoundPlayed = 0;
        sounds.get(indexOfSoundPlayed).load();
        sounds.get(indexOfSoundPlayed).play();
    }

    public void previous() {
        sounds.get(indexOfSoundPlayed).close();
        indexOfSoundPlayed--;
        if (indexOfSoundPlayed < 0)
            indexOfSoundPlayed = (sounds.size() - 1);
        sounds.get(indexOfSoundPlayed).load();
        sounds.get(indexOfSoundPlayed).play();
    }

    public void repeat() {
        sounds.get(indexOfSoundPlayed).reload();
        sounds.get(indexOfSoundPlayed).play();
    }
}
