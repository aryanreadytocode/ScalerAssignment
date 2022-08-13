package advance.binarysearch2.exp;
/*Given an array where every no occurs twice but one number occurs only once. Find the no.*/
public class FindUniqueElement {

    public static void main(String[] args) {
        int[] arr = {3,3,2,1,1,4,4};
        int index = find(arr);
        System.out.println("index :"+index);
    }

    static int find(int[] arr) {
        int first = 0;
        int second = 0;
        int start = 0;
        int end = arr.length-1;
        while (start<=end) {
            int middle = start + (end - start)/2;
            if (arr[middle] == arr[middle+1] && middle+1<=end){
                first = middle;
                second = middle+1;
            }else if (middle-1 >= 0 && arr[middle] == arr[middle - 1]) {
                first = middle-1;
                second = middle;
            }else if (arr[middle] != arr[middle-1] && arr[middle] != arr[middle+1]) {
                return arr[middle];
            }

            if (first%2==0)
                start = second+1;
            else
                end = first-1;
        }
        return -1;
    }
}
