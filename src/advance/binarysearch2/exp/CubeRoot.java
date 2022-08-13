package advance.binarysearch2.exp;

public class CubeRoot {

    public static void main(String[] args) {
        int A = 130;
        int sr = cubeRoot(A);
        System.out.println("Square root of "+A +" "+sr);
    }

    public static int cubeRoot(int A) {
        int ans = Integer.MIN_VALUE;
        int start = 0;
        int end = A;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (mid * mid * mid> A) {
                end = mid - 1;
            }else if (mid * mid * mid< A) {
                ans = Math.max(mid, ans);
                start = mid + 1;
            }else
                ans = mid;
        }
        return ans;
    }
}
