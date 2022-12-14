package advance.backtrack_2.asg;

public class SudokuNaive {
    public static void main(String[] args) {
        char[][] A = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        solveSudoku(A);

        for (int i = 0; i<9; i++) {
            System.out.print("{");
            for (int j = 0; j<9; j++) {
                System.out.print(A[i][j]);
            }
            System.out.print("}");
            System.out.println();
        }

    }

    public static void solveSudoku(char[][] A) {
        int N = A.length;
        int row = 0;
        int col = 0;
        char[][] intermediateArr = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                intermediateArr[i][j] = A[i][j];
            }
        }
        solve(row, col, A, intermediateArr, N);
    }

    private static void solve(int row, int col, char[][] input, char[][] intermediateArr, int N) {


//        [[53..7....],
//        [6..195...],
//        [.98....6.],
//        [8...6...3],
//        [4..8.3..1],
//        [7...2...6],
//        [.6....28.],
//        [...419..5],
//        [....8..79]]

        if (row == N){
            addToInput(input, intermediateArr, N);
            return;
        }

        int ni = 0;
        int nj = 0;
        if (col == N-1) {
            ni = row+1;
        } else {
            nj = col+1;
            ni = row;
        }

        if (intermediateArr[row][col] != '.') {
            solve(ni, nj, input, intermediateArr, N);
        } else {
            for (char digit = '1'; digit <= '9'; digit++) {
                if (isValid(intermediateArr, row, col, digit,N)) {
                    intermediateArr[row][col] = digit;
                    solve(ni, nj, input, intermediateArr, N);
                    intermediateArr[row][col] = '.';
                }
            }
        }
    }

    private static void addToInput(char[][] input, char[][] intermediateArr, int N) {
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                input[i][j] = intermediateArr[i][j];
            }
        }
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
