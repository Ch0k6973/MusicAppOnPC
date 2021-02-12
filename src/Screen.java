import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Screen extends JPanel {

    private Image fond;
    private int nbrFond = 3;
    private Service service = new Service();
    public Bouton bPlay = new Bouton("Play");
    public Bouton bPause = new Bouton("Pause");
    public Bouton bNext = new Bouton("Skip");
    public Bouton bPrevious = new Bouton("Previous");
    public Bouton bRepeat = new Bouton("Repeat");
    public Bouton bQuit = new Bouton("Quit");
    public Bouton bReduce = new Bouton("Reduce");
    public Bouton bOpenTabList = new Bouton("openTabList");
    private static JLabel title = new JLabel();
    private static JLabel artist = new JLabel();
    private static JLabel timeOfRead = new JLabel();

    public Screen() {

        this.setLayout(null);
        this.setFocusable(true);

        bPlay.setBounds(214, 427, 50, 50);
        bPause.setBounds(214, 427, 50, 50);
        bNext.setBounds(292, 437, 50, 30);
        bPrevious.setBounds(66, 437, 50, 30);
        bRepeat.setBounds(140, 427, 50, 48);
        bQuit.setBounds(10, 10, 15, 14);
        bReduce.setBounds((400 - 26), 10, 17, 15);
        bOpenTabList.setBounds(141, 559, 116, 42);

        title.setBounds(0,
                (329 - title.getFontMetrics(title.getFont()).getHeight()),
                400,16);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Candara", Font.BOLD, 14));
        title.setForeground(Color.black);

        artist.setBounds(0,
                (355 - artist.getFontMetrics(artist.getFont()).getHeight()),
                400,16);
        artist.setHorizontalAlignment(SwingConstants.CENTER);
        artist.setVerticalAlignment(SwingConstants.CENTER);
        artist.setFont(new Font("Candara", Font.BOLD, 14));
        artist.setForeground(Color.black);

        timeOfRead.setBounds(333, 388, 20, 8);
        timeOfRead.setFont(new Font("Calibri", Font.BOLD, 10));
        timeOfRead.setForeground(Color.white);

        bPlay.addActionListener(new BPlayListener());
        bPause.addActionListener(new BPauseListener());
        bNext.addActionListener(new BNextListener());
        bPrevious.addActionListener(new BPreviousListener());
        bRepeat.addActionListener(new BRepeatListener());
        bQuit.addActionListener(new BQuitListener());
        bReduce.addActionListener(new BReduceListener());
        bOpenTabList.addActionListener(new BOpenTabListListener());

        bPause.setVisible(false);
        this.add(bPlay);
        this.add(bPause);
        this.add(bNext);
        this.add(bPrevious);
        this.add(bRepeat);
        this.add(bQuit);
        this.add(bReduce);
        this.add(bOpenTabList);

        this.add(title);
        this.add(artist);
        this.add(timeOfRead);
    }

    public static void updateText(String strTitle, String strArtist) {
        title.setText(strTitle);
        artist.setText(strArtist);
    }

    public static void updateTime(long min, long sec) {
        timeOfRead.setText(min + ":" + sec);
    }

    class BPlayListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            service.setPlay(true);
            bPlay.setVisible(false);
            bPause.setVisible(true);
            service.play();
        }
    }

    class BPauseListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            service.setPlay(false);
            bPlay.setVisible(true);
            bPause.setVisible(false);
            service.pause();
        }
    }

    class BNextListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            service.next();
            bPlay.setVisible(false);
            bPause.setVisible(true);
        }
    }

    class BPreviousListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            service.previous();
            bPlay.setVisible(false);
            bPause.setVisible(true);
        }
    }

    class BRepeatListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            service.repeat();
            bPlay.setVisible(false);
            bPause.setVisible(true);

        }
    }

    class BQuitListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            service.pause();
            MusicApp.closeApp();
        }
    }

    class BReduceListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            MusicApp.reduceApp();
        }
    }

    class BOpenTabListListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            ListOfMusic listOfMusic = new ListOfMusic(nbrFond);
            MusicApp.refreshApp(listOfMusic);
        }
    }

    public void paintComponent(Graphics g){	// AFFICHAGE FOND
        try {
            Image img = ImageIO.read(new File("Images/Fond" + nbrFond + ".png"));
            g.drawImage(img, 0, 0, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}