package gui;

import data.Mitglied;
import data.PremiumMitglied;
import data.Stamm;
import data.StandardMitglied;

import java.awt.*;

/**
 * Created by xor on 1/11/16.
 */
public class InsertFrame extends Frame implements IReviewCallback {
    private MitgieldPanel pnlMitglied;

    public InsertFrame(Stamm stamm) {
        super(stamm);
        pnlMitglied = new MitgieldPanel();
        addComponent(container, pnlMitglied, 1, 1, .1, .1, GridBagConstraints.NORTH, GridBagConstraints.BOTH);
        pnlMitglied.setId(Mitglied.generateId());
    }

    @Override
    void onOkClicked() {
        Mitglied mitglied = pnlMitglied.getMitglied();
        ReviewFrame reviewFrame = new ReviewFrame(this, mitglied, stamm);
        reviewFrame.setVisible(true);
    }

    @Override
    void onCancelClicked() {

    }

    @Override
    public String getTitle() {
        return "Einfügen";
    }

    @Override
    public void onReviewOk(Mitglied mitglied) {
        stamm.hinzufuegen(mitglied);
        setVisible(false);
        dispose();
    }

    @Override
    public void onReviewCancel() {
        setVisible(true);
    }
}
