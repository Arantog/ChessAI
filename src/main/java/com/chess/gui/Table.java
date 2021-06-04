package com.chess.gui;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table {
    private final JFrame gameFrame;
    private static Dimension WINDOW_DIMENSION = new Dimension(1080, 720);

    public Table() {
        this.gameFrame = new JFrame("Chess");
        final JMenuBar tableMenuBar = new JMenuBar();
        populateMenuBar(tableMenuBar);
        this.gameFrame.setJMenuBar(tableMenuBar);
        this.gameFrame.setVisible(true);
        this.gameFrame.setSize(WINDOW_DIMENSION);

    }

    private void populateMenuBar(final JMenuBar tableMenuBar) {
        tableMenuBar.add(createFileMenu());
    }

    private JMenu createFileMenu() {
        final JMenu fileMenu = new JMenu("File");

        final JMenuItem openPGN = new JMenuItem("Load from PGN file");
        openPGN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("opening PGN file");
            }
        });
        fileMenu.add(openPGN);
        return fileMenu;
    }

}
