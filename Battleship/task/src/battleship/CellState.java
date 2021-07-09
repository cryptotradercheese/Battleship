package battleship;

public enum CellState {
    FOG('~'),
    YOUR_SHIP('O'),
    HIT_CELL('X'),
    MISS('M');

    public final char symbol;

    CellState(char symbol) {
        this.symbol = symbol;
    }
}