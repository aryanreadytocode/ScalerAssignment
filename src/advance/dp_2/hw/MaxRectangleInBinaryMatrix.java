package advance.dp_2.hw;

import java.util.Stack;

public class MaxRectangleInBinaryMatrix {

    public static void main(String[] args) {
//        int[][] input = {
//                {0, 1, 0},
//                {1, 1, 1}
//        };
//        int[][] input = {
//                {1, 1, 1},
//                {0, 1, 1},
//                {1, 0, 0}
//        };
        int[][] input = {
                {1}};
        int ans = new MaxRectangleInBinaryMatrix().maximalRectangle(input);
        System.out.println(ans);

    }

    public int maximalRectangle(int[][] A) {
        int rowSize = A.length;
        int colSize = A[0].length;
        int[][] dp = new int[rowSize + 1][colSize];
        int maxArea = 0;
        for (int i = 0; i < rowSize; ++i) {
            // find left limit
            int leftBound = -1;
            Stack<Integer> st = new Stack<>();
            int[] left = new int[colSize];
            for (int j = 0; j < colSize; ++j) {
                if (A[i][j] == 1) {
                    if (i!=0)
                        A[i][j] = 1 + A[i - 1][j];
                    while (!st.empty() && A[i][j] <= A[i][st.peek()])
                        st.pop();
                    int val = leftBound;
                    if (!st.empty())
                        val = Math.max(val, st.peek());
                    left[j] = val;
                } else {
                    leftBound = j;
                    left[j] = 0;
                }
                st.push(j);
            }
            // clearstack
            while (!st.empty())
                st.pop();
            // find right limit and area as well
            int rightBound = colSize;
            for (int j = colSize - 1; j >= 0; --j) {
                if (A[i][j] != 0) {
                    while (!st.empty() && A[i][st.peek()] >= A[i][j])
                        st.pop();
                    int val = rightBound;
                    if (!st.empty())
                        val = Math.min(val, st.peek());
                    dp[i][j] = A[i][j] * ((val-1)-(left[j]+1)+1);
                    maxArea = Math.max(maxArea, dp[i][j]);
                    st.push(j);
                } else {
                    dp[i][j] = 0;
                    rightBound = j;
                }
            }
        }
        return maxArea;
    }
}
