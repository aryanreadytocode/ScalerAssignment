package advance.binarysearch2.asg;

public class SquareRootOfInteger {
    public static void main(String[] args) {
        int A = 2147483647;
        int sq = sqrt(A);
        System.out.println("Square root: "+sq);
    }

    public static int sqrt(int A) {
        if (A==0 || A==1)
            return A;
        int ans = Integer.MIN_VALUE;
        int start = 0;
        int end = A;
        while (start <= end ) {
            int mid = start + (end -start)/2;
            if (mid == A/mid) {
                return mid;
            }else if(mid  < A/mid){
                start = mid + 1;
                ans = Math.max(ans, mid);
            }else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
