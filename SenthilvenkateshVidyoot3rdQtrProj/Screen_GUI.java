import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;

class Screen_GUI{
    public static final Font Bold_LARGE  = new Font(Font.SANS_SERIF,  Font.BOLD, 22);
    public static final Font NORMAL_MEDIUM = new Font(Font.SANS_SERIF,  Font.PLAIN, 14);
    public String file;
    public boolean fileState = false;

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
        JScrollPane Scroll = new JScrollPane(dateFieldOutput);
        Scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        frame.add(title);
        frame.add(dateField);
        frame.add(query); // Adds Button to content pane of frame
        frame.add(fileChooser);
        frame.add(fileChooseOutput);
        //frame.add(dateFieldOutput);
        frame.add(monthLabel);
        frame.add(userFilters);
        frame.add(Scroll);
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

        Scroll.setBounds(10, 70,310, 85);
        Scroll.setBorder(border);
        Scroll.setFont(NORMAL_MEDIUM);
        Scroll.setForeground(Color.BLACK);
        dateFieldOutput.setEditable(false);

        fileChooseOutput.setBounds(10, 160,310, 95);
        fileChooseOutput.setFont(NORMAL_MEDIUM);
        fileChooseOutput.setForeground(Color.BLACK);
        fileChooseOutput.setBorder(border);
        fileChooseOutput.setEditable(false);

        monthLabel.setBounds(365, 40,150, 40);
        monthLabel.setFont(new Font("Verdana", Font.BOLD, 11));
        monthLabel.setForeground(Color.BLACK);
        frame.setVisible(true);

        userFilters.setBounds(330, 210,150, 45);
        userFilters.setFont(new Font("Verdana", Font.PLAIN, 13));
        userFilters.setForeground(Color.BLACK);
        dateFieldOutput.setLineWrap(true);
        dateFieldOutput.setWrapStyleWord(true);

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
                                fileState = true;
                                file = fileName;
                                AnimalHospital runFiles = new AnimalHospital(fileName);
                                dateFieldOutput.setText(" ");
                                for (int x = 0; x < runFiles.getPets().size(); x++){
                                    String prevLine = runFiles.getPets().get(x).guiPrint();
                                    dateFieldOutput.append(prevLine);
                                }
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
                        fileState = false;
                    }
                }
        );

        userFilters.addActionListener(avt -> {
            String[] buttons = { "Search by pet name", "Search by owner name", "Cancel" };

            int choicePane = JOptionPane.showOptionDialog(frame, "Choose a search method: ", "Search Method",
                    JOptionPane.DEFAULT_OPTION, 2, null, buttons, buttons[2]);

            System.out.println(choicePane);

            if (choicePane == 0) {
                String userInput = JOptionPane.showInputDialog(frame, "Input the name of the pet: ");
                try {
                    if (fileState){
                        AnimalHospital runFiles = new AnimalHospital(file);
                        dateFieldOutput.setText(runFiles.printPetInfoByName(userInput).toString());
                    }
                    else {
                        fileChooseOutput.setText("Please choose a file first!");
                        JOptionPane.showMessageDialog(frame, "Please choose a file first!");
                    }
                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(frame, "Please choose a '.txt' file!");
                }
            }
            else if (choicePane == 1){
                String userInput = JOptionPane.showInputDialog(frame, "Input the name of the owner: ");
                try {
                    if (fileState){
                        AnimalHospital runFiles = new AnimalHospital(file);
                        dateFieldOutput.setText(runFiles.printPetInfoByOwner(userInput).toString());
                    }
                    else {
                        fileChooseOutput.setText("Please choose a file first!");
                        JOptionPane.showMessageDialog(frame, "Please choose a file first!");
                    }
                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(frame, "Please choose a '.txt' file!");
                }
            }
        });

        query.addActionListener( evt -> {
            String date = dateField.getText();
            if (date.length() != 10){
                JOptionPane.showMessageDialog(frame, "Date invalid!", "Warning!",JOptionPane.WARNING_MESSAGE);
                dateField.setText("");
            }
            else {
                if (checkIfValid(date)){
                    int month = Integer.parseInt(date.substring(0, 2));
                    int day = Integer.parseInt(date.substring(3, 5));
                    int year = Integer.parseInt(date.substring(6, 10));

                    try {
                        if (fileState) {
                            AnimalHospital runFiles = new AnimalHospital(file);
                            if (month < 0 || month > 12 || day < 0 || day > 31) {
                                throw new IllegalDateException("Illegal Date:", month + "/" + day + "/" + year);
                            } else {
                                runFiles.printPetsBoarding(month, day, year);
                            }
                        }
                        else {
                            fileChooseOutput.setText("Please choose a file first!");
                            JOptionPane.showMessageDialog(frame, "Please choose a file first!");
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println(e);
                    }

                    System.out.println(month + " " + day + " " + year);
                }
                else {
                        JOptionPane.showMessageDialog(frame, "Date invalid!", "Warning!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public boolean checkIfValid(String dateInput) {
        boolean valid = false;
        dateInput = dateInput.replaceAll("/", "");
        for (int i = 0; i < dateInput.length(); i++) {
            if (Character.isDigit(dateInput.charAt(i))) {
                valid = true;
            }
            else{
                valid = false;
                break;
            }
        }
        return valid;
    }
}
