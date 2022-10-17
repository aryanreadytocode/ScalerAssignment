package advance.binarysearch3.exp;

public class AngryCow {

    public static void main(String[] args) {
        int[] A = {1,2,4,8,9};
        int cow = 3;
        int minDis = minDisCow(A, cow);
        System.out.println("Min Dis:"+minDis);
    }

    public static int minDisCow(int[] A, int cows) {
        int ans = 0;
        int min = 1;
        int max = A[A.length-1] - A[0];
        while (min <= max) {
            int mid = min + (max - min) /2;
            ans = mid;
            boolean isFeasible = checkFeasibility(A, cows, mid);
            if (isFeasible) {
                min = mid + 1;
                ans = Math.min(mid + 1, ans);
            }else {
                max = mid - 1;
            }
        }
        return ans;
    }

    private static boolean checkFeasibility(int[] A, int cows, int dis) {

        int ceil = A[0];
        for (int i = 1; i<cows; i++) {
            int start = 0;
            int end = A.length - 1;
            int value = dis + ceil;
            ceil = Integer.MAX_VALUE;
            if (value > A[A.length-1])
                return false;
            while (start <= end) {
                int mid = start + (end - start)/2;
                if (A[mid] == value) {
                    ceil = Math.min(ceil, A[mid]);
                    break;
                }else if (A[mid] > value) {
                    ceil = Math.min(ceil, A[mid]);
                    end = mid - 1;
                }else
                    start = mid + 1;
            }
        }
        return true;
    }
}
