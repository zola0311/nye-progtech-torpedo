package hu.nye.progtech.java.ui;

import hu.nye.progtech.java.models.Map;

public class MapPrinter {

    private Map baseMap;
    private Map guessMap;

    public MapPrinter(Map baseMap, Map guessMap) {
        this.baseMap = baseMap;
        this.guessMap = guessMap;
    }

    public void printMap() {
        System.out.println(headerString());
        System.out.println(mapToString());
    }

    private String headerString() {
        StringBuilder str = new StringBuilder();

        for(int k = 0; k < 2; k++) {
            str.append("\t");
            for (int i = 65; i < baseMap.getNumberOfColumns() + 65; i++) {
                str.append((char)i);
                str.append("  ");
            }
            str.append("\t");
        }
        return str.toString();
    }

    private String mapToString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < baseMap.getMap().length; i++) {
            if(i > 0) {
                str.append("\n");
            }
            str.append(i + 1);
            str.append("\t");
            for (int j = 0; j < baseMap.getMap().length; j++) {
                str.append(baseMap.getMap()[i][j]);
                str.append("  ");
            }
            str.append("\t");
            str.append(i+1);
            str.append("\t");
            for (int j = 0; j < guessMap.getMap().length; j++) {
                str.append(guessMap.getMap()[i][j]);
                str.append("  ");
            }
        }
        return str.toString();
    }

}
