package gui;

import data.Mitglied;
import data.Stamm;
import data.StandardMitglied;

/**
 * Created by xor on 1/11/16.
 */
public class DeleteFrame extends RefreshFrame {
    public DeleteFrame(Stamm stamm) {
        super(stamm);
        pnlMitglied.hideStuff();
    }

    @Override
    void onOkClicked() {
        Mitglied mitglied = pnlMitglied.getMitglied();
        if (!stamm.exists(mitglied))
            mitglied = new StandardMitglied(0, "<nicht gefunden>", "<nicht gefunden>");
        ReviewFrame reviewFrame = new ReviewFrame(this, mitglied, stamm);
        reviewFrame.setVisible(true);
    }

    @Override
    public String getTitle() {
        return "Löschen";
    }

    @Override
    public void onReviewOk(Mitglied mitglied) {
        stamm.entferne(mitglied.getMitgliedNummer());
        dispose();
    }

}
