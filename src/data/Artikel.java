package data;

/**
 * Created by xor on 29.11.2015.
 */
public class Artikel {
    private float preis;
    private final String name;

    public Artikel(String name,float preis ) {
        this.preis = preis;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public float getPreis() {
        return preis;
    }

    public static class ArtikelEintrag {
        private final Artikel artikel;
        private int menge = 0;

        public ArtikelEintrag(Artikel artikel) {
            this.artikel = artikel;
        }

        public ArtikelEintrag setMenge(int menge) {
            this.menge = menge;
            return this;
        }

        public void dec(int menge) {
            this.menge -= menge;
        }

        public Artikel getArtikel() {
            return artikel;
        }

        public int getMenge() {
            return menge;
        }
    }
}
