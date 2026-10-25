package TicTacToe;

@SuppressWarnings("all")
public class GameBoard {
    protected char[][] cells = new char[3][3];

    public void setupFromString(String str) {
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char ch = str.charAt(idx++);
                cells[i][j] = (ch == '_') ? ' ' : ch;
            }
        }
    }

    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public int count(char symbol) {
        int c = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == symbol) c++;
            }
        }
        return c;
    }

    public boolean checkWin(char s) {
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == s && cells[i][1] == s && cells[i][2] == s) return true;
            if (cells[0][i] == s && cells[1][i] == s && cells[2][i] == s) return true;
        }
        if (cells[0][0] == s && cells[1][1] == s && cells[2][2] == s) return true;
        if (cells[0][2] == s && cells[1][1] == s && cells[2][0] == s) return true;
        return false;
    }

    public String analyzeState() {
        int xCount = count('X');
        int oCount = count('O');
        boolean xWin = checkWin('X');
        boolean oWin = checkWin('O');
        int emptyCount = count(' ');

        if (Math.abs(xCount - oCount) >= 2 || (xWin && oWin)) {
            return "Impossible";
        }
        if (xWin) return "X wins";
        if (oWin) return "O wins";
        if (emptyCount == 0) return "Draw";
        return "Game not finished";
    }
}