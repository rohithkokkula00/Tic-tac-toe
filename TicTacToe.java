import java.util.Scanner;

public class Tictactoe {

    private static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    private static char currentPlayer = 'X'; // Player X starts

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Print the initial empty board
        printBoard();

        // Keep playing until the game ends (win or draw)
        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Check if the input is valid
            if (isValidMove(row, col)) {
                // Place the player's symbol on the board
                board[row][col] = currentPlayer;
                printBoard();

                // Check if the current player has won
                if (checkWin()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                // Check if the board is full (draw)
                if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    break;
                }

                // Switch players
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move, please try again.");
            }
        }

        scanner.close();
    }

    // Method to print the board
    public static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n---------");
        }
    }

    // Method to check if the current player has won
    public static boolean checkWin() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
            (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }
        return false;
    }

    // Method to check if the board is full (i.e., a draw)
    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }
}