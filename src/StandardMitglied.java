/**
 * Created by xor on 29.11.2015.
 */
class StandardMitglied extends Mitglied {
    public StandardMitglied(int id, String vorname, String name) {
        super(id, vorname, name);
        this.bonusPunkteGutSchriftRatio = 0.003f;
    }
}
