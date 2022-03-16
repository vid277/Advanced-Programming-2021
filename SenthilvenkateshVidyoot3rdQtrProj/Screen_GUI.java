import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import static javax.swing.JOptionPane.showInputDialog;

/**
 * This is the screen gui class that displays a user-friendly interface
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 3/15/2022
 */
class Screen_GUI {

    /**
     * constants for BOLD_LARGE and NORMAL_MEDIUM that are used to set the font size for the buttons and some labels
     */
    public static final Font Bold_LARGE = new Font(Font.SANS_SERIF, Font.BOLD, 22);
    public static final Font NORMAL_MEDIUM = new Font(Font.SANS_SERIF, Font.PLAIN, 14);

    //Stores the name of the file
    public String file;

    //Checks whether the user has already input a file or not
    public boolean fileState = false;

    /**
     * Instantiates the gui and also displays the interface to the user
     */
    public Screen_GUI() {

        //The frame that is displayed to the user
        JFrame frame = new JFrame("Query");

        //Changing the background color of the frame
        frame.getContentPane().setBackground(new Color(111, 178, 210));

        //Stops the application from running when closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(500, 300);
        frame.setMaximumSize(new Dimension(500, 350));

        //The window cannot be resized
        frame.setResizable(false);

        //All the components that are added to the screen
        JLabel title = new JLabel("Animal Hospital", JLabel.CENTER);
        JButton query = new JButton("Query");
        JButton fileChooser = new JButton("Choose a file");
        JTextField dateField = new JTextField("");
        JTextArea dateFieldOutput = new JTextArea("");
        JTextArea fileChooseOutput = new JTextArea("");
        JLabel monthLabel = new JLabel("mm/dd/yyyy");
        title.setVerticalAlignment(SwingConstants.CENTER);
        JButton userFilters = new JButton("Search Options");

        //Setting the colors of the buttons and the title
        title.setForeground(new Color(238, 238, 238));
        monthLabel.setForeground(new Color(238, 238, 238));
        query.setBackground(new Color(133, 200, 138));
        fileChooser.setBackground(new Color(133, 200, 138));
        userFilters.setBackground(new Color(133, 200, 138));
        query.setForeground(Color.BLACK);

        //Using the null layout manager rather than the default java layout manager
        frame.setLayout(null);
        JScrollPane Scroll = new JScrollPane(dateFieldOutput);
        JButton addLog = new JButton("Add a log");
        Scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        //Adds button to content pane of frame
        frame.add(title);
        frame.add(dateField);
        frame.add(query);
        frame.add(fileChooser);
        frame.add(fileChooseOutput);
        frame.add(addLog);
        frame.add(monthLabel);
        frame.add(userFilters);
        frame.add(Scroll);

        //Sets the font of these elements
        title.setFont(Bold_LARGE);
        dateField.setFont(NORMAL_MEDIUM);
        query.setFont(NORMAL_MEDIUM);
        fileChooser.setFont(NORMAL_MEDIUM);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

        //Absolute positioning for the title as well as the font configurations for the title
        //Sets the layout of all the elements on the frame
        //Also changes the font, and adds border to some of these elements
        title.setBounds(120, 10, 250, 50);
        title.setFont(new Font("Verdana", Font.BOLD, 22));

        //Absolute positioning for the date field
        //Sets the layout of the date field on the frame
        dateField.setBounds(330, 70, 150, 40);
        dateField.setFont(new Font("Verdana", Font.PLAIN, 14));
        dateField.setForeground(Color.BLACK);
        dateField.setBorder(border);

        //Absolute positioning for the query button
        //Sets the layout of the query field on the frame
        query.setBounds(330, 115, 150, 40);
        query.setFont(new Font("Verdana", Font.PLAIN, 15));
        query.setForeground(Color.BLACK);

        //Absolute positioning for the file Chooser button
        //Sets the layout of the file chooser on the frame
        fileChooser.setBounds(330, 160, 150, 45);
        fileChooser.setFont(new Font("Verdana", Font.PLAIN, 15));

        //Sets the layout of the output box that contains the scrolling action on the GUI screen
        Scroll.setBounds(10, 70, 310, 85);
        Scroll.setBorder(border);
        Scroll.setFont(NORMAL_MEDIUM);
        Scroll.setForeground(Color.BLACK);
        dateFieldOutput.setEditable(false);

        //Sets the position of the file choose output menu
        //Also changes the font of the file choose output
        fileChooseOutput.setBounds(10, 160, 310, 45);
        fileChooseOutput.setFont(NORMAL_MEDIUM);
        fileChooseOutput.setForeground(Color.BLACK);
        fileChooseOutput.setBorder(border);
        fileChooseOutput.setEditable(false);

        //This is a button to add a lot to the text file
        //Also sets the positioning of the add log button
        addLog.setBounds(10, 210, 310, 45);
        addLog.setFont(new Font("Verdana", Font.BOLD, 13));
        addLog.setBorder(border);
        addLog.setBackground(new Color(133, 200, 138));

        //This is just a label for the month format
        monthLabel.setBounds(365, 40, 150, 40);
        monthLabel.setFont(new Font("Verdana", Font.BOLD, 11));
        frame.setVisible(true);

        userFilters.setBounds(330, 210, 150, 45);
        userFilters.setFont(new Font("Verdana", Font.PLAIN, 13));

        //Allows the dateFieldOutput text area to wrap around
        dateFieldOutput.setLineWrap(true);
        dateFieldOutput.setWrapStyleWord(true);

        //Adds an action listener to the file chooser button
        //This prompts the user with a JFileChooser menu
        fileChooser.addActionListener(
                //Using a lambda for cleaner code
                evt -> {
                    fileChooseOutput.setText("");

                    //Changing the file directory to this current project
                    JFileChooser choose = new JFileChooser("./");

                    //Making sure that a 'txt' file is input
                    choose.setFileFilter(new FileNameExtensionFilter("txt", "txt"));
                    int result = choose.showOpenDialog(frame);

                    //Runs only when the user approves the option
                    if (result == JFileChooser.APPROVE_OPTION) {

                        //Stores the file input
                        File selectedFile = choose.getSelectedFile();

                        //Stores the name of the file
                        String fileName = selectedFile.toString();

                        //Finds the file extension
                        String extension = "";
                        int i = fileName.lastIndexOf('.');
                        if (i >= 0) {
                            extension = fileName.substring(i + 1);
                        }
                        //System.out.println(extension);

                        //Makes sure that the file input is a txt file
                        if (extension.equals("txt")) {

                            //Outputs a success message
                            fileChooseOutput.setForeground(Color.BLACK);
                            fileChooseOutput.setText("File Successfully Imported!");
                            try {
                                //Makes the fileState true, to indicate that a file has been chosen
                                fileState = true;
                                file = fileName;

                                //Creates a new AnimalHospital using the given file name
                                AnimalHospital runFiles = new AnimalHospital(fileName);
                                dateFieldOutput.setText(" ");
                                for (int x = 0; x < runFiles.getPets().size(); x++) {
                                    String prevLine = runFiles.getPets().get(x).guiPrint();

                                    //Appends all the lines to the text output box
                                    dateFieldOutput.append(prevLine);
                                }
                                //The button is disabled once a file has been chosen
                                fileChooser.setEnabled(false);
                            } catch (FileNotFoundException e) {
                                //Outputs an error to the user when the does not select a txt file
                                JOptionPane.showMessageDialog(frame, "Please choose a '.txt' file!");
                            }
                        } else {
                            //Outputs an error to the user when the does not select a txt file
                            JOptionPane.showMessageDialog(frame, "Please choose a '.txt' file!");
                        }
                    } else {
                        //Outputs an error to the user when the does not select a file
                        fileChooseOutput.setText("Please choose a file!");
                        fileChooseOutput.setForeground(Color.RED);
                    }
                }
        );

        //Possible user search options
        userFilters.addActionListener(avt -> {

            //User search options and filters to use
            String[] buttons = {"Search by pet name", "Search by owner name", "Cancel"};

            //Allows the user to choose one of these options
            int choicePane = JOptionPane.showOptionDialog(frame, "Choose a search method: ", "Search Method",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, buttons, buttons[2]);

            //System.out.println(choicePane);

            //Search by the pet name
            if (choicePane == 0) {
                String userInput = showInputDialog(frame, "Input the name of the pet: ");
                try {
                    //The file has to be chosen before any of the options can be selected
                    if (fileState) {
                        AnimalHospital runFiles = new AnimalHospital(file);

                        //Changes the text of the output box when the name of the pet cannot be found
                        if (runFiles.printPetInfoByName(userInput) == null) {

                            //Outputs an error when the name of the pet is not found in the log
                            dateFieldOutput.setText("Name not found!");
                            JOptionPane.showMessageDialog(frame, "Name not found!", "Warning!", JOptionPane.WARNING_MESSAGE);

                        } else {
                            //Sets the text of the output text field to the animals that contain the name that was input
                            dateFieldOutput.setText(runFiles.printPetInfoByName(userInput).toString());
                        }
                    } else {
                        //Shows an error when the user does not choose a file
                        fileChooseOutput.setText("Please choose a file first!");
                        JOptionPane.showMessageDialog(frame, "Please choose a file first!");
                    }
                } catch (FileNotFoundException e) {
                    //Shows an error when the user does not choose a txt file
                    JOptionPane.showMessageDialog(frame, "Please choose a '.txt' file!");
                }
            }
            //Search by owner name
            else if (choicePane == 1) {
                //Asks to input the name of the owner
                String userInput = showInputDialog(frame, "Input the name of the owner: ");
                try {
                    if (fileState) {
                        AnimalHospital runFiles = new AnimalHospital(file);
                        //When the name of owner cannot be found, this method returns null instead
                        //Important to check the return statement of this method for null
                        if (runFiles.printPetInfoByOwner(userInput) == null) {
                            //Changes the text of the output box when the name of the owner cannot be found
                            dateFieldOutput.setText("Name not found!");
                            JOptionPane.showMessageDialog(frame, "Name not found!", "Warning!", JOptionPane.WARNING_MESSAGE);
                        } else {
                            //Sets the text of the output text field to the animals that boarded on that date
                            dateFieldOutput.setText(runFiles.printPetInfoByOwner(userInput).toString());
                        }
                    } else {
                        //Outputs an error when the name of the owner is not found in the log
                        fileChooseOutput.setText("Please choose a file first!");
                        JOptionPane.showMessageDialog(frame, "Please choose a file first!");
                    }
                } catch (FileNotFoundException e) {
                    //Shows an error when the user does not choose a text file
                    JOptionPane.showMessageDialog(frame, "Please choose a '.txt' file!");
                }
            }
        });

        //Query a certain date and display the animals boarded during that date
        query.addActionListener(evt -> {
            //Gets the text of the date field
            String date = dateField.getText();
            if (date.length() != 10) {
                //Shows an error when the length of the date field is not equal to 10
                JOptionPane.showMessageDialog(frame, "Date invalid!", "Warning!", JOptionPane.WARNING_MESSAGE);
                dateField.setText("");

            } else {
                //This only should run when the date field is valid
                if (checkIfValid(date)) {
                    //Stores the values for month, day, and year
                    int month = 0;
                    int day = 0;
                    int year = 0;

                    try {
                        //Try to parse the integer and warn the user if the date contains any letters and cannot be parsed
                        month = Integer.parseInt(date.substring(0, 2));
                        day = Integer.parseInt(date.substring(3, 5));
                        year = Integer.parseInt(date.substring(6, 10));
                    } catch (NumberFormatException e) {
                        //Warn the user if the date input is invalid
                        JOptionPane.showMessageDialog(frame, "Date invalid!", "Warning!", JOptionPane.WARNING_MESSAGE);
                    }

                    try {
                        //Makes sure that a file is selected before this can be computed
                        if (fileState) {
                            AnimalHospital runFiles = new AnimalHospital(file);
                            //Checks that the date input falls within these ranges
                            if (month < 0 || month > 12 || day < 0 || day > 31) {
                                //Throws an exception if the date is invalid
                                throw new IllegalDateException("Illegal Date:", month + "/" + day + "/" + year);
                            } else {
                                    //If the list of animals boarding on that date is not 0, then the text is output
                                    //else the user is notified that no animals are found for that given date
                                    if (runFiles.printPetsBoarding(month, day, year).size() != 0){
                                        dateFieldOutput.setText(runFiles.printPetsBoarding(month, day, year).toString().replace("[", "").replace("]", ""));
                                    }
                                    else {
                                        //When the size of the list containing the animals boarding on a certain day is not 0
                                        fileChooseOutput.setText("No animal found for this date!");
                                        JOptionPane.showMessageDialog(frame, "No animal found for this date!");
                                    }
                                }
                        } else {
                            //Warns the user if a file has not yet been chosen
                            fileChooseOutput.setText("Please choose a file first!");
                            JOptionPane.showMessageDialog(frame, "Please choose a file first!");
                        }
                    } catch (FileNotFoundException e) {
                        //When the file cannot be found
                        System.out.println(e);
                    } catch (IllegalDateException e) {
                        //Showing an error when the date input is invalid
                        fileChooseOutput.setText("Input a valid date!");
                        JOptionPane.showMessageDialog(frame, "Input a valid date!");
                    }

                    System.out.println(month + " " + day + " " + year);
                } else {
                    //Showing an error when the date input is invalid
                    JOptionPane.showMessageDialog(frame, "Date invalid!", "Warning!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        addLog.addActionListener(avt -> {
            //Storing all the user inputs, to later be processed
            String petName;
            String ownerName;
            String ownerEmail;
            String color;
            String gender;
            String hairLength;
            String size;

            //This should only run when the user inputs a file/when a file is selected
            if (fileState){

                //Series of questions that is used to collect data about the pet
                //Makes sure that the input is not null and is not empty
                String type = JOptionPane.showInputDialog(frame, "Input the type of pet 'Cat, Dog, or Bird'");
                if(type != null && !type.equals("") && !type.equals(" ")){
                    if (type.equalsIgnoreCase("cat") || type.equalsIgnoreCase("dog") || type.equalsIgnoreCase("bird")){
                        ownerName = JOptionPane.showInputDialog(frame, "Input owner name!");
                        if (ownerName != null && !ownerName.equals("") && !ownerName.equals(" ")){
                            ownerEmail = JOptionPane.showInputDialog(frame, "Input owner email!");
                            //Validates the email and makes sure that it is right. Warns the user if the email is invalid.
                            try {
                                EmailValidator(ownerEmail);
                            } catch (IllegalEmailException e){
                                JOptionPane.showMessageDialog(frame, "Invalid Email!", "Warning!", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                            if (ownerEmail != null && !ownerEmail.equals("") && !ownerEmail.equals(" ")){
                                petName = JOptionPane.showInputDialog(frame, "Input pet name!");
                                if (petName != null  && !petName.equals("") && !petName.equals(" ")){
                                    color = JOptionPane.showInputDialog(frame, "Input pet color!");
                                    if(color != null && !color.equals("") && !color.equals(" ")){
                                        gender = JOptionPane.showInputDialog(frame, "Input pet gender!");
                                        if (gender != null && !gender.equals("") && !gender.equals(" ")){
                                            if (gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("neutered") || gender.equalsIgnoreCase("spayed")){
                                                if (type.equalsIgnoreCase("dog")){
                                                    size = JOptionPane.showInputDialog(frame, "Input dog size!");
                                                    if (size != null  && !size.equals("") && !size.equals(" ")){
                                                        JOptionPane.showMessageDialog(frame, "Confirm?", "Save", JOptionPane.ERROR_MESSAGE);

                                                        //Tries to send the data provided by the user to get added to the file
                                                        try {
                                                            sendDataDog(type, ownerName, ownerEmail, petName, color, gender, size);
                                                        } catch (FileNotFoundException e) {
                                                            System.out.println(e);
                                                        }
                                                    }
                                                    else {
                                                        JOptionPane.showMessageDialog(frame, "Input dog size!", "Warning!", JOptionPane.WARNING_MESSAGE);
                                                    }
                                                }
                                                else if (type.equalsIgnoreCase("cat")){
                                                    hairLength = JOptionPane.showInputDialog(frame, "Input cat hair length!");
                                                    if (hairLength != null && !hairLength.equals("") && !hairLength.equals(" ")){
                                                        JOptionPane.showMessageDialog(frame, "Confirm?", "Save", JOptionPane.ERROR_MESSAGE);
                                                        //Tries to send the data provided by the user to get added to the file
                                                        try {
                                                            sendDataCat(type, ownerName, ownerEmail, petName, color, gender, hairLength);
                                                        } catch (FileNotFoundException e) {
                                                            System.out.println(e);
                                                        }
                                                    }
                                                    else {
                                                        JOptionPane.showMessageDialog(frame, "Input hair length!", "Warning!", JOptionPane.WARNING_MESSAGE);
                                                    }
                                                }
                                                else if (type.equalsIgnoreCase("bird")){
                                                    JOptionPane.showMessageDialog(frame, "Confirm?", "Save", JOptionPane.ERROR_MESSAGE);
                                                    //Tries to send the data provided by the user to get added to the file
                                                    try {
                                                        sendDataBird(type, ownerName, ownerEmail, petName, color, gender);
                                                    } catch (FileNotFoundException e) {
                                                        System.out.println(e);
                                                    }
                                                }
                                            }

                                            //Throws an exception if the date input by the user is empty or is null
                                            else{
                                                JOptionPane.showMessageDialog(frame, "Incorrect pet gender!", "Warning!", JOptionPane.WARNING_MESSAGE);
                                            }
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(frame, "Input the pet gender!", "Warning!", JOptionPane.WARNING_MESSAGE);
                                        }
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(frame, "Input a pet color!", "Warning!", JOptionPane.WARNING_MESSAGE);
                                    }
                                }
                                else {
                                    JOptionPane.showMessageDialog(frame, "Input a pet name!", "Warning!", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                            else {
                                JOptionPane.showMessageDialog(frame, "Input an owner email!", "Warning!", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(frame, "Input an owner name!", "Warning!", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(frame, "Invalid Pet Type!", "Warning!", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } else {
                fileChooseOutput.setText("Please choose a file first!");
                JOptionPane.showMessageDialog(frame, "Please choose a file first!");
            }}
            );
    }

    /**
     * Checks whether the date input by the user is valid
     *
     * @param dateInput the date input by the user
     * @return whether the date input is valid
     */
    public boolean checkIfValid(String dateInput) {
        boolean valid = false;
        dateInput = dateInput.replaceAll("/", "");
        for (int i = 0; i < dateInput.length(); i++) {
            if (Character.isDigit(dateInput.charAt(i))) {
                valid = true;
            } else {
                valid = false;
                break;
            }
        }
        return valid;
    }

    /**
     * Writes the data to a file given all the required information about the bird
     *
     * @param type the type of the pet - in this case it is a bird
     * @param ownerName the pet owner's name
     * @param ownerEmail the pet owner's email address
     * @param petName the name of the pet
     * @param color the color of the pet
     * @param gender the gender of the pet
     * @throws FileNotFoundException if the file to write to does not exists or is not found
     */
    public void sendDataBird(String type, String ownerName, String ownerEmail, String petName, String color, String gender) throws FileNotFoundException {
        try {
            //Used to append the data given by the user to the text file using the print writer
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));

            pw.println("\n" + type.toUpperCase());
            pw.printf("%s %s %s %s %s", petName, ownerName, ownerEmail, color, gender);

            //Closes the print writer once all the data has been written to the file
            pw.close();
        } catch (IllegalEmailException e){
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Illegal Email");
        }
    }

    /**
     * Writes the given data to the text file based on the user input about the dog
     *
     * @param type the type of pet - in this case, it is a dog
     * @param ownerName the dog's owner's name
     * @param ownerEmail the owner's email address
     * @param petName the name of the dog
     * @param color the color of the dog
     * @param gender the gender of the dog
     * @param size the general size of the dog
     * @throws FileNotFoundException if the file to write to does not exist
     */
    public void sendDataDog(String type, String ownerName, String ownerEmail, String petName, String color, String gender, String size) throws FileNotFoundException {
        try {
            //Used to write data to the text file
            //Appends the data to the file, rather than clearing out the entire file
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));

            pw.println("\n" + type.toUpperCase());
            pw.printf("%s %s %s %s %s %s", petName, ownerName, ownerEmail, color, gender, size);

            //Closes the print writer once all the data has been written to the file
            pw.close();
        } catch (IllegalEmailException e){
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Illegal Email");
        }
    }

    /**
     * Writes the input data to a file.
     *
     * @param type the type of pet - In this case, it is a cat. Used to write data to the file.
     * @param ownerName the name of the cat's owner
     * @param ownerEmail the cat's owner's email
     * @param petName the name of the cat
     * @param color the color of the cat
     * @param gender the gender of the cat
     * @param hairLength the hairLength of the cat
     * @throws FileNotFoundException if the file to write to does not exist
     */
    public void sendDataCat(String type, String ownerName, String ownerEmail, String petName, String color, String gender, String hairLength) throws FileNotFoundException {
        try {
            //Used to write data to the text file
            //Makes sure that data is being append to the text file rather than it clearing the entire file
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));

            //Writes the required data
            pw.println("\n"+type.toUpperCase());
            pw.printf("%s %s %s %s %s %s", petName, ownerName, ownerEmail, color, gender, hairLength);

            //Closes the file once done writing to ensure complete text output
            pw.close();
        } catch (IllegalEmailException e) {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Illegal Email");
        }
    }

    /**
     * Ensures that the email of the owner is valid
     *
     * @param ownerEmail the email of the owner
     */
    public void EmailValidator(String ownerEmail){
        //Matches the provided email to the RegEx pattern
        if (!(Pattern.compile(Pet.EMAIL_VALIDATION_PATTERN).matcher(ownerEmail).matches())){
            throw new IllegalEmailException("Illegal Email: " + ownerEmail);
        }
    }
}
