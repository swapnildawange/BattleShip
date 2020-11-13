package battleship.ui;

import java.util.Scanner;

import battleship.logic.Player_1;
import battleship.logic.Player_2;
import battleship.tools.Tool;

public class Game {
    static Scanner scanner = new Scanner(System.in);

    public static void start() {
        Player_1 player_1 = new Player_1();
        Player_2 player_2 = new Player_2();
        // place ships of player one on the game field
        player_1.Run();
        // for getting the enter
        scanner.nextLine();
        // place ships of player two on the game field
        player_2.Run();
        scanner.nextLine();
        // get the game field of player 1
        String[][] player_1board = player_1.getPlayer_1board();
        // get the game field of player 2
        String[][] player_2board = player_2.getPlayer_2board();

        // start the game

        int player = 0;
        while (true) {
            if (player % 2 == 0) {

                player_1.play(player_1board, player_2board);
                if (player_2.isAllSank()) {
                    System.out.println("You sank the last ship. You won. Congratulations!");
                } else {
                    player_2.isSink();
                }
                System.out.println("Press Enter and pass the move to another player");
                scanner.nextLine();

                player++;
            } else {
                player_2.play(player_1board, player_2board);

                if (player_1.isAllSank()) {
                    System.out.println("You sank the last ship. You won. Congratulations!");
                } else {
                    player_1.isSink();
                }
                System.out.println("Press Enter and pass the move to another player");
                scanner.nextLine();

                player++;
            }

        }

    }
}
