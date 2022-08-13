package advance.binarysearch1.exp;

/*Binary Search
 * Divide the array sorted (asc) from mid where mid = (start+end)/2
 * And the value you want to search compare with the element present at mid
 * - if the mid-element is less than the value to search reject left part and continue with right
 * - if the mid-element is greater than the value to search reject right part and continue with left part*/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 8, 9, 13};
        System.out.println(binarySearchIteratively(arr, 1, 0, arr.length - 1));
    }

    public static boolean binarySearchIteratively(int[] arr, int value, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == value)
                return true;
            else if (arr[mid] > value) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static boolean binarySearchRecursively(int[] arr, int value, int start, int end) {
        if (start > end)
            return false;
        int mid = start + (end - start) / 2;
        if (arr[mid] == value)
            return true;
        if (start == end)
            return false;
        if (arr[mid] > value)
            return binarySearchRecursively(arr, value, start, mid - 1);
        if (arr[mid] < value)
            return binarySearchRecursively(arr, value, mid + 1, end);

        return false;
    }
}
