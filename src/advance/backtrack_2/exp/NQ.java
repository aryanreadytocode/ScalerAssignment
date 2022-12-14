package advance.backtrack_2.exp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class NQ {

    public static void main(String[] args) {
        int N = 4;
        ArrayList<ArrayList<String >> ans = new NQ().solveNQueens(N);
        for (int i = 0; i<N; i++) {
            System.out.print("[");
            for (int j = 0; j<N; j++) {
                System.out.print(ans.get(i).get(j));
            }
            System.out.print("]");
            System.out.println();
        }
    }
    HashSet<Integer> column = new HashSet<Integer>();
    HashSet<Integer> ld = new HashSet<Integer>();
    HashSet<Integer> rd = new HashSet<Integer>();
    ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
    int mat[][];
    int N;

    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        N = A;
        mat = new int[N][N];

        for (int[] row : mat)
            Arrays.fill(row, 0);
        queens(0);
        return ans;
    }

    void queens(int row) {
        if (row == N) {

            ans.add(getStringRepresentation(mat));
            return;
        }
        for (int col = 0; col < N; col++) {
            if (check(row, col)) {
                mat[row][col] = 1;
                column.add(col);
                ld.add(row - col);
                rd.add(row + col);
                queens(row + 1);
                mat[row][col] = 0;
                column.remove(col);
                ld.remove(row - col);
                rd.remove(row + col);
            }
        }
        return;
    }

    boolean check(int row, int col) {
        if (column.contains(col)) return false;
        if (ld.contains(row - col)) return false;
        if (rd.contains(row + col)) return false;
        return true;
    }

    ArrayList<String> getStringRepresentation(int[][] mat) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < mat.length; i++) {
            StringBuilder builder = new StringBuilder(mat[0].length);
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0)
                    builder.append(".");
                else
                    builder.append("Q");
            }
            list.add(builder.toString());
        }
        return list;
    }
}
