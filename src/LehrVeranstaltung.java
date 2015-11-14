import java.util.Vector;

/**
 * Created by xor on 14.11.2015.
 */
public class LehrVeranstaltung {
    private final String name;
    private Lehrer lehrer;
    private Vector<Student> students = new Vector<>();

    public String getName() {
        return name;
    }

    LehrVeranstaltung(String name) {
        this.name = name;
    }

    public void setLehrer(Lehrer lehrer) {
        this.lehrer = lehrer;
    }

    public Vector<Student> liefereGemeledeteStudenten() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    public void removeStudent(Student student){
        students.remove(student);
    }
}
