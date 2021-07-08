package battleship;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Field field = new Field();
        Game game = new Game(field);

        game.placeShip(ShipType.AIRCRAFT_CARRIER);
        game.placeShip(ShipType.BATTLESHIP);
        game.placeShip(ShipType.SUBMARINE);
        game.placeShip(ShipType.CRUISER);
        game.placeShip(ShipType.DESTROYER);

        System.out.println();
        System.out.println("The game starts!");
        System.out.println();
        System.out.println(field);
        System.out.println();
        game.shoot();
    }
}