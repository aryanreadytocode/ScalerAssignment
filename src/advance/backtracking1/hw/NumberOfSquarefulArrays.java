package advance.backtracking1.hw;

public class NumberOfSquarefulArrays {

    public static void main(String[] args) {
//        int[] arr = {2,2,2};
        int[] arr = {4776};
//        int[] arr = {1, 17, 8};
        int answer = solve(arr);
        System.out.println(answer);
    }

    private static int solve(int[] arr) {
        int index = 0;
        return squareFulArray(index, 0, arr);
    }

    private static int squareFulArray(int index, int result, int[] arr) {
        // check for sanity check
        if (index < 0 || index>=arr.length)
            return result;

        // base condition
        if (index == arr.length-1) {
            // check if the current order element of array makes it square ful array
            if (checkSquareFul(arr))
                return result + 1;
        }

        // backtrack logic
        for (int i = index; i<arr.length; i++) {
            // swap the element
            if (i != index && arr[i] == arr[index])
                continue;
            swap(i, index, arr);
            result = squareFulArray(index+1, result, arr);
            swap(i, index, arr);
        }
        return result;
    }

    private static boolean checkSquareFul(int[] arr) {
        int sum, square;
        boolean checkSquareFul = true;
        if (arr.length ==1) {
            square = (int) Math.sqrt(arr[0]);
            if (square * square != arr[0])
                checkSquareFul = false;
        } else {
            for (int i = 0; i < arr.length - 1; i++) {
                sum = arr[i] + arr[i + 1];
                square = (int) Math.sqrt(sum);
                if (square * square != sum)
                    checkSquareFul = false;
            }
        }
        return checkSquareFul;
    }

    private static void swap(int start, int end, int[] arr) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
