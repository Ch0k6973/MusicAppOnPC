import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListOfMusic extends JPanel {

    private static JLabel jLabelFond = new JLabel(new ImageIcon("Images/listeMusique.png"));
    public Bouton bQuit = new Bouton("Quit");
    public Bouton bReduce = new Bouton("Reduce");
    public Bouton bCloseTabList = new Bouton("closeTabList");
    private JPanel list = new JPanel();
    private JScrollPane scroll = new JScrollPane(list);

    private int fond;

    public ListOfMusic(int fond) {

        this.fond = fond;
        this.setLayout(null);
        this.setFocusable(true);

        jLabelFond.setBounds(0, 23, 400, 577);
        bQuit.setBounds(10, 10, 15, 14);
        bReduce.setBounds((400 - 26), 10, 17, 15);
        bCloseTabList.setBounds(141, 23, 116, 42);
        list.setBounds(0, 0, 390, 5000);
        scroll.setBounds(0, 90, 400, 440);

        bQuit.addActionListener(new BQuitListener());
        bReduce.addActionListener(new BReduceListener());
        bCloseTabList.addActionListener(new BCloseTabListListener());

        list.setOpaque(false);
        list.setLayout(null);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setWheelScrollingEnabled(true);
        scroll.setBorder(getBorder());

        this.add(bQuit);
        this.add(bReduce);
        this.add(jLabelFond);
        this.add(bCloseTabList);

        initList(Service.getSounds());
        jLabelFond.add(scroll);
    }

    public void initList(List<Sound> sounds) {

        int posY = 10;

        for (int i = 0; i < sounds.size(); i++) {

            JLabel indexList = new JLabel("" + (i + 1) + "\n");
            JLabel titleList = new JLabel(sounds.get(i).getTitle());
            JLabel artistList = new JLabel(sounds.get(i).getArtist());

            indexList.setBounds(50, posY, indexList.getFontMetrics(indexList.getFont()).stringWidth("" + (i + 1) + ""),
                    indexList.getFontMetrics(indexList.getFont()).getHeight());
            titleList.setBounds(100, posY, titleList.getFontMetrics(titleList.getFont()).stringWidth(sounds.get(i).getTitle()),
                    titleList.getFontMetrics(titleList.getFont()).getHeight());

            posY = posY + titleList.getFontMetrics(titleList.getFont()).getHeight();

            artistList.setBounds(100, posY, artistList.getFontMetrics(artistList.getFont()).stringWidth(sounds.get(i).getArtist()),
                    artistList.getFontMetrics(artistList.getFont()).getHeight());

            indexList.setForeground(Color.white);
            titleList.setForeground(Color.white);
            artistList.setForeground(Color.white);

            list.add(indexList);
            list.add(titleList);
            list.add(artistList);

            posY = posY + artistList.getFontMetrics(titleList.getFont()).getHeight() + 10;
        }
    }

    class BQuitListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            Service.pause();
            MusicApp.closeApp();
        }
    }

    class BReduceListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            MusicApp.reduceApp();
        }
    }

    class BCloseTabListListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            MusicApp.refreshApp(MusicApp.getScreen());
        }
    }

    public void paintComponent(Graphics g){	// AFFICHAGE FOND
        try {
            Image img = ImageIO.read(new File("Images/Fond" + fond + ".png"));
            g.drawImage(img, 0, 0, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
