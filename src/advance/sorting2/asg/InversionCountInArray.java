package advance.sorting2.asg;

public class InversionCountInArray {

    public static void main(String[] args) {
//        int[] A = {3, 2, 1};
        int[] A = {28, 18, 44, 49, 41, 14};
        System.out.println(new InversionCountInArray().solve(A));
    }

    public int solve(int[] A) {
        return invCount(A, 0, A.length - 1);
    }

    private int invCount(int[] A, int start, int end) { // 321, 0 , 2/ 01 / 0
        int MOD = 1000000007;
        if (start == end)
            return 0;

        int mid = (start + end) / 2;
        int left = invCount(A, start, mid) % MOD;
        int right = invCount(A, mid + 1, end) % MOD;
        int merged = merge(A, start, mid, end) % MOD;
        return (left + right + merged) % MOD;
    }

    private int merge(int[] A, int start, int mid, int end) { // 28, 18, 44, 49, 41, 14  // 18, 28, 44, 14, 41, 49
        int count = 0;
        int MOD = 1000000007;
        int leftStart = start;
        int rightStart = mid+1;
        int[] resArr = new int[end-start+1];
        for (int i = 0; i< resArr.length; i++) {
            if (leftStart == mid + 1) {
                resArr[i] = A[rightStart];
                rightStart++;
            } else if (rightStart == end+1) {
                resArr[i] = A[leftStart];
                leftStart++;
            } else if (A[leftStart] <= A[rightStart]) {
                resArr[i] = A[leftStart];
                leftStart++;
            } else {
                resArr[i] = A[rightStart];
                count += mid - leftStart + 1;
                rightStart++;
            }
        }

        int resArrIndex = 0;
        for (int i = start; i <= end; i++) {
            A[i] = resArr[resArrIndex];
            resArrIndex++;
        }
        return count%MOD;

    }
    private int merge1(int[] A, int start, int mid, int end) {
        int count = 0;
        int startLeft = start;
        int startRight = mid + 1;
        int resArrIndex = 0;
        int MOD = 1000000007;

        int[] resArr = new int[end - start + 1];
        while (startLeft <= mid && startRight <= end) { // 3, 1
            if (A[startLeft] <= A[startRight]) {
                resArr[resArrIndex] = A[startLeft];
                startLeft++;
                resArrIndex++;
            } else {
                resArr[resArrIndex] = A[startRight];
                startRight++;
                resArrIndex++;
                count += (mid - startLeft + 1) % MOD;
            }
        }
        while (startLeft <= mid) {
            resArr[resArrIndex] = A[startLeft];
            startLeft++;
            resArrIndex++;
        }

        while (startRight <= end) {
            resArr[resArrIndex] = A[startRight];
            startRight++;
            resArrIndex++;
        }

        resArrIndex = 0;
        for (int i = start; i <= end; i++) {
            A[i] = resArr[resArrIndex];
            resArrIndex++;
        }
        return count % MOD;

    }
}
