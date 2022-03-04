import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class Screen_GUI extends JFrame {
    /**
     * Constructor for objects of class Calculator
     */
    private int clicks;
    private String[] buttons;

    public Screen_GUI() throws IOException {
        JFrame frame = new JFrame("Animal Hospital");
        setLayout(new BorderLayout());
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(400, 300));
        JLabel emp1 = new JLabel(" ", JLabel.CENTER);
        JLabel title = new JLabel("Please choose one", JLabel.CENTER);
        JLabel title2 = new JLabel(" of the following: ", JLabel.CENTER);
        JLabel emp3 = new JLabel(" ", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 24));
        title2.setFont(new Font("Serif", Font.PLAIN, 24));

        buttons = new String[7];

        title.setBackground(Color.ORANGE);
        title2.setBackground(Color.ORANGE);

        p.setLayout(new GridLayout(4, 2, 1, 1));

        p.add(title, BorderLayout.CENTER);
        add(p, BorderLayout.CENTER);
        pack();
        setVisible(true);

        p.setBackground(Color.WHITE);
    }
}