package advance.backtrack_2.asg;

public class NQueensGOG {

    public static void main(String[] args) {
        int A = 4;
        String[][] ans = new NQueensGOG().solveNQueens(A);
        if (ans.length != 0) {
            for (int i = 0; i < A; i++) {
                System.out.print("{");
                for (int j = 0; j < A; j++) {
                    System.out.print(ans[i][j]);
                }
                System.out.print("}");
                System.out.println();
            }
        } else
            System.out.print("");
    }

    public String[][] solveNQueens(int A) {
        String[][] board = new String[A][A];
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                board[i][j] = ".";
            }
        }
        if (QueenConfig(board, 0, A))
            return board;
        else
            return new String[0][0];
    }

    public boolean checkQueenCanBePlaced(String[][] board, int row, int col, int N) {
        // check if queen is already placed left side of row
        for (int i = 0; i < col; i++) {
            if (board[row][i].equals("Q"))
                return false;
        }

        // check if queen has already placed at upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j].equals("Q"))
                return false;
        }

        // check if queen has already placed at lower diagonal
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j].equals("Q"))
                return false;
        }
        return true;
    }

    public boolean QueenConfig(String[][] board, int col, int N) {
        // sanity check
        if (col < 0 || col > N)
            return false;

        // base case
        if (col == N) {
            return true;
        }
        // consider this column and try placing queen at every
        // rows one by one
        for (int i = 0; i < N; i++) {
            // check if the queen can be placed at board[i][col]
            if (checkQueenCanBePlaced(board, i, col, N)) {
                // do part
                board[i][col] = "Q";

                // recursive call
                // recur to place rest of the queen
                if (QueenConfig(board, col + 1, N))
                    return true;

                // if placing queen in board[i][col] doesn't lead to
                // solution then remove queen from the board[i][col]
                board[i][col] = ".";


            }
        }
        return false;
    }
}
