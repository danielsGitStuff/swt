package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xor on 21.11.2015.
 */
public class Stamm {
    private final String vereinsName;
    private List<Mitglied> mitglieder = new ArrayList<>();

    public Stamm(String name) {
        this.vereinsName = name;
    }

    public Stamm hinzufuegen(Mitglied... mitglieder) {
        Arrays.stream(mitglieder).forEach(this.mitglieder::add);
        return this;
    }

    public void showAll() {
        mitglieder.forEach(m -> System.out.println(m.getMitgliedNummer() + ", " + m.getVorname() + ", " + m.getName() + ", " + m.getBonusPunkte()));
    }

    public void entferne(int id) {
        mitglieder = mitglieder.stream().filter(m -> m.getMitgliedNummer() != id).collect(Collectors.toList());
    }
}
