package battleship;

public enum CellState {
    FOG('~'),
    YOUR_SHIP('O'),
    HIT_SHIP('X'),
    MISS('M');

    public char symbol;

    CellState(char symbol) {
        this.symbol = symbol;
    }
}