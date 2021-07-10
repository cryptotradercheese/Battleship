package battleship;

import java.util.ArrayList;

public class Field {
    private ArrayList<CellState>[][] field;

    public Field() {
        initField();
    }

    public void initField() {
        field = new ArrayList[10][10];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = new ArrayList<>();
                field[i][j].add(CellState.FOG);
            }
        }
    }

    public ArrayList<CellState> getCell(Coordinate coordinate) {
        return field[coordinate.getRow()][coordinate.getColumn()];
    }

    @Override
    public String toString() {
        String fieldString = "  1 2 3 4 5 6 7 8 9 10";

        for (int i = 0; i < 10; i++) {
            fieldString += System.lineSeparator() + (char) ('A' + i);

            for (int j = 0; j < 10; j++) {
                ArrayList<CellState> currentCell = field[i][j];

                if (currentCell.contains(CellState.HIT_CELL)) {
                    fieldString += " " + CellState.HIT_CELL.symbol;
                } else if (currentCell.contains(CellState.MISS)) {
                    fieldString += " " + CellState.MISS.symbol;
                } else if (currentCell.contains(CellState.FOG)) {
                    fieldString += " " + CellState.FOG.symbol;
                }
            }
        }

        return fieldString;
    }
}
