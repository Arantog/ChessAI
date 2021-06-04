package com.chess.engine;

public abstract class Tile {

    public int coordinate;

    public Tile(int coordinate) {
        this.coordinate = coordinate;
    }

    public  abstract boolean isTileOccupied();
    public abstract Piece getPiece();

    public static final class EmptyTile extends Tile {
        public EmptyTile(int coordinate) {
            super(coordinate);
        }

        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }

        public static final class OcupiedTile extends Tile{
            public Piece piece;

            public OcupiedTile(int coordinate, Piece pieceOnTile) {
                super(coordinate);
                this.piece = pieceOnTile;
            }

            @Override
            public boolean isTileOccupied() {
                return true;
            }

            @Override
            public Piece getPiece() {
                return this.piece;
            }
        }
    }
}
