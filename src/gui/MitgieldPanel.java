package gui;

import data.Mitglied;
import data.PremiumMitglied;
import data.StandardMitglied;

import javax.swing.*;
import java.awt.*;

/**
 * Created by xor on 1/11/16.
 */
public class MitgieldPanel extends JPanel {
    private JTextField txtName = new JTextField();
    private JTextField txtPrename = new JTextField();
    private JRadioButton rStandard = new JRadioButton("Standard");
    private JRadioButton rPremium = new JRadioButton("Premium");
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField txtId = new JTextField();


    public MitgieldPanel() {
        setLayout(new GridBagLayout());
        setBackground(Color.blue);
        Frame.addComponent(this, new JLabel("ID"), 1, 1, .1, .1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        Frame.addComponent(this, txtId, 2, 1, .1, .1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        Frame.addComponent(this, new JLabel("Vorname"), 1, 2, .1, .1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        Frame.addComponent(this, new JLabel("Name"), 1, 3, .1, .1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        Frame.addComponent(this, txtPrename, 2, 2, .1, .1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        Frame.addComponent(this, txtName, 2, 3, .1, .1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        Frame.addComponent(this, rStandard, 1, 4, .1, .1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        Frame.addComponent(this, rPremium, 2, 4, .1, .1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        buttonGroup.add(rPremium);
        buttonGroup.add(rStandard);
        buttonGroup.setSelected(rStandard.getModel(), true);
    }

    public void hideStuff(){
        removeAll();
        Frame.addComponent(this, new JLabel("ID"), 1, 1, .1, .1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        Frame.addComponent(this, txtId, 2, 1, .1, .1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
    }

    public String getName() {
        return txtName.getText();
    }

    public String getPrename() {
        return txtPrename.getText();
    }

    public void setName(String name) {
        txtName.setText(name);
    }

    public void setPrename(String name) {
        txtPrename.setText(name);
    }

    public boolean isPremium() {
        return rPremium.isSelected();
    }

    public Mitglied getMitglied() {
        Mitglied mitglied;
        if (isPremium())
            mitglied = new PremiumMitglied(Integer.parseInt(txtId.getText()), getPrename(), getName());
        else
            mitglied = new StandardMitglied(Integer.parseInt(txtId.getText()), getPrename(), getName());
        return mitglied;
    }

    public void setId(int id) {
        this.txtId.setText(Integer.toString(id));
    }
}
