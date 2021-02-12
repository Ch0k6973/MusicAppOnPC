import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound implements AutoCloseable {

    private Clip audioClip;  //le son créé depuis l'url
    private File file;
    private String name = "unknow";
    private String artist = "unknow";
    private String title = "unknow";
    private long minLenght;
    private long secLenght;

    public Sound(String name,String title, String artist)  {
        this.name = name;
        this.title = title;
        this.artist = artist;
    }
    public String getName() {
        return name;
    }
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public long getMinLenght() {
        return minLenght;
    }

    public long getSecLenght() {
        return secLenght;
    }

    public void load() {
        file = new File("Music/" + name);
        try {
            audioClip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            audioClip.open(AudioSystem.getAudioInputStream(file));
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        time(audioClip.getMicrosecondLength());
        Service.loadTime();
        Service.loadText();
    }

    public void reload() {
        this.close();
        try {
            audioClip.open(AudioSystem.getAudioInputStream(file));
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        audioClip.start();
    }
    public void jouerEnBoucle() {
        audioClip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void pause() {
        audioClip.stop();
    }

    @Override
    public void close() {
        audioClip.close();
    }

    public void time(long microTime) {
        secLenght = microTime / 1000000;
        minLenght = secLenght / 60;
        secLenght = secLenght % 60;
    }

}