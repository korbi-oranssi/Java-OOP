package paktalin.com;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int SEA_SIZE = 10;
    private static int[][] sea = new int[SEA_SIZE][SEA_SIZE];
    private static Scanner input = new Scanner(System.in);
    private static Random random = new Random();
    private static int playerShips = 5, computerShips = 5;
    private static boolean gameOver;

    public static void main(String[] args)  {
        //header
        System.out.print("**** Welcome to the Battle Ships game ****");
        System.out.print("\n\nRight now, the sea is empty.");

        drawMap();
        playerShips();
        computerShips();
        drawMap();
        while (!gameOver){
            playerGuess();
            drawMap();
            if (gameOver) break;
            computerGuess();
            drawMap();
        }
    }

    private static void computerGuess() {
        System.out.print("\n\nCOMPUTER'S TURN");
        int x, y;
        do {
            x = random.nextInt(10);
            y = random.nextInt(10);
        } while (sea[x][y] == 2 || sea[x][y] == 3 || sea[x][y] == 4);

        if(sea[x][y] == 0){
            System.out.print("\nComputer missed.");
            sea[x][y] = 4;
        } else {
            System.out.print("\nComputer sank your ship.");
            playerShips --;
            sea[x][y] = 3;
            computerGuess();
        }
    }

    private static void playerGuess() {
        System.out.print("\n\nYOUR TURN");
        int x, y;
        System.out.print("\nGuess the X coordinate: ");
        x = input.nextInt();
        System.out.print("Guess the Y coordinate: ");
        y = input.nextInt();

        switch (sea[x][y]){
            case 0:
                System.out.print("\nOops! You missed!");
                sea[x][y] = 4;
                break;
            case 1:
                System.out.print("\nIt's your ship's position! Try again!");
                playerGuess();
                break;
            case 2:
                System.out.print("\nGreat! You sank the ship! Your turn again.");
                computerShips --;
                sea[x][y] = 3;
                playerGuess();
            break;
            case 3:
                System.out.print("\nIt's already sunk, chill! Try again.");
                playerGuess();
                break;
            case 4:
                System.out.print("\nIt's empty. Try again.");
                playerGuess();
                break;
        }
    }

    private static void computerShips() {
        System.out.print("\n\nComputer is deploying ships");
        int x, y;
        for (int i = 1; i <= 5; i ++){
            do{
                x = random.nextInt(10);
                y = random.nextInt(10);
            }while (sea[x][y] == 1 || sea[x][y] == 2);
            sea[x][y] = 2;
            System.out.print("\nShip " + i + " deployed.");
        }
    }

    private static void playerShips() {
        int x, y;
        for (int i = 1; i <= 5; i ++){
            do{
                System.out.print("\nEnter X coordinate for your " + i + " ship: ");
                x = input.nextInt();
                System.out.print("Enter Y coordinate for your " + i + " ship: ");
                y = input.nextInt();
            } while (sea[x][y] == 1);
            sea[x][y] = 1;
        }
    }

    private static void drawMap() {
            if (computerShips == 0){
                System.out.print("\n\nYOU WIN! Congratulations! :)");
                gameOver = true;
            } else if (playerShips == 0){
                System.out.print("\n\nYOU LOST :(");
                gameOver = true;
            }

            //top
            System.out.print("\n\n    ");
            for (int i = 0; i < SEA_SIZE; i++) System.out.print(i);
            //body
            for (int y = 0; y < sea.length; y++){
                System.out.print("\n " + y + " |");
                for (int x = 0; x < sea[0].length; x++){
                    switch (sea[x][y]){
                        case 0, 2: System.out.print(" ");
                            break;
                        case 1: System.out.print("@");
                            break;
                        case 3: System.out.print("X");
                            break;
                        case 4: System.out.print("-");
                            break;
                    }
                }
                System.out.print(" ");
                System.out.print("| " + y);
            }
            //footer
            System.out.print("\n    ");
            for (int i = 0; i < SEA_SIZE; i++) System.out.print(i);
    }
}
