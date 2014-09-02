
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class newStudent extends JFrame {

    private JButton save;
    private JButton cancel;
    private JTextField firstName;
    private JTextField midName;
    private JTextField lastName;
    private JTextField ID;
    private JTextField address;
    private JTextField city;
    private JTextField state;
    private JTextField zip;
    private JTextField home;
    private JTextField cell;
    private JTextField gpa;
    private JComboBox campus;
    private JComboBox major;
    private JTextArea csttaken;
    private JTextArea cstprogress;
    private JTextArea cstToBe;
    private JTextArea comments;
    
    String PATH;
    
    JFrame frame = new JFrame(); 
    JPanel panel = new JPanel();
    
    public newStudent(String PATH) {
        this.PATH = PATH;
        frame.setSize(700, 570);
        frame.setLocation(500, 200);
        frame.setTitle("New Student Record");

        //Creates layout
        
        GridLayout layout = new GridLayout(0,2);
        
        panel.setLayout(layout);
        
       panel.add(new JLabel("Personal Information"));
       panel.add(new JSeparator(SwingConstants.HORIZONTAL));
        
        panel.add(new JLabel("First Name"));
        firstName = new JTextField();
        panel.add(firstName);

        panel.add(new JLabel("MI"));
        midName = new JTextField();
        panel.add(midName);

        panel.add(new JLabel("Last Name"));
        lastName = new JTextField();
        panel.add(lastName);

        panel.add(new JLabel("ID #"));
        ID = new JTextField();
        panel.add(ID);

        panel.add(new JLabel("Address"));
        address = new JTextField();
        panel.add(address);

        panel.add(new JLabel("City"));
        city = new JTextField();
        panel.add(city);

        panel.add(new JLabel("State"));
        state = new JTextField();
        panel.add(state);

        panel.add(new JLabel("Zip Code"));
        zip = new JTextField();
        panel.add(zip);

        panel.add(new JLabel("Home Telephone"));
        home = new JTextField();
        panel.add(home);

        panel.add(new JLabel("Cell Phone"));
        cell = new JTextField();
        panel.add(cell);
        
        panel.add(new JLabel("Academic Information"));
        panel.add(new JSeparator(SwingConstants.HORIZONTAL));

        panel.add(new JLabel("GPA"));
        gpa = new JTextField();
        panel.add(gpa);

        String[] campuses = {null, "Eastern", "Ammerman", "Grant"};

        panel.add(new JLabel("Home Campus"));
        campus = new JComboBox(campuses);
        panel.add(campus);

        String[] majors = {null, "Computer Science", "Networking", "CIS",
            "Web Development", "Undecided"};

        panel.add(new JLabel("Major"));
        major = new JComboBox(majors);
        panel.add(major);
        
        panel.add(new JLabel("CST Courses Taken"));
        csttaken = new JTextArea();
        panel.add(new JScrollPane(csttaken));

        panel.add(new JLabel("CST Courses in Progress"));
        cstprogress = new JTextArea();
        panel.add(new JScrollPane(cstprogress));

        panel.add(new JLabel("CST Courses To Take"));
        cstToBe = new JTextArea();
        panel.add(new JScrollPane(cstToBe));
        
        panel.add(new JLabel("Additional Notes"));
        comments = new JTextArea(200,450);
        panel.add(comments);

        
        save = new JButton("Save");
        panel.add(save);
        save.addActionListener(new newStudent.saveAction());

        cancel = new JButton("Cancel");
        panel.add(cancel);
        cancel.addActionListener(new newStudent.cancelAction());
        
        frame.add(panel);
        
        frame.setVisible(true);
    }

    public class saveAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                //this will use studentio to save the file to the folder that 
                    // was created. using getText -> setField
                StudentIO newStudent = new StudentIO(PATH + "/" + ID.getText() + ".txt");

                newStudent.setFirstName(firstName.getText());
                newStudent.setMiddleName(midName.getText());
                newStudent.setLastName(lastName.getText());
                newStudent.setID(ID.getText());
                newStudent.setAddress(address.getText());
                newStudent.setCity(city.getText());
                newStudent.setState(state.getText());
                newStudent.setZipCode(zip.getText());
                newStudent.setHomeTel(home.getText());
                newStudent.setCellTel(cell.getText());
                newStudent.setGPA(gpa.getText());
                newStudent.setCampus(campus.getSelectedItem().toString());
                newStudent.setMajor(major.getSelectedItem().toString());
                newStudent.setCSTProgress(cstprogress.getText());
                newStudent.setCSTTaken(csttaken.getText());
                newStudent.setCSTToBe(cstToBe.getText());
                newStudent.setNotes(comments.getText());
                newStudent.save();
                
                 if((ID.getText().length()< 8))
                {
                JOptionPane.showMessageDialog(null,"ID needs to be 8 digits long", 
                        "Error",JOptionPane.ERROR_MESSAGE);
                }
                if((home.getText().length()<10) || (cell.getText().length() < 10))
                {
                 JOptionPane.showMessageDialog(null,"Home and cell phone number both need to be 10"
                         + "digits long", 
                        "Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                 JOptionPane.showMessageDialog(null,"Record saved","Saved"
                         , JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException ioex) {
              JOptionPane.showMessageDialog(null,"Check your submission", 
                        "Error",JOptionPane.ERROR_MESSAGE);
                ioex.printStackTrace();
            }
            frame.dispose();
        }
        
    }

    public class cancelAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    }
}
