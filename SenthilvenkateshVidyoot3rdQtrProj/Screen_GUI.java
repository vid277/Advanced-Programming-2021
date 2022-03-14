import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

class Screen_GUI{
    public static final Font Bold_LARGE  = new Font(Font.SANS_SERIF,  Font.BOLD, 22);
    public static final Font NORMAL_MEDIUM = new Font(Font.SANS_SERIF,  Font.PLAIN, 13);

    public Screen_GUI() {


        JFrame frame = new JFrame("Query");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,300);
        frame.setMaximumSize(new Dimension(500, 350));
        frame.setResizable(false);
        JLabel title = new JLabel("Animal Hospital", JLabel.CENTER);
        JButton query = new JButton("Query");
        JButton fileChooser = new JButton("Choose a file");
        JTextField dateField = new JTextField("");
        JTextArea dateFieldOutput = new JTextArea("");
        JTextArea fileChooseOutput = new JTextArea("");
        JLabel monthLabel = new JLabel("mm/dd/yyyy");
        title.setVerticalAlignment(SwingConstants.CENTER);
        JButton userFilters = new JButton("Search Options");
        frame.setLayout(null);

        frame.add(title);
        frame.add(dateField);
        frame.add(query); // Adds Button to content pane of frame
        frame.add(fileChooser);
        frame.add(fileChooseOutput);
        frame.add(dateFieldOutput);
        frame.add(monthLabel);
        frame.add(userFilters);

        title.setFont(Bold_LARGE);
        dateField.setFont(NORMAL_MEDIUM);
        query.setFont(NORMAL_MEDIUM);
        fileChooser.setFont(NORMAL_MEDIUM);


        //Absolute positioning for the title as well as the font configurations for the title
        Border border = BorderFactory.createLineBorder(Color.BLACK,1);

        title.setBounds(120, 10, 250, 50);
        title.setFont(new Font("Verdana", Font.BOLD, 22));
        title.setForeground(Color.BLACK);

        dateField.setBounds(330, 70,150, 40);
        dateField.setFont(new Font("Verdana", Font.PLAIN, 14));
        dateField.setForeground(Color.BLACK);
        dateField.setBorder(border);

        query.setBounds(330, 115,150, 40);
        query.setFont(new Font("Verdana", Font.PLAIN, 15));
        query.setForeground(Color.BLACK);

        fileChooser.setBounds(330, 160,150, 45);
        fileChooser.setFont(new Font("Verdana", Font.PLAIN, 15));
        fileChooser.setForeground(Color.BLACK);

        dateFieldOutput.setBounds(10, 70,310, 85);
        dateFieldOutput.setBorder(border);
        dateFieldOutput.setFont(NORMAL_MEDIUM);
        dateFieldOutput.setForeground(Color.BLACK);

        fileChooseOutput.setBounds(10, 160,310, 95);
        fileChooseOutput.setFont(NORMAL_MEDIUM);
        fileChooseOutput.setForeground(Color.BLACK);
        fileChooseOutput.setBorder(border);

        monthLabel.setBounds(365, 40,150, 40);
        monthLabel.setFont(new Font("Verdana", Font.BOLD, 11));
        monthLabel.setForeground(Color.BLACK);
        frame.setVisible(true);

        userFilters.setBounds(330, 210,150, 45);
        userFilters.setFont(new Font("Verdana", Font.PLAIN, 13));
        userFilters.setForeground(Color.BLACK);

        query.addActionListener(
                (evt) -> {
                    //TODO Do Something when the button here is pressed
                }
        );

        fileChooser.addActionListener(
                evt -> {
                    fileChooseOutput.setText("");
                    JFileChooser choose = new JFileChooser("./");
                    choose.setFileFilter(new FileNameExtensionFilter("txt","txt"));
                    int result = choose.showOpenDialog(frame);
                    if (result == JFileChooser.APPROVE_OPTION){
                        File selectedFile = choose.getSelectedFile();
                        String fileName = selectedFile.toString();

                        String extension = "";
                        int i = fileName.lastIndexOf('.');
                        if (i >= 0) {
                            extension = fileName.substring(i+1);
                        }
                        //System.out.println(extension);
                        if(extension.equals("txt")){
                            fileChooseOutput.setForeground(Color.BLACK);
                            fileChooseOutput.setText("File Successfully Imported!");
                            try {
                                runPrograms(choose.getSelectedFile().toString());
                            } catch (FileNotFoundException e) {
                                JOptionPane.showMessageDialog(frame, "Please choose a '.txt' file!");                                }
                        }
                        else {
                            JOptionPane.showMessageDialog(frame, "Please choose a '.txt' file!");
                        }
                    }
                    else{
                        fileChooseOutput.setText("Please choose a file!");
                        fileChooseOutput.setForeground(Color.RED);
                    }
                }
        );
    }

    public void runPrograms(String fileName) throws FileNotFoundException {
        AnimalHospital runFiles = new AnimalHospital(fileName);
    }

}