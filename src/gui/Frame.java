package gui;

import data.Stamm;

import javax.swing.*;
import java.awt.*;

/**
 * Created by xor on 1/10/16.
 */
public abstract class Frame extends JFrame {

    protected JButton btnOk = new JButton("Ok");
    protected JButton btnCancel = new JButton("Cancel");
    protected JButton btnHelp = new JButton("Help");
    protected JPanel container = new JPanel();
    protected Stamm stamm;

    protected void addComponent(Component component, int x, int y, double wx, double wy, int anchor, int fill) {
        addComponent(this, component, x, y, wx, wy, anchor, fill);
    }

    public static void addComponent(Container container, Component component, int x, int y, double wx, double wy, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = anchor;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = fill;
        gbc.weightx = wx;
        gbc.weighty = wy;
        container.add(component, gbc);
    }

    public Frame(Stamm stamm) {
        this.stamm = stamm;
        setTitle(getTitle());
        container.setBackground(Color.RED);
        container.setLayout(new GridBagLayout());
        setLayout(new GridBagLayout());
        addComponent(container, 1, 1, .5, .5, GridBagConstraints.NORTH, GridBagConstraints.BOTH);
        JPanel bottom = new JPanel();
        bottom.setBackground(Color.green);
        addComponent(bottom, 1, 2, .0, .0, GridBagConstraints.SOUTH, GridBagConstraints.BOTH);
        bottom.setLayout(new FlowLayout());
        bottom.add(btnOk);
        bottom.add(btnHelp);
        bottom.add(btnCancel);
        setPreferredSize(new Dimension(400, 400));
        pack();
        btnCancel.addActionListener(e -> {
            onCancelClicked();
            setVisible(false);
            dispose();
        });
        btnOk.addActionListener(e -> {
            onOkClicked();
            setVisible(false);
        });
    }

    abstract void onOkClicked();

    abstract void onCancelClicked();

    public abstract String getTitle();

}
