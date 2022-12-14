package advance.backtrack_2.asg;

public class SudokuOptimize {

    public static void main(String[] args) {
        char[][] A = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solveSudoku(A);

        for (int i = 0; i < 9; i++) {
            System.out.print("{");
            for (int j = 0; j < 9; j++) {
                System.out.print(A[i][j]);
            }
            System.out.print("}");
            System.out.println();
        }

    }

    public static void solveSudoku(char[][] A) {
        int N = A.length;
        solve(A, N);
    }

    private static boolean solve(char[][] input, int N) {
        int row = -1;
        int col = -1;
        boolean filledCompletely = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (input[i][j] == '.') {
                    filledCompletely = false;
                    row = i;
                    col = j;
                    break;
                }
            }
            // if empty cell found break both inner and outer loop
            if (!filledCompletely)
                break;
        }
        if (filledCompletely)
            return true;

        for (int digit = 1; digit<=N; digit++) {
            char c = (char)(digit+'0');
            if (isValid(input, row, col, c, N)) {
                    input[row][col] = c;
                if (solve(input, N))
                    return true;
                else
                    input[row][col] = '.';
            }
        }
        return false;
    }

    public static boolean isValid(char[][] arr, int row, int col, int val, int N) {
        //check for row same digit is present or not
        for (int i = 0; i <N; i++) {
            if (arr[i][col] == val)
                return false;
        }
        //check for column same digit is present or not
        for (int j = 0; j<N; j++) {
            if (arr[row][j] == val)
                return false;
        }
        //check for sub matrix same digit is present or not
        int smj = (col/3) * 3;
        int smi = (row/3) * 3;
        for (int i = 0; i< 3; i++) {
            for (int j = 0; j< 3; j++) {
                if (arr[i+smi][j+smj] == val)
                    return false;
            }
        }
        return true;
    }

}
