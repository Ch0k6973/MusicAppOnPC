import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Bouton extends JButton implements MouseListener{

    private String fond;

    public Bouton(String fond){
        this.fond = fond;
        this.setOpaque(false);
        this.setFocusPainted(false);
        this.setBorderPainted(false);

        this.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent event) {
    }

    public void mouseEntered(MouseEvent event) {

    }

    public void mouseExited(MouseEvent event) {

    }

    public void mousePressed(MouseEvent event) {

    }

    public void mouseReleased(MouseEvent event) {

    }

    public void paintComponent(Graphics g){	// AFFICHAGE FOND
        try {
            Image img = ImageIO.read(new File("Images/" + fond + ".png"));
            g.drawImage(img, 0, 0, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}