package advance.sorting2.hw;

public class UniqueElements {

    public static void main(String[] args) {
//        int[] A = {1,1,3};
//        int[] A = {1,5,2,6,2};
//        int[] A = {1, 3, 2, 3, 1};
        int[] A = {2000000000, 2000000000, -2000000000};
        System.out.println(new UniqueElements().solve(A));
    }

    public int solve(int[] A) {
        return mergeSort(A, 0, A.length - 1);
    }

    private int mergeSort(int[] A, int start, int end) {
        if (start == end)
            return 0;

        int mid = (start + end) / 2;
        int left = mergeSort(A, start, mid);
        int right = mergeSort(A, mid + 1, end);
        int merged = merge1(A, start, mid, end);
        return (left + right + merged);
    }

    public int merge(int[] A, int start, int mid, int end) {
        int[] helper = new int[end - start + 1]; //helper array for merging
        int leftStart = start, rightStart = mid + 1;
        int ans = 0;
        while (leftStart <= mid && rightStart <= end) {
            if ((long)A[leftStart] > 2*((long) A[rightStart])){
                ans += mid - leftStart + 1;
                rightStart++;
            } else{
                leftStart++;
            }
        }
        leftStart = start;
        rightStart = mid + 1;
        int count = 0;
        while (leftStart <= mid && rightStart <= end) {
            if (A[leftStart] <= A[rightStart]) {
                helper[count] = A[leftStart];
                leftStart++;
            }else {
                if ((long)A[leftStart] > 2*((long) A[rightStart])){
                    ans += mid - leftStart + 1;
                }
                helper[count] = A[rightStart];
                rightStart++;
            }
            count++;
        }
        while (leftStart <= mid){
            helper[count] = A[leftStart];
            count++;
            leftStart++;
        }
        while (rightStart <= end){
            helper[count] = A[rightStart];
            count++;
            rightStart++;
        }
        for (int i = 0; i < helper.length; ++i) {
            A[start+i] = helper[i];
        }
        return ans;
    }

    public int merge1(int[] A, int start, int middle, int end) {
        int count = 0;
        int leftStart = start;
        int rightStart = middle + 1;
        int[] resArr = new int[end - start + 1];
        while (leftStart <=middle && rightStart <= end) {
            if ((long)A[leftStart] > (long) 2 * (A[rightStart])) {
                count += middle -leftStart+1;
                rightStart++;
            }else {
                leftStart++;
            }
        }
        leftStart = start;
        rightStart = middle + 1;
        for (int i = 0; i < resArr.length; i++) {
            if (leftStart == middle + 1) {
                resArr[i] = A[rightStart];
                rightStart++;
            } else if (rightStart == end + 1) {
                resArr[i] = A[leftStart];
                leftStart++;
            } else if (A[leftStart] > A[rightStart]) {
                resArr[i] = A[rightStart];
                rightStart++;
            } else {
                resArr[i] = A[leftStart];
                leftStart++;
            }
        }
        int index = 0;
        for (int i = start; i <= end; i++) {
            A[i] = resArr[index];
            index++;
        }
        return count;
    }
}
