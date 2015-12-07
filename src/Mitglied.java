import e.ThouShaltNotDeceptException;
import e.ThouShaltNotGoShortException;

import java.util.*;

abstract class Mitglied extends Observable implements Observer {
    private String name, vorname;
    private int mitgliedNummer;
    private float bonusPunkte;
    protected float bonusPunkteGutSchriftRatio;
    private Mitglied observed;

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
    public void verkaufen(Artikel artikel, Mitglied kaufer, int menge) throws ThouShaltNotGoShortException, ThouShaltNotDeceptException {
        if (!artikelTable.containsKey(artikel.getName()))
            throw new ThouShaltNotDeceptException();
        float wert = artikelTable.get(artikel.getName()).getArtikel().getPreis() * menge;
        Artikel.ArtikelEintrag eintrag = artikelTable.get(artikel.getName());
        if (eintrag.getMenge()>=menge) {
            eintrag.dec(menge);
            bonusPunkte += wert * bonusPunkteGutSchriftRatio;
            setChanged();
            notifyObservers();
        }else throw new ThouShaltNotGoShortException();
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
        if (artikelTable.containsKey(artikel.getName())) {
            Artikel.ArtikelEintrag olde = artikelTable.get(artikel.getName());
            olde.setMenge(olde.getMenge() + menge);
        } else
            artikelTable.put(artikel.getName(), new Artikel.ArtikelEintrag(artikel).setMenge(menge));
        setChanged();
        notifyObservers();
    }

    @Override
    public void update(Observable o, Object arg) {
        observed = (Mitglied) o;
    }


    public Mitglied getObserved() {
        return observed;
    }
}
