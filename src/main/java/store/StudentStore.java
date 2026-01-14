package store;
import Model.StudentBean;
import java.util.ArrayList;
import java.util.List;

public class StudentStore {
    private static StudentStore instance;
    private List<StudentBean> students = new ArrayList<>();

    private StudentStore() {
        // creates the students and adds them to list
        students.add(new StudentBean("S1", "JennySmith", "0737561623"));
        students.add(new StudentBean("S2", "JamesRowling", "0737561623"));
        students.add(new StudentBean("S3", "SteveAoki", "0737561623"));
    }
    // createss new studentStore instance or returns existing instance
    public static StudentStore getInstance() {
        if (instance == null) {
            instance = new StudentStore();
        }
        return instance;
    }

    //getter for students list
    public List<StudentBean> getStudents() {
        return students;
    }
}
