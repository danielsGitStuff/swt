/**
 * Created by xor on 29.11.2015.
 */
class PremiumMitglied extends Mitglied {
    public PremiumMitglied(int id, String vorname, String name) {
        super(id, vorname, name);
        this.bonusPunkteGutSchriftRatio = 0.007f;
    }
}
