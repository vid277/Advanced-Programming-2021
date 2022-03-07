import javax.swing.*;
import java.awt.*;

class Screen_GUI{
    public Screen_GUI(){
        JFrame frame = new JFrame("Query");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        JButton query = new JButton("Query");
        JButton fileChooser = new JButton("Choose a file");
        frame.add(query); // Adds Button to content pane of frame
        frame.add(fileChooser); // Adds Button to content pane of frame
        frame.SetLayout(new FrameLayout(1, 1))
        frame.setVisible(true);
    }

}