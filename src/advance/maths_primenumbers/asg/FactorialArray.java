package advance.maths_primenumbers.asg;

import java.util.Arrays;

public class FactorialArray {
    static int  mod = 1000000007;
    public static void main(String[] args) {
//        int[] arr = {2,3,2,3};
        int[] arr = {251, 923, 561, 230, 100, 399, 542, 198, 548, 892, 721, 781, 174, 809, 9, 232, 165, 861, 36, 837, 377, 313, 475, 269, 210, 530, 940, 570, 24, 434, 764, 275, 709, 325, 505, 161, 724, 47, 359, 625, 291, 81, 406, 465, 242, 767, 698, 408, 629, 86, 597, 358, 399, 72, 979, 962, 603, 919, 884, 627, 353, 1, 254, 414, 678, 111, 575, 755, 511, 287, 380, 802, 720, 138, 620, 314, 905, 670, 74, 886, 756, 671, 244, 508, 744, 224, 822, 347, 495, 706, 326, 201, 707, 580, 615, 386, 43, 543, 141, 554};
//        int[] arr = {251, 923, 561, 230, 100, 399, 542, 198};
//        int[] arr = {2,3,2};
        System.out.println((solve(arr)));

    }

    public static int solve(int[] A) {
        int[] spf = buildModifiedSpf(A); //[1,1,1, 1, 1]
        for (int i = 0 ; i<A.length; i++) {
            int ele = A[i];
            int pf = spf[ele];
            A[i] = pf;
        }
          //[1,1,1,1,1]
        int count = 1;
        int ans = 0;
        for (int i = 1; i<A.length; i++) {
            if (A[i] == A[i-1])
                count++;
            else {
                ans += ((1<<count)-1)%mod;
                count = 1;
            }
        }
        ans += ((1<<count)-1)%mod;
        return ans%mod;
    }

    private static int[] buildModifiedSpf(int[] A) {
        Arrays.sort(A);
        int length = A[A.length-1];
        int[] spf = new int[length+1];
        int currentNoPf = 0;
        for (int i = 2; i*i<=length; i++) {
            if (spf[i] == 0) {
                currentNoPf++;
                spf[i] = currentNoPf;
                if (i*i>=length || i*i<0)
                    continue;
                for (int j = i*i; j<=length; j+=i) {
                    if (spf[j] == 0)
                        spf[j] = spf[i];
                }
            }else {
                spf[i] = currentNoPf;
            }
        }
        return spf;
    }

    private static int findLength(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int ele: A) {
            max = Math.max(ele, max);
        }
        return max;
    }
}
