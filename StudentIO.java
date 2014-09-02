
import java.io.*;
import javax.swing.JOptionPane;
import org.ini4j.*;

public class StudentIO {

    private String fileName;
    private String firstName;
    private String midName;
    private String lastName;
    private String ID;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String home;
    private String cell;
    private String gpa;
    private String campus;
    private String major;
    private String csttaken;
    private String cstprogress;
    private String cstToBe;
    private String comments;
    
    private File iniFile;
    private Wini ini;

    public StudentIO(String pubfileName) throws IOException {
        fileName = pubfileName;
        // ini = new Ini();

        iniFile = new File(fileName);

        if (iniFile.exists()) {
            //if the folder exists, use it.
            ini = new Wini(iniFile);
            this.readIni();
            System.out.println("File exist " + pubfileName);
        } else {
            System.out.println("File doesn't exist " + pubfileName);
            //create a new folder if it doesn't exist
            iniFile.createNewFile();
            ini = new Wini(iniFile);

            firstName = null;
            midName = null;
            lastName = null;
            ID = null;
            address = null;
            city = null;
            state = null;
            zip = null;
            home = null;
            cell = null;
            gpa = null;
            campus = null;
            major = null;
            csttaken = null;
            cstprogress = null;
            cstToBe = null;
            comments = null;
        }
    }

    private void readIni(){
        try {
            ini.load(new FileReader(fileName));
            System.out.println(ini);
        } catch (IOException ioex) {
            System.out.println("404");
            ioex.printStackTrace();
            return;
        }
        // getting info from labels
         Wini.Section student = ini.get("student");
        firstName = student.get("First Name");
        System.out.println("hi from " + firstName);
        midName = student.get("Middle Inital");
        lastName = student.get("Last Name");
        ID = student.get("ID #");
        address = student.get("Address");
        city = student.get("City");
        state = student.get("State");
        zip = student.get("Zip Code");
        home = student.get("Home Telephone");
        cell = student.get("Cell Phone");
        gpa = student.get("GPA");
        campus = student.get("Home Campus");
        major = student.get("Major");
        csttaken = student.get("CST Courses Taken");
        cstprogress = student.get("CST Courses in Progress");
        cstToBe = student.get("CST Courses To Take");
        comments = student.get("Additional Notes");
        
      

    }
    // setting and getting information that in inputed... then storing it 
    //in the correct label that was stated above
    // ie) in section *student* 

    public void setFirstName(String fname) {
        this.firstName = fname;
        ini.put("student", "First Name", this.firstName);
    }

    public String getFirstName() {
        System.out.println("getFname meh" + firstName);
        return firstName;
    }

    public void setMiddleName(String mname) {
        this.midName = mname;
        ini.put("student", "Middle Inital", this.midName);
    }

    public String getMiddleName() {
        return midName;
    }

    public void setLastName(String lname) {
        this.lastName = lname;
        ini.put("student", "Last Name", this.lastName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setID(String id) {
        ID = id;
        ini.put("student", "ID #", ID);
    }

    public String getID() {
        return ID;
    }

    public void setAddress(String address) {
        this.address = address;
        ini.put("student", "Address", this.address);
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        this.city = city;
        ini.put("student", "City", this.city);
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        this.state = state;
        ini.put("student", "State", this.state);
    }

    public String getState() {
        return state;
    }

    public void setZipCode(String zip) {
        this.zip = zip;
        ini.put("student", "Zip Code", this.zip);
    }

    public String getZipCode() {
        return zip;
    }

    public void setHomeTel(String home) {
        this.home = home;
        ini.put("student", "Home Telephone", this.home);
    }

    public String getHomeTel() {
        return home;
    }

    public void setCellTel(String cell) {
        this.cell = cell;
        ini.put("student", "Cell Phone", this.cell);
    }

    public String getCellTel() {
        return cell;
    }

    public void setGPA(String gpa) {
        this.gpa = gpa;
        ini.put("student", "GPA", this.gpa);
    }

    public String getGPA() {
        return gpa;
    }

        public void setCampus(String campus) {
        this.campus = campus;
        ini.put("student", "Home Campus", this.campus);
    }

    public String getCampus() {
        return campus;
    }
        public void setMajor(String major) {
        this.major = major;
        ini.put("student", "Major", this.major);
    }

    public String getMajor() {
        return major;
    }
    public void setCSTTaken(String cst) {
        this.csttaken = cst;
        ini.put("student", "CST Courses Taken", this.csttaken);
    }

    public String getCSTTaken() {
        return csttaken;
    }

    public void setCSTProgress(String cst) {
        this.cstprogress = cst;
        ini.put("student", "CST Courses in Progress", this.cstprogress);
    }

    public String getCSTProgress() {
        return cstprogress;
    }

    public void setCSTToBe(String cst) {
        this.cstToBe = cst;
        ini.put("student", "CST Courses To Take", this.cstToBe);
    }

    public String getCSTToBe() {
        return cstToBe;
    }

    public void setNotes(String notes) {
        this.comments = notes;
        ini.put("student", "Additional Notes", comments);
    }

    public String getNotes() {
        return comments;
    }

    public void save() throws IOException {
        ini.store();
    }

}
