package battleship.logic;


abstract class Player {
    String[][] emptyBoard = new String[11][11];

    //create separate board for each ship

    static String[][] player_1board2 = new String[11][11];
    static String[][] player_1board31 = new String[11][11];
    static String[][] player_1board32 = new String[11][11];
    static String[][] player_1board4 = new String[11][11];
    static String[][] player_1board5 = new String[11][11];
    static String[][] player_2board2 = new String[11][11];
    static String[][] player_2board31 = new String[11][11];
    static String[][] player_2board32 = new String[11][11];
    static String[][] player_2board4 = new String[11][11];
    static String[][] player_2board5 = new String[11][11];

    abstract public void Run();

}

