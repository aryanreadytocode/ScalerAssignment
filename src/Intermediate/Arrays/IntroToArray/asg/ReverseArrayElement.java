package Intermediate.Arrays.IntroToArray.asg;

import java.util.Arrays;

/**
 * Given an array, you have to rotate element of array /left/right/anti/clock-wise by given no of times K
 * A = {3,0,-1,6,9,2,5}
 * K = 3
 * <p>
 * 1st rotation
 * A = {5,3,0,-1,6,9,2}
 * 2nd rotation
 * A = {2,5,3,0,-1,6,9}
 * 3rd rotation
 * A = {9,2,5,3,0,-1,6}
 *
 * ====
 * right / anti rotate
 * A = {3,0,-1,6,9,2,5}
 * K = 3
 * 1st rotation
 * A = {0,-1,6,9,2,5,3}
 * 2nd rotation
 * A = {-1,6,9,2,5,3,0}
 * 3rd rotation
 * A = {6,9,2,5,3,0,-1}
 */
public class ReverseArrayElement {
    public static void main(String[] args) {
        int[] input = {3, 0, -1, 6, 9, 2, 5};
        int rotation = 4;
        int[] ans = rightRotate(input, rotation);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] leftRotate(int[] input, int rotation) {
        rotation = rotation % input.length;
        // A = {3,0,-1,6,9,2,5}, K=3
        // for left rotation we can rotate entire array = {5,2,9,6,-1,0,3}
        // and then rotate from 0 to K-1 =(0, 2) = {9,2,5,6,-1,0,3}
        // and then rotate from k to N-1 = (3,6) = {9,2,5,3,0,-1,6}

        // reverse the entire array
        reverseArr(input, 0, input.length - 1);
        reverseArr(input, 0, rotation - 1);
        return reverseArr(input, rotation, input.length-1);
    }

    private static int[] reverseArr(int[] input, int startIndex, int endIndex) {
        int temp;
        while (startIndex < endIndex) {
            temp = input[startIndex];
            input[startIndex] = input[endIndex];
            input[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
        return input;
    }

    private static int[] rightRotate(int[] input, int rotation) {
        rotation = rotation % input.length;
        // A = {3,0,-1,6,9,2,5}, K=3
        // for left rotation we can rotate entire array = {5,2,9,6,-1,0,3}
        // and then rotate from 0 to (N-1-K) =(0, 3) = {6,9,2,5,-1,0,3}
        // and then rotate from (N-1-K+1) to N-1 = (4,6) = {6,9,2,5,3,0,-1}
        reverseArr(input, 0, input.length-1);
        reverseArr(input, 0, input.length-1-rotation);
        return reverseArr(input, input.length-1-rotation+1, input.length-1);
    }
}
