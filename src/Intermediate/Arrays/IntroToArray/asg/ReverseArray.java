package Intermediate.Arrays.IntroToArray.asg;
/**
 * Given an array, reverse the entire array*/
public class ReverseArray {

    public static void main(String[] args) {
        int[] input = {-1, 4, 3, 7, 0, 5, 9};
        int[] ans = new ReverseArray().reverse(input);
        for (int i: ans) {
            System.out.print(i+" ");
        }
    }

    private int[] reverse(int[] input) {
        int i = 0;
        int j = input.length-1;
        while (i < j) {
            int temp = input[i];
            input[i] = input[j];
            input[j] = temp;
            i++;
            j--;
        }
        return input;
    }
}
