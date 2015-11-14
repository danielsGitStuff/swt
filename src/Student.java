import java.util.Vector;

/**
 * Created by xor on 14.11.2015.
 */
public class Student {
    private final String name;
    private final String martrikelNummer;

    public String getMartrikelNummer() {
        return martrikelNummer;
    }

    public String getName() {
        return name;
    }

    Student(String name, String martrikelNummer) {
        this.name = name;
        this.martrikelNummer = martrikelNummer;
    }

    public void besuchen(Vector<LehrVeranstaltung> v) {
        v.forEach(ver -> ver.addStudent(this));
    }

    public void absagen(LehrVeranstaltung veranstaltung) {
        veranstaltung.removeStudent(this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "." + name + "." + martrikelNummer;
    }
}
