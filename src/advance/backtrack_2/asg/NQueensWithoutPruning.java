package advance.backtrack_2.asg;

import java.util.ArrayList;
import java.util.HashMap;

public class NQueensWithoutPruning {

    public static void main(String[] args) {
        int N = 4;
        ArrayList<ArrayList<String>> ans = new NQueensWithoutPruning().solveNQueens(N);
        for (int i = 0; i < N; i++) {
            System.out.println(ans.get(i).toString());
        }
    }

    HashMap<Integer, Boolean> rowHM = new HashMap<>();
    HashMap<Integer, Boolean> colHM = new HashMap<>();
    HashMap<Integer, Boolean> fDiagHM = new HashMap<>();
    HashMap<Integer, Boolean> rDiagHM = new HashMap<>();

    private ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> presentState = new ArrayList<>();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            ArrayList<String> temp = new ArrayList<>();
            for (int j= 0; j<n; j++) {
                temp.add(".");
            }
            presentState.add(temp);
        }

        /// initialize the value
        for (int i = 0; i < n; i++) {
            rowHM.put(i, false);
            colHM.put(i, false);
        }
        for (int i = 0; i < 2 * n - 1; i++) {
            fDiagHM.put(i, false);
            rDiagHM.put(i, false);
        }

        findQueenConfig(0, 0, presentState, ans, n);
        return ans;
    }

    private void findQueenConfig(int x, int y, ArrayList<ArrayList<String>> presentState, ArrayList<ArrayList<String>> ans, int N) {
        // sanity check
        if (x < 0 || y < 0 || x>N || y>N)
            return;

        // base case
        if (x == N || y == N) {
            if (checkStateValid(x, y, N)) {
                System.out.print("data being added for "+x+" "+y);
                ans = (presentState);
            }
            return;
        }

        /// solving using backtrack
        // so here we have two choices to make
        // either keep queen at particular position or not
        // we'll explore these two option


        // check for not place a queen so there would nothing in change in
        // present state (Do step of backtrack)
        // then we have recursive call step
        System.out.print("Queen Not placed"+x+" "+y);
        if (y < N-1)
            findQueenConfig(x, y+1, presentState, ans, N);
        else
            findQueenConfig(x+1, 0, presentState, ans, N);
        // Undo step of backtrack would be empty because as do step was empty

        // now it's time to explore other option
        // place the queen at particular position
        // Do step place a queen at position
        presentState.get(x).set(y, "Q");
        rowHM.put(x, true);
        colHM.put(y, true);
        fDiagHM.put(x+y, true);
        rDiagHM.put(N-1+y-x, true);

        // recursive call
        System.out.print("Queen placed"+x+" "+y);
        if (y < N-1)
            findQueenConfig(x, y+1, presentState, ans, N);
        else
            findQueenConfig(x+1, 0, presentState, ans, N);

        // undo step
        presentState.get(x).set(y, ".");
        rowHM.put(x, false);
        colHM.put(y, false);
        fDiagHM.put(x+y, false);
        rDiagHM.put(N-1+y-x, false);
    }

    private boolean checkStateValid(int x, int y, int n) {
        int tempx = x, tempy = y;
        if (x==n)
            tempx = x-1;
        if (y==n)
            tempy = y-1;

        boolean row, col, fdiag, rdiag;
        row = !rowHM.get(tempx);
        col = !colHM.get(tempy);
        fdiag = !fDiagHM.get(tempx + tempy);
        rdiag = !rDiagHM.get(n - 1 + tempy - tempx);
        return row & col & fdiag & rdiag;
    }


}
