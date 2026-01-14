package Model;
// bean for student class basially same as room one
public class StudentBean {
    private String studentID;
    private String studentName;
    private String studentNumber;

    public StudentBean() {}

    public StudentBean(String studentID, String studentName, String studentNumber) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentNumber = studentNumber;

    }
    //getter for id
    public String getStudentID() {
        return studentID;
    }
    //setter for id
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    //getter for name
    public String getStudentName() {
        return studentName;
    }
    //setter for name
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    // getter for phone number
    public String getStudentNumber() {
        return studentNumber;
    }
    // setter for phone number
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
}
