import java.util.HashMap;
import java.util.Map;

abstract class Mitglied {
    private String name, vorname;
    private int mitgliedNummer;
    private float bonusPunkte;
    protected float bonusPunkteGutSchriftRatio;
    private Map<String, Artikel.ArtikelEintrag> artikelTable = new HashMap<>();

    public Mitglied(int id, String vorname, String name) {
        this.mitgliedNummer = id;
        this.vorname = vorname;
        this.name = name;
    }

    Map<String, Artikel.ArtikelEintrag> getArtikelTable() {
        return artikelTable;
    }

    // so ist es mit mehr Objektorientierung
    public void verkaufen(Artikel artikel, Mitglied kaufer, int menge) {
        float wert = artikelTable.get(artikel.getName()).getArtikel().getPreis() * menge;
        artikelTable.get(artikel.getName()).dec(menge);
        bonusPunkte += wert * bonusPunkteGutSchriftRatio;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public int getMitgliedNummer() {
        return mitgliedNummer;
    }

    public float getBonusPunkte() {
        return bonusPunkte;
    }

    public void addArtikel(Artikel artikel, int menge) {
        if (artikelTable.containsKey(artikel.getName()))
            artikelTable.get(artikel.getName()).setMenge(menge);
        else
            artikelTable.put(artikel.getName(), new Artikel.ArtikelEintrag(artikel).setMenge(menge));
    }

}
