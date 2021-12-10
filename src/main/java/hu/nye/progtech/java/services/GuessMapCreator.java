package hu.nye.progtech.java.services;

import hu.nye.progtech.java.models.Map;

public class GuessMapCreator {

    private final int numberOfRows;
    private final int numberOfColumns;

    public GuessMapCreator(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    public Map createMap() {
        char[][] map = new char[numberOfRows][numberOfColumns];
        return new Map(numberOfRows, numberOfColumns, map);
    }
}
