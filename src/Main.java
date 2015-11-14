import java.util.Vector;

/**
 * Created by xor on 14.11.2015.
 */
public class Main {

    public static void main(String... args) {
        Lehrer john = new Lehrer("John");
        Student susanne = new Student("Susanne", "1");
        Student peter = new Student("Peter", "2");
        Student paul = new Student("Paul", "3");
        LehrVeranstaltung swt = new LehrVeranstaltung("SWT");
        LehrVeranstaltung datenbanken = new LehrVeranstaltung("Datenbanken");
        Vector<LehrVeranstaltung> veranstaltungen = new Vector<LehrVeranstaltung>() {{
            add(swt);
            add(datenbanken);
        }};
        Vector<Student> students = new Vector<Student>() {{
            add(susanne);
            add(peter);
            add(paul);
        }};
        john.unterrichte(veranstaltungen);
        students.forEach(s -> s.besuchen(veranstaltungen));
        peter.absagen(swt);
        john.showAssociantedStudents();
    }

}
