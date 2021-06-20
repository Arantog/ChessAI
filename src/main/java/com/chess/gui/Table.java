package com.chess.gui;

import com.chess.engine.BoardUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static com.chess.engine.BoardUtils.NUM_TILES;

public class Table {
    private final JFrame gameFrame;
    private final BoardPanel boardPanel;
    private static Dimension WINDOW_DIMENSION = new Dimension(720, 720);
    private static Dimension BOARD_DIMENSION = new Dimension(400, 350);
    private static Dimension TILE_DIMENSION = new Dimension(10, 10);
    private Color lightTileColor = Color.decode("#FFFACD");
    private Color darkTileColor = Color.decode("#593E1A");

    public Table() {
        this.gameFrame = new JFrame("Chess");
        final JMenuBar tableMenuBar = createTableMenuBar();
        this.gameFrame.setLayout(new BorderLayout());
        this.gameFrame.setJMenuBar(tableMenuBar);
        this.gameFrame.setVisible(true);
        this.gameFrame.setSize(WINDOW_DIMENSION);
        this.boardPanel = new BoardPanel();
        this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);

    }

    private JMenuBar createTableMenuBar() {
        final JMenuBar tableMenuBar = new JMenuBar();
        tableMenuBar.add(createFileMenu());
        return tableMenuBar;
    }

    private JMenu createFileMenu() {
        final JMenu fileMenu = new JMenu("File");
        final JMenuItem openPGN = new JMenuItem("Load from PGN file");
        openPGN.addActionListener(e -> System.out.println("opening PGN file"));
        fileMenu.add(openPGN);
        return fileMenu;
    }

    private class BoardPanel extends JPanel {
        final List<TilePanel> boardTiles;

        BoardPanel() {
            super(new GridLayout(8, 8));
            this.boardTiles = new ArrayList<>();
            for (int i = 0; i < NUM_TILES; i++) {
                final TilePanel tilePanel = new TilePanel(this, i);
                this.boardTiles.add(tilePanel);
                add(tilePanel);
            }
            setPreferredSize(BOARD_DIMENSION);
            validate();

        }


        private class TilePanel extends JPanel {
            private final int tileId;
            TilePanel(final BoardPanel boardPanel, final int tileId){
                super(new GridBagLayout());
                this.tileId = tileId;
                setPreferredSize(TILE_DIMENSION);
                assignTileColor();
                validate();
            }

            private void assignTileColor() {
                if (BoardUtils.FIRST_ROW.get(this.tileId) ||
                        BoardUtils.THIRD_ROW.get(this.tileId) ||
                        BoardUtils.FIFTH_ROW.get(this.tileId) ||
                        BoardUtils.SEVENTH_ROW.get(this.tileId)) {
                    setBackground(this.tileId % 2 == 0 ? lightTileColor : darkTileColor);
                } else if(BoardUtils.SECOND_ROW.get(this.tileId) ||
                        BoardUtils.FOURTH_ROW.get(this.tileId) ||
                        BoardUtils.SIXTH_ROW.get(this.tileId)  ||
                        BoardUtils.EIGHTH_ROW.get(this.tileId)) {
                    setBackground(this.tileId % 2 != 0 ? lightTileColor : darkTileColor);
                }


        }

    }
}
}
