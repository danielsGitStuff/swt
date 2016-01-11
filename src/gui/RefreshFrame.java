package gui;

import data.Mitglied;
import data.Stamm;

import javax.swing.*;
import java.awt.*;

/**
 * Created by xor on 1/10/16.
 */
public class RefreshFrame extends Frame implements IReviewCallback{
    protected final MitgieldPanel pnlMitglied;

    public RefreshFrame(Stamm stamm) {
        super(stamm);
        pnlMitglied = new MitgieldPanel();
        addComponent(container, pnlMitglied, 1, 1, .1, .1, GridBagConstraints.NORTH, GridBagConstraints.BOTH);
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
        return "Aktualisieren";
    }

    @Override
    public void onReviewOk(Mitglied mitglied) {
        stamm.entferne(mitglied.getMitgliedNummer());
        stamm.hinzufuegen(mitglied);
        dispose();
    }

    @Override
    public void onReviewCancel() {
        setVisible(true);
    }
}
