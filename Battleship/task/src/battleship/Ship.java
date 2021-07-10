package battleship;

public abstract class Ship {
    private Field field;
    private Coordinate start;
    private Coordinate end;

    public Ship(Field field, Coordinate start, Coordinate end) {
        this.field = field;

        if (
                start.getRow() != end.getRow() && start.getColumn() != end.getColumn() ||
                start.getRow() == end.getRow() && start.getColumn() == end.getColumn()
        ) {
            throw new IllegalArgumentException();
        }

        if (start.getRow() < end.getRow() || start.getColumn() < end.getColumn()) {
            this.start = start;
            this.end = end;
        } else {
            this.start = end;
            this.end = start;
        }
    }

    public void place() {
        if (start.getRow() == end.getRow()) {
            for (int i = start.getColumn(); i <= end.getColumn(); i++) {
                field.getCell(new Coordinate(start.getRow(), i)).add(CellState.YOUR_SHIP);
            }
        } else if (start.getColumn() == end.getColumn()) {
            for (int i = start.getRow(); i <= end.getRow(); i++) {
                field.getCell(new Coordinate(i, start.getColumn())).add(CellState.YOUR_SHIP);
            }
        } else {
            throw new IllegalArgumentException("Illegal placement");
        }
    }

    public boolean isSunk() {
        for (int i = start.getRow(); i <= end.getRow(); i++) {
            for (int j = start.getColumn(); j <= end.getColumn(); j++) {
                if (!field.getCell(new Coordinate(i, j)).contains(CellState.HIT_CELL)) {
                    return false;
                }
            }
        }

        return true;
    }
}
