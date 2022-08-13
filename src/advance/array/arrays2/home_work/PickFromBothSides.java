package advance.array.arrays2.home_work;

import java.util.ArrayList;
import java.util.logging.Logger;

public class PickFromBothSides {
    public static void main(String[] args) {
        int[] A = {-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35};
        int B = 48;
//        int[] A = {5, -2, 3, 1, 2};
//        int B = 3;
        System.out.println(solve(A, B));
    }


    public static int solve(int[] A, int B) {
        int sum = Integer.MIN_VALUE;
        int sum1 = 0;
        int size = A.length;                   // 0 1 2 3 4
        for (int i = size-B; i < size; i++) {  //[1,2,3,4,5],  B = 3
            sum1 += A[i];
        }
        sum = sum1;
        int l = size-B;
        int r = 0;
        while (r<B) {
            sum1 = sum1- A[l]+A[r];
            sum = Math.max(sum, sum1);
            r++;
            l++;
        }
        return sum;
    }

}
