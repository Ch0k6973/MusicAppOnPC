import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SoundBank {

    public static List soundBank() throws UnsupportedOperationException {

        File repertoire = new File("Music");
        File[] files=repertoire.listFiles();
        ArrayList sounds = new ArrayList();

        for(int i = 0; i < files.length ; i++){

            String fileName = files[i].getName();
            String tab[] = fileName.split(" - ");
            tab[1] = tab[1].replace(".wav", "");
            sounds.add(new Sound(fileName, tab[1], tab[0]));
        }
        return sounds;
    }
}


