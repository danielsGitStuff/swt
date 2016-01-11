package gui;

import data.Mitglied;
import data.PremiumMitglied;
import data.Stamm;

import javax.swing.*;
import java.awt.*;

/**
 * Created by xor on 1/11/16.
 */
public class ReviewFrame extends Frame {
    private final IReviewCallback callback;
    private final Mitglied mitglied;
    private JTextPane txt = new JTextPane();

    public ReviewFrame(IReviewCallback callback, Mitglied mitglied, Stamm stamm) {
        super(stamm);
        this.callback = callback;
        this.mitglied = mitglied;
        String text = "Vorname: " + mitglied.getVorname() + "\n" +
                "Name: " + mitglied.getName() + "\n" +
                "Status: " + (mitglied instanceof PremiumMitglied ? "Premium" : "Standard");
        txt.setText(text);
        addComponent(container, txt, 1, 1, .1, .1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
    }

    @Override
    void onOkClicked() {
        callback.onReviewOk(mitglied);
        stamm.showAll();
    }

    @Override
    void onCancelClicked() {
        setVisible(false);
        dispose();
        callback.onReviewCancel();
    }

    @Override
    public String getTitle() {
        return "Kontrolle";
    }
}
