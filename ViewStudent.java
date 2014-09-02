
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class ViewStudent extends JFrame {

    private JButton exit;
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
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    public ViewStudent(String PATH, String StudentID) throws IOException {

        this.PATH = PATH;
        StudentIO tmpStudent = new StudentIO(PATH + "/" + StudentID + ".txt");
        System.out.println(tmpStudent + " " + PATH + "/" + StudentID + ".txt");

        frame.setSize(700, 570);
        frame.setLocation(500, 200);
        frame.setTitle("View Student Record");

        //Creates layout
        GridLayout layout = new GridLayout(0,2);
        panel.setLayout(layout);

       panel.add(new JLabel("Personal Information"));
       panel.add(new JSeparator(SwingConstants.HORIZONTAL));
        
        //.setText will set what is gotten from StudentIO.getFIELD
        panel.add(new JLabel("First Name"));
        firstName = new JTextField();
        panel.add(firstName);
        firstName.setText(tmpStudent.getFirstName());
        

        panel.add(new JLabel("MI"));
        midName = new JTextField();
        panel.add(midName);
        midName.setText(tmpStudent.getMiddleName());
        

        panel.add(new JLabel("Last Name"));
        lastName = new JTextField();
        panel.add(lastName);
        lastName.setText(tmpStudent.getLastName());
       

        panel.add(new JLabel("ID #"));
        ID  = new JTextField();
        panel.add(ID);
        ID.setText(tmpStudent.getID());
        

        panel.add(new JLabel("Address")); 
        address = new JTextField();
        panel.add(address);
        address.setText(tmpStudent.getAddress());
        

        panel.add(new JLabel("City"));
        city = new JTextField();
        panel.add(city);
        city.setText(tmpStudent.getCity());
        

        panel.add(new JLabel("State"));
        state  = new JTextField();
        panel.add(state);
        state.setText(tmpStudent.getState());
        

        panel.add(new JLabel("Zip Code"));
        zip  = new JTextField();
        zip.setText(tmpStudent.getZipCode());
        panel.add(zip);

        panel.add(new JLabel("Home Telephone"));
        home  = new JTextField();
        home.setText(tmpStudent.getHomeTel());
        panel.add(home);

        panel.add(new JLabel("Cell Phone"));
        cell = new JTextField();
        cell.setText(tmpStudent.getCellTel());
        panel.add(cell);

        panel.add(new JLabel("Academic Information"));
        panel.add(new JSeparator(SwingConstants.HORIZONTAL));

        panel.add(new JLabel("GPA"));
        gpa = new JTextField();
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
        panel.add(csttaken);

        panel.add(new JLabel("CST Courses in Progress"));
        cstprogress.setText(tmpStudent.getCSTProgress());
        panel.add(cstprogress);

        panel.add(new JLabel("CST Courses To Take"));
        cstToBe.setText(tmpStudent.getCSTToBe());
        panel.add(cstToBe);
        
        panel.add(new JLabel("Additional Notes"));
        comments.setText(tmpStudent.getCellTel());
        panel.add(comments);

        panel.add(new JSeparator(SwingConstants.HORIZONTAL));
                
        exit = new JButton("Exit");
        panel.add(exit);
        exit.addActionListener(new ViewStudent.ExitAction());

        frame.add(panel);
        frame.setVisible(true);
    }

    public class ExitAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    }
}
