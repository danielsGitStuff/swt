import java.util.Vector;

/**
 * Created by xor on 14.11.2015.
 */
public class Lehrer {
    private final String name;
    private final Vector<LehrVeranstaltung> veranstaltungen = new Vector<>();

    public Lehrer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void unterrichte(Vector<LehrVeranstaltung> v) {
        v.forEach(ver -> {
            ver.setLehrer(this);
            veranstaltungen.add(ver);
        });
    }

    public void showAssociantedStudents() {
        veranstaltungen.forEach(v -> {
            System.out.println("Veranstaltung: "+v.getName());
            v.liefereGemeledeteStudenten().forEach(System.out::println);
        });
    }

}
