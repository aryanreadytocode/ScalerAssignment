package advance.stack2.hw;

import java.util.Stack;

public class MaximumRectangle {
    public static void main(String[] args) {
        int[][] A = {{0, 0, 1}, {0, 1, 1}, {1, 1, 1}};
        int ans = solve(A);
        System.out.println(ans);

    }

    public static int solve(int[][] A) {

        // for every column find the element with prefix sum if found zero don't update with prefix sum keep as it is.
        //     0  1  2  >> indices
        //  0 [0, 0, 1]
        //  1 [0, 1, 1]
        //  2 [1, 1, 1]
        for (int rowIndex = 1; rowIndex < A.length; rowIndex++) {
            for (int colIndex = 0; colIndex < A[0].length; colIndex++) {
                if (A[rowIndex][colIndex] != 0)
                    A[rowIndex][colIndex] = A[rowIndex-1][colIndex]+1;

            }
        }
        // now the 2-D matrix has become like multiple histogram problem
        //  0  1  2  >> indices
        //  0 [0, 0, 1]
        //  1 [0, 1, 2]
        //  2 [1, 2, 3]
        int maxArea = 0;
        for (int row = 0; row<A.length; row++) {
            int area = largestRectangleArea(A[row]);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;

    }

    public static int largestRectangleArea(int[] A) {
        int length = A.length;
        int maxArea = 0;
        // find right boundaries ie nearest smallest element to the left
        Stack<Integer> stack1 = new Stack<>();
        int[] rb = new int[length]; // array to store index
        for (int index = length-1; index>= 0; index--) {
            while (stack1.size()>0 && A[index] <= A[stack1.peek()]) {
                stack1.pop();
            }
            if (stack1.size() == 0) {
                rb[index] = length;
            }else {
                rb[index] = stack1.peek();
            }
            stack1.push(index);
        }

        // find left boundaries ie nearest smallest element to the left
        int[] lb = new int[length]; // array to store index
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(0);
        for (int index = 0; index< length; index++) {
            while (stack2.size()>0 && A[index] <= A[stack2.peek()]) {
                stack2.pop();
            }
            if (stack2.size() == 0) {
                lb[index] = -1;
            }else {
                lb[index] = stack2.peek();
            }
            stack2.push(index);
        }


        // find the area formed by the block using left and right boundaries, and it's height
        int width;
        int height;
        int currentArea;
        for (int index = 0; index < length; index++) {
            width = rb[index] - lb[index] -1;
            height = A[index];
            currentArea = width * height;
            maxArea = Math.max(currentArea, maxArea);
        }
        return maxArea;
    }
}
