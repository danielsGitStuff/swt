import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by xor on 29.11.2015.
 */
public class testVereinTest {
    private Mitglied peter, paul, susanne, rolf, susi;
    private Stamm stamm;
    private Artikel schrank, computer;

    @Before
    public void setUp() throws Exception {
        peter = new StandardMitglied(1, "Peter", "Schmidt");
        paul = new StandardMitglied(2, "Paul", "Jahnke");
        susanne = new PremiumMitglied(3, "Susanne", "Fischer");
        rolf = new PremiumMitglied(4, "Rolf", "Helm");
        susi = new PremiumMitglied(5, "Susi", "Ritter");
        Mitglied[] mitglieder = new Mitglied[]{peter, paul, susanne, rolf, susi};
        stamm = new Stamm("test").hinzufuegen(mitglieder);
        schrank = new Artikel("Schrank", 3000);
        computer = new Artikel("Computer", 5000);
        peter.addArtikel(schrank, 5);
        susi.addArtikel(computer, 10);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void test1() {
        susi.verkaufen(computer, paul, 1);
        assertEquals(susi.getBonusPunkte(), 35d, 0.0000001d);
        assertEquals(susi.getArtikelTable().get(computer.getName()).getMenge(), 9);
    }

    @Test
    public void test2() {
        peter.verkaufen(schrank, paul, 1);
        assertEquals(peter.getBonusPunkte(), 9d, 0.0000001d);
        assertEquals(peter.getArtikelTable().get(schrank.getName()).getMenge(), 4);
    }

    @Test
    public void test3() {
        peter.verkaufen(schrank, paul, 666);
        assertEquals(peter.getBonusPunkte(), 5994d, 0.0000001d);
        // peter macht leerverkäufe
        assertEquals(peter.getArtikelTable().get(schrank.getName()).getMenge(), -661);
    }

    @Test(expected = NullPointerException.class)
    public void test4() {
        peter.verkaufen(computer, paul, 666);
    }
}