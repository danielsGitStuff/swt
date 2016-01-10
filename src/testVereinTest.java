import data.*;
import e.ThouShaltNotDeceptException;
import e.ThouShaltNotGoShortException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    public void test1() throws ThouShaltNotGoShortException, ThouShaltNotDeceptException {
        susi.verkaufen(computer, paul, 1);
        assertEquals(susi.getBonusPunkte(), 35d, 0.0000001d);
        assertEquals(susi.getArtikelTable().get(computer.getName()).getMenge(), 9);
    }

    @Test
    public void test2() throws ThouShaltNotGoShortException, ThouShaltNotDeceptException {
        peter.verkaufen(schrank, paul, 1);
        assertEquals(peter.getBonusPunkte(), 9d, 0.0000001d);
        assertEquals(peter.getArtikelTable().get(schrank.getName()).getMenge(), 4);
    }

    @Test(expected = ThouShaltNotGoShortException.class)
    public void testGoShort() throws ThouShaltNotGoShortException, ThouShaltNotDeceptException {
        peter.verkaufen(schrank, paul, 666);
    }

    @Test(expected = ThouShaltNotDeceptException.class)
    public void testDeception() throws ThouShaltNotGoShortException, ThouShaltNotDeceptException {
        peter.verkaufen(computer, paul, 666);
    }

    @Test
    public void testObserver() throws ThouShaltNotGoShortException, ThouShaltNotDeceptException {
        peter.addObserver(paul);
        peter.verkaufen(schrank, susanne,1);
        Mitglied observed = paul.getObserved();
        assertEquals(observed.getArtikelTable().get(schrank.getName()).getMenge(), 4);
    }

    @Test
    public void testObserver2() {
        peter.addObserver(paul);
        peter.addArtikel(computer,200);
        Mitglied observed = paul.getObserved();
        assertEquals(observed.getArtikelTable().get(computer.getName()).getMenge(), 200);
    }
}