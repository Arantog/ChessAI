package com.chess.pieces;

import com.chess.engine.Board;
import com.chess.engine.Move;

import java.util.List;

public class Piece {
    protected final int piecePosition;
    protected final Alliance pieceAlliance;

    public Piece(int piecePosition, Alliance pieceAlliance) {
        this.piecePosition = piecePosition;
        this.pieceAlliance = pieceAlliance;
    }

    public List<Move> calculateLegalMoves(final Board board) {
        return null;
    }
}
