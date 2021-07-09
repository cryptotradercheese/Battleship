package battleship;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        game.printField();
        System.out.println();

        game.placeShip(ShipType.AIRCRAFT_CARRIER);
        game.placeShip(ShipType.BATTLESHIP);
        game.placeShip(ShipType.SUBMARINE);
        game.placeShip(ShipType.CRUISER);
        game.placeShip(ShipType.DESTROYER);

        System.out.println();
        System.out.println("The game starts!");
        System.out.println();
        game.showShellsOnly();
        System.out.println();
        System.out.println("Take a shot!");
        System.out.println();

        while (!game.isFinished()) {
            game.shoot();
            System.out.println();
        }

        game.showShellsOnly();
        System.out.println("You sank the last ship. You won. Congratulations!");
    }
}