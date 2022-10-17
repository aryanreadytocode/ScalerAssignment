package advance.stack2.asg;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] A = {47, 69, 67, 97, 86, 34, 98, 16, 65, 95, 66, 69, 18, 1, 99, 56, 35, 9, 48, 72, 49, 47, 1, 72, 87, 52,
                13, 23, 95, 55, 21, 92, 36, 88, 48, 39, 84, 16, 15, 65, 7, 58, 2, 21, 54, 2, 71, 92, 96, 100, 28, 31, 24,
                10, 94, 5, 81, 80, 43, 35, 67, 33, 39, 81, 69, 12, 66, 87, 86, 11, 49, 94, 38, 44, 72, 44, 18, 97, 23, 11,
                30, 72, 51, 61, 56, 41, 30, 71, 12, 44, 81, 43, 43, 27};
        int maxArea = largestRectangleArea(A);
        System.out.println("Max Area: "+maxArea);
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
