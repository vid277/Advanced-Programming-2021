import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static java.awt.font.TextAttribute.FONT;
import static javax.swing.GroupLayout.Alignment.LEADING;


class Screen_GUI{
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
        JTextField output = new JTextField("");
        GroupLayout layout = new GroupLayout(frame.getContentPane());

        title.setVerticalAlignment(SwingConstants.CENTER);

        frame.add(title);
        frame.add(dateField);
        frame.add(query); // Adds Button to content pane of frame
        frame.add(fileChooser);
        frame.add(output);// Adds Button to content pane of frame

        //Absolute positioning for the title as well as the font configurations for the title
        title.setBounds(120, 20, 250, 50);
        title.setFont(new Font("Verdana", Font.BOLD, 18));
        title.setForeground(Color.BLACK);

        //Absolute positioning for the query button as well as the font configurations for the query button
        dateField.setBounds(330, 70,150, 40);
        dateField.setFont(new Font("Verdana", Font.PLAIN, 15));
        dateField.setForeground(Color.BLACK);

        //Absolute positioning for the query button as well as the font configurations for the query button
        query.setBounds(330, 115,150, 40);
        query.setFont(new Font("Verdana", Font.PLAIN, 15));
        query.setForeground(Color.BLACK);

        //Absolute positioning for the query button as well as the font configurations for the query button
        fileChooser.setBounds(330, 160,150, 100);
        fileChooser.setFont(new Font("Verdana", Font.PLAIN, 15));
        fileChooser.setForeground(Color.BLACK);

        //Absolute positioning for the query button as well as the font configurations for the query button

        //frame.setLayout(new GridLayout(2, 3));
        frame.setVisible(true);
    }

}