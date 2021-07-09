package battleship;

public class Ship {
    private Field field;

    public Ship(Field field) {
        this.field = field;
    }

    public void placeAbstractShip(Coordinate first, Coordinate second) {
        if (first.getRow() == second.getRow()) {
            for (
                    int i = Math.min(first.getColumn(), second.getColumn());
                    i <= Math.max(first.getColumn(), second.getColumn());
                    i++
            ) {
                field.getCell(new Coordinate(first.getRow(), i)).add(CellState.YOUR_SHIP);
            }
        } else if (first.getColumn() == second.getColumn()) {
            for (
                    int i = Math.min(first.getRow(), second.getRow());
                    i <= Math.max(first.getRow(), second.getRow());
                    i++
            ) {
                field.getCell(new Coordinate(i, first.getColumn())).add(CellState.YOUR_SHIP);
            }
        } else {
            throw new IllegalArgumentException("Illegal placement");
        }
    }

    public int getLength(Coordinate first, Coordinate second) {
        if (first.getRow() == second.getRow()) {
            return Math.abs(first.getColumn() - second.getColumn()) + 1;
        } else if (first.getColumn() == second.getColumn()) {
            return Math.abs(first.getRow() - second.getRow()) + 1;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isLegalForm(Coordinate first, Coordinate second) {
        if (first.getRow() != second.getRow() && first.getColumn() != second.getColumn()) {
            return false;
        }

        return true;
    }

    public boolean isLegalRoom(Coordinate first, Coordinate second) {
        for (int i = Math.min(first.getRow(), second.getRow()) - 1; i <= Math.max(first.getRow(), second.getRow()) + 1; i++) {
            for (int j = Math.min(first.getColumn(), second.getColumn()) - 1; j <= Math.max(first.getColumn(), second.getColumn()) + 1; j++) {
                if (i >= 0 && i <+ 9 && j >= 0 && j <= 9) {
                    if (field.getCell(new Coordinate(i, j)).contains(CellState.YOUR_SHIP)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean shoot(Coordinate coordinate) {
        if (field.getCell(coordinate).contains(CellState.YOUR_SHIP)) {
            field.getCell(coordinate).add(CellState.HIT_CELL);
            return true;
        } else {
            field.getCell(coordinate).add(CellState.MISS);
            return false;
        }
    }
}
