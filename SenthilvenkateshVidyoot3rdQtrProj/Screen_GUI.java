import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Screen_GUI extends JFrame {
    /**
     * Constructor for objects of class Calculator
     */
    private int clicks;
    private String[] buttons;

    public Screen_GUI() throws IOException {

        BufferedImage image = ImageIO.read(
                new URL(".//img1.jpg"));

        JPanel p = new JPanel();
        JFrame frame = new JFrame("Animal Hospital");
        frame.setSize(1920, 1080);

        frame.setBackground(Color.blue);
        frame.setVisible(true);

        JOptionPane jPane = new JOptionPane();

        p.show();
        pack();
    }
}