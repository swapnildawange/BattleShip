package battleship.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tool {
    static StringBuilder alphabets = new StringBuilder("0ABCDEFGHIJ");

    public static void createBoard(String[][] board) {
        board[0][0] = " ";

        for (int i = 1; i < 11; i++) {
            board[i][0] = String.valueOf(alphabets.charAt(i));
            board[0][i] = String.valueOf(i);

            for (int j = 1; j < 11; j++) {

                board[i][j] = "~";
            }
        }
    }

    public static void displayBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void addShip(String[][] board, int[] cords) {
        int i = cords[0];
        int j = cords[1];
        int l = cords[2];
        int m = cords[3];

        if (i == l) {
            if (checkPosition(board, i, j, l, m)) {
                if (j < m) {

                    for (int x = j; x <= m; ++x) {
                        board[i][x] = "O";

                    }
                } else {

                    for (int x = m; x <= j; ++x) {
                        board[i][x] = "O";

                    }
                }

            }
        } else {
            if (i < l) {
                if (checkPosition(board, i, j, l, m)) {

                    for (int x = i; x <= l; ++x) {
                        board[x][j] = "O";

                    }

                }
            } else {
                if (checkPosition(board, i, j, l, m)) {

                    for (int x = l; x <= i; ++x) {
                        board[x][j] = "O";

                    }

                }
            }

        }

    }

    public static int[] getCoordinates(String firstCoordinate, String secondCoordinate) {
        int[] cords = new int[4];
        String row = "";
        String column = "";
        int pointer = 0;
        Matcher matcher1 = Pattern.compile("([A-Z]+)([0-9]+)").matcher(firstCoordinate);
        if (matcher1.find()) {
            row = matcher1.group(1);
            column = matcher1.group(2);

        }
        cords[pointer++] = alphabets.indexOf(row);
        cords[pointer++] = Integer.parseInt(column);

        Matcher matcher2 = Pattern.compile("^(\\w+)(\\d+)").matcher(secondCoordinate);
        if (matcher2.find()) {
            row = matcher2.group(1);
            column = matcher2.group(2);
        }

        cords[pointer++] = alphabets.indexOf(row);
        cords[pointer++] = Integer.parseInt(column);
        return cords;
    }

    public static int[] getCoordinates(String cordinates) {
        int[] cords = new int[2];
        String row = "";
        String column = "";
        int pointer = 0;
        Matcher matcher1 = Pattern.compile("([A-Z]+)([0-9]+)").matcher(cordinates);
        if (matcher1.find()) {
            row = matcher1.group(1);
            column = matcher1.group(2);

        }
        cords[pointer++] = alphabets.indexOf(row);
        cords[pointer++] = Integer.parseInt(column);
        return cords;
    }

    public static boolean checkPosition(String[][] board, int i, int j, int l, int m) {
        //check if there is already a ship at the position
        for (int x = i; x <= l; ++x) {
            for (int y = j; y <= m; y++) {
                if (board[x][y].equals("O")) {
                    return false;
                }
            }
        }
        return true;
    }

    //check if ship is too close to another ship
    public static boolean checkClose(String[][] board, int[] cords) {
        int i = cords[0];
        int j = cords[1];
        int l = cords[2];
        int m = cords[3];

        if (i == l) {

            if (j < m) {
                for (int x = j; x <= m; ++x) {
                    if (isValid(x, i) && close(board, x, i)) {
                        return true;
                    }
                }
            } else {
                for (int x = m; x <= j; ++x) {
                    if (isValid(i, x) && close(board, i, x)) {
                        return true;
                    }
                }
            }

        } else {
            if (i < l) {

                for (int x = i; x <= l; ++x) {
                    if (isValid(x, j) && close(board, x, j)) {
                        return true;
                    }
                }

            } else {

                for (int x = l; x <= i; ++x) {
                    if (isValid(x, j) && close(board, x, j)) {
                        return true;
                    }
                }

            }

        }
        return false;

    }

    //check if the coordinates are in range of board dimensions
    public static boolean isValid(int x, int y) {
        if (x < 9 && y < 9 && x > 1 && y > 1) {
            return true;
        }
        return false;
    }

    //check consecutive 8 positions from given point
    public static boolean close(String[][] board, int x, int y) {
        if (board[x + 1][y].equals("O") || board[x][y + 1].equals("O") || board[x + 1][y + 1].equals("O")
                || board[x - 1][y].equals("O") || board[x - 1][y - 1].equals("O") || board[x][y - 1].equals("O")
                || board[x + 1][y - 1].equals("O") || board[x - 1][y + 1].equals("O")) {
            return true;
        }
        return false;
    }

    //check is coordinates are valid
    public static boolean checkCords(int[] cords) {
        if (cords[0] >= 0 && cords[0] <= 10 && cords[1] >= 0 && cords[1] <= 10) {
            return true;

        }
        return false;
    }

    //check if given cords have a ship
    public static boolean checkShip(String[][] board, int[] cords) {

        if (board[cords[0]][cords[1]].equals("O")) {
            return true;
        }
        return false;
    }

    //shot the ship at given coordinates
    public static void shotShip(String[][] board, int[] cords) {
        board[cords[0]][cords[1]] = "X";


    }

    //shot all ships at given position aon all boards
    public static void shotAllShip(String[][] board2, String[][] board31, String[][] board32, String[][] board4, String[][] board5, int[] cords) {
        board2[cords[0]][cords[1]] = "X";
        board31[cords[0]][cords[1]] = "X";
        board32[cords[0]][cords[1]] = "X";
        board4[cords[0]][cords[1]] = "X";
        board5[cords[0]][cords[1]] = "X";

    }

    //add miss-ship at given position on the board
    public static void missShip(String[][] board, int[] cords) {
        board[cords[0]][cords[1]] = "M";


    }

    //check if ship is sink of given board
    public static boolean isSink(String[][] board) {
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                if (board[i][j].equals("O")) {
                    return false;
                }
            }
        }
        return true;
    }

    //reset already sank ship so it won't show again
    public static boolean resetBoard(String[][] board) {
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                board[i][j] = "O";
            }
        }
        return true;
    }

}
