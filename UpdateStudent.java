
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class UpdateStudent extends JFrame {

    private JButton save;
    private JButton cancel;
    private JTextField firstName = new JTextField();
    private JTextField midName = new JTextField();
    private JTextField lastName = new JTextField();
    private JTextField ID = new JTextField();
    private JTextField address = new JTextField();
    private JTextField city = new JTextField();
    private JTextField state = new JTextField();
    private JTextField zip = new JTextField();
    private JTextField home = new JTextField();
    private JTextField cell = new JTextField();
    private JTextField gpa = new JTextField();
    String[] campuses = {null, "Eastern", "Ammerman", "Grant"};
    private JComboBox campus = new JComboBox(campuses);
    String[] majors = {null, "Computer Science", "Networking", "CIS",
        "Web Development", "Undecided"};
    private JComboBox major = new JComboBox(majors);
    private JTextArea csttaken = new JTextArea();
    private JTextArea cstprogress = new JTextArea();
    private JTextArea cstToBe = new JTextArea();
    private JTextArea comments = new JTextArea();
    String PATH;
    //JFrame frame = new JFrame();
    JDialog panel = new JDialog(this, JDialog.ModalityType.APPLICATION_MODAL);
    
    public UpdateStudent(String PATH, String StudentID) throws IOException {

        this.PATH = PATH;
        StudentIO tmpStudent = new StudentIO(PATH + "/" + StudentID + ".txt");

        panel.setSize(700, 570);
        panel.setLocation(500, 200);
        panel.setTitle("Updating Student Record");

        //Creates layout
        GridLayout layout = new GridLayout(0,2);    
        
        panel.setLayout(layout);
        
         panel.add(new JLabel("Personal Information"));
        panel.add(new JSeparator(SwingConstants.HORIZONTAL));
        
        panel.add(new JLabel("First Name"));
        firstName.setText(tmpStudent.getFirstName());
        panel.add(firstName);

        panel.add(new JLabel("MI"));
        midName.setText(tmpStudent.getMiddleName());
        panel.add(midName);

        panel.add(new JLabel("Last Name"));
        lastName.setText(tmpStudent.getLastName());
        panel.add(lastName);

        panel.add(new JLabel("ID #"));
        ID.setText(tmpStudent.getID());
        panel.add(ID);

        panel.add(new JLabel("Address"));
        address.setText(tmpStudent.getAddress());
        panel.add(address);

        panel.add(new JLabel("City"));
        city.setText(tmpStudent.getCity());
        panel.add(city);

        panel.add(new JLabel("State"));
        state.setText(tmpStudent.getState());
        panel.add(state);

        panel.add(new JLabel("Zip Code"));
        zip.setText(tmpStudent.getZipCode());
        panel.add(zip);

        panel.add(new JLabel("Home Telephone"));
        home.setText(tmpStudent.getHomeTel());
        panel.add(home);

        panel.add(new JLabel("Cell Phone"));
        cell.setText(tmpStudent.getCellTel());
        panel.add(cell);
        
        panel.add(new JLabel("Academic Information"));
        panel.add(new JSeparator(SwingConstants.HORIZONTAL));


        panel.add(new JLabel("GPA"));
        gpa.setText(tmpStudent.getGPA());
        panel.add(gpa);

        panel.add(new JLabel("Home Campus"));
        campus.setSelectedItem(tmpStudent.getCampus());
        panel.add(campus);

        panel.add(new JLabel("Major"));
        major.setSelectedItem(tmpStudent.getMajor());
        panel.add(major);

        panel.add(new JLabel("CST Courses Taken"));
        csttaken.setText(tmpStudent.getCSTTaken());
        panel.add(new JScrollPane(csttaken));

        panel.add(new JLabel("CST Courses in Progress"));
        cstprogress.setText(tmpStudent.getCSTProgress());
        panel.add(new JScrollPane(cstprogress));

        panel.add(new JLabel("CST Courses To Take"));
        cstToBe.setText(tmpStudent.getCSTToBe());
        panel.add(new JScrollPane(cstToBe));
        
        panel.add(new JLabel("Additional Notes"));
        comments.setText(tmpStudent.getCellTel());
        panel.add(comments);
        
        save = new JButton("Save");
        panel.add(save);
        save.addActionListener(new UpdateStudent.saveAction());

        cancel = new JButton("Cancel");
        panel.add(cancel);
        cancel.addActionListener(new UpdateStudent.cancelAction());

//        frame.add(panel);
        panel.setVisible(true);
    }

    public class saveAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
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
                
                if((ID.getText().length()< 8)&&(home.getText().length()<10) || (cell.getText().length() < 10))
                {
                JOptionPane.showMessageDialog(null,"ID needs to be 8 digits long, \n"
                        + "Home and Cell phone number both need to be 10 digits long", 
                        "Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    newStudent.save();
                    panel.dispose();
                }
                
            } catch (IOException ioex) {
               JOptionPane.showMessageDialog(null,"Check your submission", 
                        "Error",JOptionPane.ERROR_MESSAGE);
                ioex.printStackTrace();
            }
        }
    }

    public class cancelAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.dispose();
        }
    }
}
