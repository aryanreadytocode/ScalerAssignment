package advance.binarysearch1.hw;

import javax.swing.text.BadLocationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*https://www.youtube.com/watch?v=q6IEA26hvXc  solution of this problem*/
/*
 * */
public class MedianOfArray {

    public static void main(String[] args) {
        int[] A = {-43, -25, -18, -15, -10, 9, 39, 40};
        int[] B = {-2};

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i : A) {
            a.add(i);
        }
        for (int j : B) {
            b.add(j);
        }
        double median = findMedianSortedArrays(a, b);
        System.out.println("median is : " + median);

    }

    public static double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
        int n = A.size();
        int m = B.size();
        if (n > m) {
           return findMedianSortedArrays(B, A);
        }

        int totalLength = A.size() + B.size();
        int start = 0;
        int end = n;
        while (start <= end) {
            int middleA =  (end + start) / 2;
            int middleB = (n+m+1)/2 - middleA;
            // of A and 2 bcz index starts at zero toget middle index of B.
            int leftA = middleA == 0 ? Integer.MIN_VALUE : A.get(middleA-1);
            int rightA = middleA == n ? Integer.MAX_VALUE : A.get(middleA);
            int leftB = middleB == 0 ? Integer.MIN_VALUE : B.get(middleB-1);
            int rightB = middleB == m ? Integer.MAX_VALUE : B.get(middleB);

            if (leftA <= rightB && leftB <= rightA) {
                if (totalLength % 2 != 0)
                    return Math.max(leftA, leftB);
                else
                    return (double) (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2;
            } else if (leftA > leftB) {
                end = middleA - 1;
            } else
                start = middleA + 1;
        }

        return 0;
    }
}
