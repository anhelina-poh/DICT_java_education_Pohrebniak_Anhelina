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

    public boolean isEmptyCell(int r, int c) {
        return cells[r][c] == ' ';
    }

    public void setCell(int r, int c, char s) {
        cells[r][c] = s;
    }
}