package advance.backtrack_2.asg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NQueens1 {

    public static void main(String[] args) {
        int N = 4;
        ArrayList<ArrayList<String>> ans = new NQueens1().solveNQueens(N);
        for (int i = 0; i < N; i++) {
            System.out.println(ans.get(i).toString());
        }
    }

    private ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String >> ans = new ArrayList<>();
        ArrayList<ArrayList<String>> board = new ArrayList<>();

        ArrayList<Integer> leftRow = new ArrayList<>();
        ArrayList<Integer> upDiag = new ArrayList<>();
        ArrayList<Integer> lowDiag = new ArrayList<>();
        // initialize with value
        for (int i = 0; i<n; i++) {
            leftRow.add(0);
        }
        for (int i = 0; i<(2*n-1); i++) {
            upDiag.add(0);
            lowDiag.add(0);
        }
        for (int i = 0; i<n; i++) {
            ArrayList<String> temp = new ArrayList<>();
            for (int j = 0; j<n; j++) {
                temp.add(".");
            }
            board.add(temp);
        }
        solve(0, board, ans, leftRow, upDiag, lowDiag, n);
        return ans;
    }

    private void solve(int col, ArrayList<ArrayList<String>> board, ArrayList<ArrayList<String>> ans, ArrayList<Integer> leftRow, ArrayList<Integer> upDiag, ArrayList<Integer> lowDiag, int n) {
        // sanity check
        if (col< 0 || n<0)
            return;

        // base case
        if (col == n) {
            ans.addAll(board);
            return;
        }
        for (int row = 0; row < n; row++) {
            if (leftRow.get(row) == 0 && lowDiag.get(row+col) == 0 && upDiag.get(n-1+col-row) == 0){
                board.get(row).set(col, "Q");
                leftRow.set(row,1);
                lowDiag.set(row+col, 1);
                upDiag.set(n-1+row-col, 1);
                solve(col+1, board, ans, leftRow, upDiag, lowDiag, n);
                board.get(row).set(col, ".");
                leftRow.set(row, 0);
                lowDiag.set(row+col, 0);
                upDiag.set(n-1+col-row, 0);
            }
        }
    }


    /// This solution taught by tarun scaler which is giving null pointer exception
    Map<Integer, Boolean> hmRow = new HashMap<>(), hmCol = new HashMap<>(),
            hmFDiag = new HashMap<>(), hmRDiag = new HashMap<>();
    String[][] ans, presentState;
    int x = 0, y = 0, qPlaced = 0;

    public String[][] solveNQueensByTarunConcept(int A) {
        // initialize value for all the hashmap with null
        for (int i = 0; i < A; i++) {
            hmRow.put(i, false);
            hmCol.put(i, false);

        }
        for (int j = 0; j < 2*A-1; j++) {
            hmFDiag.put(j, false);
            hmRDiag.put(j, false);
        }
        ans = new String[A][A];
        presentState = new String[A][A];
        solveQConfig(x, y, A);
        return ans;
    }

    private void solveQConfig(int x, int y, int N) {

        // sanity check
        if (x < 0 || y < 0)
            return;

        // base case positive
        if (qPlaced == N)
            ans = presentState;
        if (x >= N || y >= N)
            return;

        // Backing tracking
        // using back track you have two options
        // either place a queen or not place a queen
        // first we'll consider not place a queen.
        // Do Empty
        // recur
        if (y < N - 1)
            solveQConfig(x, y + 1, N);
        else
            solveQConfig(x + 1, 0, N);
        // undo emtpy

        // second condition keep the queen at particular position
        if ((!hmRow.get(x)) && (!hmCol.get(y)) && (!hmFDiag.get(x-y)) && (!hmRDiag.get(x + y))) {
            presentState[x][y] = ("Q");
            hmCol.put(x, true);
            hmRow.put(x, true);
            hmRDiag.put(x+y, true);
            hmFDiag.put(x-y, true);
            qPlaced++;

            solveQConfig(x + 1, 0, N);
            // undo parts
            presentState[x][y] = null;
            hmCol.put(x, false);
            hmRow.put(x, false);
            hmRDiag.put(x+y, false);
            hmFDiag.put(x-y,false);
            qPlaced--;
        }
    }
}
