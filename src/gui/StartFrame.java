package gui;

import data.Stamm;

import javax.swing.*;
import java.awt.*;

/**
 * Created by xor on 10.01.2016.
 */
public class StartFrame extends JFrame {
    private JButton btnInsert;
    private JButton btnRefresh;
    private JButton btnDelete;
    private Stamm stamm;

    public StartFrame(Stamm stamm) {
        this.stamm = stamm;
        setLayout(new FlowLayout());
        btnInsert = new JButton("einfügen");
        btnRefresh = new JButton("aktualisieren");
        btnDelete = new JButton("löschen");
        add(btnInsert);
        add(btnRefresh);
        add(btnDelete);
        btnRefresh.addActionListener(e -> {
            new RefreshFrame(stamm).setVisible(true);
        });
        btnInsert.addActionListener(e -> {
            new InsertFrame(stamm).setVisible(true);
        });
        btnDelete.addActionListener(e -> {
            new DeleteFrame(stamm).setVisible(true);
        });
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String... args) {
        new StartFrame(new Stamm("bla")).setVisible(true);
    }
}
