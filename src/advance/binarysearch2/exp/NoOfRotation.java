package advance.binarysearch2.exp;

public class NoOfRotation {

    public static void main(String[] args) {
        int[] rotatedArr = {50, 77, 82, 1, 5, 7, 8, 10,30};
        int noOfRotation = findRotation(rotatedArr);
        System.out.println("No of Rotation: "+noOfRotation);
    }

    public static int findRotation(int[] rotatedArr) {
        int start = 0;
        int end = rotatedArr.length-1;
        while (start<=end) {
            int mid = start + (end - start) / 2;
            if (rotatedArr[mid] > rotatedArr[mid+1])
                return mid+1;
            else if (rotatedArr[mid] < rotatedArr[mid-1])
                return mid;
            else if (rotatedArr[mid] > rotatedArr[0])
                start = mid+1;
            else if (rotatedArr[mid] < rotatedArr[0])
                end = mid - 1;
        }
        return -1;
    }
}
