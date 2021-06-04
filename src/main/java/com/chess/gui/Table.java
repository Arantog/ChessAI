package com.chess.gui;

import javax.swing.*;
import java.awt.*;

public class Table {
    private final JFrame gameFrame;
    private static Dimension WINDOW_DIMENSION = new Dimension(1080,720);

    public Table() {
        this.gameFrame = new JFrame("Chess");
        this.gameFrame.setVisible(true);
        this.gameFrame.setSize(WINDOW_DIMENSION);
    }
}
