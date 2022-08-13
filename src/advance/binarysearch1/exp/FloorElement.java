package advance.binarysearch1.exp;

public class FloorElement {

    public static void main(String[] args) {
        int[] intArray = {-5, 2, 3, 6, 9, 10, 11, 14, 18};
        int valueToFind = 12;
        int floorValue = floor(intArray, valueToFind);
        System.out.println("Floor Value: "+floorValue);
    }

    public static int floor(int[] arr, int value) {
        int floor = arr[0];
        int start = 0;
        int end = arr.length;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] == value)
                return value;
            else if (arr[mid] > value)
                end = mid - 1;
            else {
                floor = Math.max(arr[mid], floor);
                start = mid + 1;
            }
        }
        return floor;

    }
}
