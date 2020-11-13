package battleship.logic;

import battleship.tools.Tool;

import java.util.Scanner;

public class Player_2 extends Player {
    Scanner scanner = new Scanner(System.in);
    String[][] Player_2board = new String[11][11];


    public int player_2Counter = 1;

    public void Run() {
        System.out.println("Player 2, place your ships on the game field");

        Tool.createBoard(Player_2board);
        Tool.createBoard(emptyBoard);
        Tool.displayBoard(Player_2board);
        int pointer = 5;
        while (pointer > 1) {
            boolean ac = false;

            switch (pointer) {
                case 2:
                    System.out.println("Enter the coordinates of the Destroyer (2 cells):");
                    while (!ac) {
                        String firstCoordinate, secondCoordinate;
                        firstCoordinate = scanner.next();
                        secondCoordinate = scanner.next();
                        int[] cords = Tool.getCoordinates(firstCoordinate, secondCoordinate);
                        if (Math.abs(cords[0] - cords[2]) + 1 == 2 || Math.abs(cords[1] - cords[3]) + 1 == 2) {
                            if (cords[0] == cords[2] || (cords[1] == cords[3])) {
                                if (!Tool.checkClose(Player_2board, cords)) {
                                    Tool.addShip(Player_2board, cords);
                                    Tool.displayBoard(Player_2board);
                                    Tool.createBoard(player_2board2);
                                    Tool.addShip(player_2board2, cords);
                                    ac = true;
                                    pointer--;
                                } else {
                                    System.out.println("Error! You placed it too close to another one. Try again:");
                                    ac = false;

                                }

                            } else {
                                System.out.println("Error! Wrong ship location! Try again:");
                                ac = false;
                            }

                        } else {
                            System.out.println("Error! Wrong length of the Destroyer ! Try  again:");
                            ac = false;
                        }

                    }
                    break;
                case 3:
                    int pointer_1 = 1;
                    while (pointer_1 < 3) {
                        ac = false;
                        switch (pointer_1) {
                            case 1:
                                System.out.println("Enter the coordinates of the Submarine (3 cells)");
                                while (!ac) {
                                    String firstCoordinate, secondCoordinate;
                                    firstCoordinate = scanner.next();
                                    secondCoordinate = scanner.next();
                                    int[] cords = Tool.getCoordinates(firstCoordinate, secondCoordinate);
                                    if (Math.abs(cords[0] - cords[2]) + 1 == 3
                                            || Math.abs(cords[1] - cords[3]) + 1 == 3) {
                                        if (cords[0] == cords[2] || (cords[1] == cords[3])) {
                                            Tool.addShip(Player_2board, cords);
                                            Tool.displayBoard(Player_2board);
                                            Tool.createBoard(player_2board31);
                                            Tool.addShip(player_2board31, cords);

                                            ac = true;
                                            pointer_1++;
                                        } else {
                                            System.out.println("Error! Wrong ship location! Try again:");
                                            ac = false;
                                        }

                                    } else {
                                        System.out.println("Error! Wrong length of the Submarine ! Try  again:");
                                        ac = false;
                                    }

                                }

                                break;
                            case 2:
                                System.out.println("Enter the coordinates of the Cruiser (3 cells):");
                                while (!ac) {
                                    String firstCoordinate, secondCoordinate;
                                    firstCoordinate = scanner.next();
                                    secondCoordinate = scanner.next();
                                    int[] cords = Tool.getCoordinates(firstCoordinate, secondCoordinate);
                                    if (Math.abs(cords[0] - cords[2]) + 1 == 3
                                            || Math.abs(cords[1] - cords[3]) + 1 == 3) {
                                        if (cords[0] == cords[2] || (cords[1] == cords[3])) {
                                            Tool.addShip(Player_2board, cords);
                                            Tool.displayBoard(Player_2board);
                                            Tool.createBoard(player_2board32);
                                            Tool.addShip(player_2board32, cords);
                                            ac = true;
                                            pointer_1++;
                                            pointer--;
                                        } else {
                                            System.out.println("Error! Wrong ship location! Try again:");
                                            ac = false;
                                        }

                                    } else {
                                        System.out.println("Error! Wrong length of the Cruiser ! Try  again:");
                                        ac = false;
                                    }

                                }
                                break;

                        }
                    }
                    break;

                case 4:
                    System.out.println("Enter the coordinates of the Battleship (4 cells):");
                    while (!ac) {
                        String firstCoordinate, secondCoordinate;
                        firstCoordinate = scanner.next();
                        secondCoordinate = scanner.next();
                        int[] cords = Tool.getCoordinates(firstCoordinate, secondCoordinate);
                        if (Math.abs(cords[0] - cords[2]) + 1 == 4 || Math.abs(cords[1] - cords[3]) + 1 == 4) {
                            if (cords[0] == cords[2] || (cords[1] == cords[3])) {
                                Tool.addShip(Player_2board, cords);
                                Tool.displayBoard(Player_2board);
                                Tool.createBoard(player_2board4);
                                Tool.addShip(player_2board4, cords);
                                ac = true;
                                pointer--;
                            } else {
                                System.out.println("Error! Wrong ship location! Try again:");
                                ac = false;
                            }

                        } else {
                            System.out.println("Error! Wrong length of the Battleship ! Try  again:");
                            ac = false;
                        }

                    }

                    break;
                case 5:
                    System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells) :");
                    while (!ac) {
                        String firstCoordinate, secondCoordinate;
                        firstCoordinate = scanner.next();
                        secondCoordinate = scanner.next();
                        int[] cords = Tool.getCoordinates(firstCoordinate, secondCoordinate);

                        if (Math.abs(cords[0] - cords[2]) + 1 == 5 || Math.abs(cords[1] - cords[3]) + 1 == 5) {
                            if (cords[0] == cords[2] || (cords[1] == cords[3])) {
                                Tool.addShip(Player_2board, cords);
                                Tool.displayBoard(Player_2board);
                                Tool.createBoard(player_2board5);
                                Tool.addShip(player_2board5, cords);
                                ac = true;
                                pointer--;
                            } else {
                                System.out.println("Error! Wrong ship location! Try again:");
                                ac = false;
                            }

                        } else {
                            System.out.println("Error! Wrong length of the Aircraft Carrier ! Try  again:");
                            ac = false;
                        }

                    }

                    break;
            }

        }
        System.out.println("Press Enter and pass the move to another player");

    }

    public String[][] getPlayer_2board() {
        return Player_2board;
    }

    public void play(String[][] player_1board, String[][] player_2board) {
        String shotCords;
        Tool.displayBoard(emptyBoard);
        System.out.println("---------------------");
        Tool.displayBoard(player_2board);
        System.out.println("Player 2, it's your turn:");
        shotCords = scanner.next();
        int[] cords = Tool.getCoordinates(shotCords);

        if (Tool.checkCords(cords)) {
            if (Tool.checkShip(player_1board, cords)) {
                System.out.println("You hit a ship!");

                Tool.shotShip(player_1board, cords);
                Tool.shotAllShip(player_1board2, player_1board31, player_1board32, player_1board4, player_1board5, cords);

            } else {
                System.out.println("You missed!");

                Tool.missShip(player_1board, cords);

            }
        } else {
            System.out.println("Error! You entered the wrong coordinates! Try again:");

        }


    }

    public boolean isSink() {
        System.out.println(player_2Counter);
        if (Tool.isSink(player_2board5)) {
            if (Tool.resetBoard(player_2board5)) {
                player_2Counter++;
            }
            ;
            System.out.println("You sank a ship!");
            return true;
        } else if (Tool.isSink(player_2board4)) {
            if (Tool.resetBoard(player_2board4)) {
                player_2Counter++;
            }
            ;
            System.out.println("You sank a ship!");
            return true;
        } else if (Tool.isSink(player_2board31)) {
            if (Tool.resetBoard(player_2board31)) {
                player_2Counter++;
            }
            ;
            System.out.println("You sank a ship!");
            return true;
        } else if (Tool.isSink(player_2board32)) {
            if (Tool.resetBoard(player_2board32)) {
                player_2Counter++;
            }
            ;
            System.out.println("You sank a ship!");
            return true;
        } else if (Tool.isSink(player_2board2)) {
            if (Tool.resetBoard(player_2board2)) {
                player_2Counter++;
            }
            ;
            System.out.println("You sank a ship!");
            return true;
        }
        return false;
    }

    public boolean isAllSank() {
        if (player_2Counter == 5) {
            return true;
        }
        return false;
    }

}
