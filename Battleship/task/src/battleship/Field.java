package battleship;

public class Field {
    private CellState[][] field;

    public Field() {
        initField();
    }

    public void initField() {
        field = new CellState[10][10];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = CellState.FOG;
            }
        }
    }

    @Override
    public String toString() {
        String fieldString = "  1 2 3 4 5 6 7 8 9 10";

        for (int i = 0; i < field.length; i++) {
            fieldString += System.lineSeparator() + (char) ('A' + i);
            for (int j = 0; j < field[0].length; j++) {
                fieldString += " " + field[i][j].symbol;
            }
        }

        return fieldString;
    }

    public void setCell(int row, int column, CellState content) {
        field[row][column] = content;
    }

    public CellState getCell(int row, int column) {
        return field[row][column];
    }
}
