import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MusicApp {

    private static JFrame window;
    private static Screen screen;

    public static void main(String[] args) throws IOException {

        window = new JFrame();
        screen = new Screen();

        window.setTitle("Ma première fenêtre Java");
        window.setSize(400, 600);
        window.setLocationRelativeTo(null);
        window.setUndecorated(true);
        window.setContentPane(screen);
        window.setVisible(true);
    }

    public static JFrame getWindow() {
        return window;
    }

    public static Screen getScreen() {
        return screen;
    }

    public static void closeApp() {
        window.dispose();
    }
    public static void reduceApp() {
        window.setExtendedState(JFrame.ICONIFIED);
    }
    public static void refreshApp(JPanel panel) {
        window.setContentPane(panel);
        window.revalidate();
    }

}
