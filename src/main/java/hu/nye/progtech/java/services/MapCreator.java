package hu.nye.progtech.java.services;

import hu.nye.progtech.java.models.Map;

import java.util.List;

public class MapCreator {

    private int numberOfColumns;
    private int numberOfRows;

    public MapCreator(int numberOfColumns, int numberOfRows) {
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
    }

    public Map createMap() {
        char[][] map = getMap();
        return new Map(numberOfRows, numberOfColumns, map);
    }

    private char[][] getMap() {
        char[][] map = new char[10][10];
        for(int shipSize = 5;shipSize > 0; shipSize--){
            createComputerShip(map, shipSize);
        }


        return map;
    }

    private void createPlayerShip(char[][] map) {
        List<char[][]>  playerShipList = null;
        char shipChar = '\u2587';
        for(int i = 0; i < 5; i++) {

            int shipX = getRandomNumber();
            int shipY = getRandomNumber();
            char[][] shipCoords = new char[shipX][shipY];
            if(!playerShipList.contains(shipCoords))
            {
                playerShipList.add(shipCoords);
                map[shipX][shipY] = shipChar;
            }

        }
    }

    private void createComputerShip(char[][] map,int shipSize) {
        int max;
        int shipPlaceX;
        int shipPlaceY;
        char shipChar = '\u2587';
        boolean shipOverlap = true;
        while(shipOverlap) {
            if (isShipOnHorizont()) {
                max = numberOfColumns - (shipSize + 1);
                shipPlaceX = shipPlace(max);
                max = numberOfRows - 1;
                shipPlaceY = shipPlace(max);
                for (int j = 0; j < shipSize; j++) {
                    if (map[shipPlaceY][shipPlaceX + j] == shipChar) {
                        shipOverlap = true;
                        break;
                    }
                    map[shipPlaceY][shipPlaceX + j] = shipChar;
                    shipOverlap = false;
                }
            } else {
                max = numberOfRows - (shipSize + 1);
                shipPlaceY = shipPlace(max);
                max = numberOfColumns - 1;
                shipPlaceX = shipPlace(max);
                for (int j = 0; j < shipSize; j++) {
                    if (map[shipPlaceY + j][shipPlaceX] == shipChar) {
                        shipOverlap = true;
                        break;
                    }
                    map[shipPlaceY + j][shipPlaceX] = shipChar;
                    shipOverlap = false;
                }
            }
        }
    }

    public int getRandomNumber() {
        int min = 0;
        int max = 9;
        return (int) ((Math.random() * (max - min)) + min);
    }

    private boolean isShipOnHorizont() {
        return Math.random() > 0.5;
    }

    private int shipPlace(int max) {
        return (int)(Math.random()*max);
    }
}
