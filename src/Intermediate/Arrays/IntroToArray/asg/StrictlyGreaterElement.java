package Intermediate.Arrays.IntroToArray.asg;
/**
* Given N array elements, count no of elements having at least
* 1 element strictly greater than itself
* **/
public class StrictlyGreaterElement {
    public static void main(String[] args) {
        int[] input = {3, -2, 6, 8, 4, 6, 6};
        int ans = new StrictlyGreaterElement().countElement(input);
        System.out.println(ans);
    }

    int countElement(int[] A) {
        int maxElement = Integer.MIN_VALUE;
        int maxElementCount = 1;
        // find the max element and it's count
        for (int element: A) {
            if (maxElement == element)
                maxElementCount++;
            if (element > maxElement) {
                maxElement = element;
                maxElementCount = 1;
            }
        }

        return A.length-maxElementCount;
    }
}
