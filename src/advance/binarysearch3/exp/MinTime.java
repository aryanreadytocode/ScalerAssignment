package advance.binarysearch3.exp;
/*
* There are given N tasks and K engineers
* You have to find the minimum time to complete N tasks by K engineers
* A single engineer can take consecutive task
* No task can be done by more than 1 engineers
* Ex- Tasks >> 10|5|7|8 K = 2
* 10|| 5|7|8 >> K1-10 K2-20 MIN-20
* 10|5|| 7|8 >> K1-15 K2-15 MIN-15  BEST ANS
* 10|5|7|| 8 >> K1-22 K2-8 MIN-22
* 10|5|7|8|| >> K1-30 K2-0 MIN-30
* */
public class MinTime {
    public static void main(String[] args) {
        int[] A = {3, 5, 1,7, 8, 2,5,3,10,1,4,7,5,4,6};
        int k = 3;
        int ans = findAns(A, k);
        System.out.println("Ans :"+ans);
    }

    private static int findAns(int[] arr, int k) {
        int start = findMax(arr);
        int end = findSum(arr);
        int ans = end;
        while (start<=end){
            int mid = start + (end - start) /2;
            boolean isFeasible = checkFeasibility(arr, mid, k);
            if (isFeasible){
                ans = Math.min(mid, ans);
                end = mid-1;
            }else {
                start = mid +1;
            }
        }
        return ans;
    }

    private static boolean checkFeasibility(int[] arr, int mid, int eng) {
        int sum = 0;
        int k = 1;
        int value = mid;
        for (int i = 0; i<arr.length; i++) {
            sum += arr[i];
            if (sum > value && k <= eng) {
                value = sum - arr[i] + mid;
                k++;
            }

        }
        return k <= eng;
    }

    private static int findSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i<arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

}

