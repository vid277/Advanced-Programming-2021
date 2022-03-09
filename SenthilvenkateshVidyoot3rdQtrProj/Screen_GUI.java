import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static java.awt.font.TextAttribute.FONT;
import static javax.swing.GroupLayout.Alignment.LEADING;


class Screen_GUI{
    public static final Font Bold_LARGE  = new Font(Font.SANS_SERIF,  Font.BOLD, 22);
    public static final Font BOLD_MEDIUM = new Font(Font.SANS_SERIF,  Font.BOLD, 16);
    public static final Font NORMAL_LARGE = new Font(Font.SANS_SERIF,  Font.PLAIN, 22);
    public static final Font NORMAL_MEDIUM = new Font(Font.SANS_SERIF,  Font.PLAIN, 16);

    public Screen_GUI(){
        JFrame frame = new JFrame("Query");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,300);
        frame.setMaximumSize(new Dimension(500, 350));
        frame.setResizable(false);
        JLabel title = new JLabel("Animal Hospital", JLabel.CENTER);
        JButton query = new JButton("Query");
        JButton fileChooser = new JButton("Choose a file");
        JTextField dateField = new JTextField("");
        JLabel dateFieldOutput = new JLabel("Hi!");
        JPanel panelOut = new JPanel();
        title.setVerticalAlignment(SwingConstants.CENTER);
        frame.setLayout(new FlowLayout(1, 10, 10));
        //frame.add(dateFieldOutput);

        frame.add(title);
        frame.add(dateField);
        frame.add(query); // Adds Button to content pane of frame
        frame.add(fileChooser);
        frame.add(panelOut);
        frame.add(dateFieldOutput);
        //frame.add(panelOut);


        title.setFont(Bold_LARGE);
        dateField.setFont(NORMAL_MEDIUM);
        query.setFont(NORMAL_MEDIUM);
        fileChooser.setFont(NORMAL_MEDIUM);

        /**
        Absolute positioning for the title as well as the font configurations for the title
        title.setBounds(120, 20, 250, 50);
        title.setFont(new Font("Verdana", Font.BOLD, 22));
        title.setForeground(Color.BLACK);

        dateField.setBounds(330, 70,150, 40);
        dateField.setFont(new Font("Verdana", Font.PLAIN, 15));
        dateField.setForeground(Color.BLACK);

        query.setBounds(330, 115,150, 40);
        query.setFont(new Font("Verdana", Font.PLAIN, 15));
        query.setForeground(Color.BLACK);

        fileChooser.setBounds(330, 160,150, 100);
        fileChooser.setFont(new Font("Verdana", Font.PLAIN, 15));
        fileChooser.setForeground(Color.BLACK);

        dateFieldOutput.setBounds(330, 160,150, 100);
        dateFieldOutput.setFont(new Font("Verdana", Font.PLAIN, 18));
        dateFieldOutput.setForeground(Color.BLACK);
        dateFieldOutput.setHorizontalAlignment(SwingConstants.LEFT);*/


        //frame.setLayout(new GridLayout(2, 3));
        frame.setVisible(true);
    }

}