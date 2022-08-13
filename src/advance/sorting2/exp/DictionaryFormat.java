package advance.sorting2.exp;

import java.util.Arrays;

public class DictionaryFormat {

    public static void main(String[] args) {
        String[] arr = {"Anu", "Aryan", "Golu", "Zon", "Goluu"};
        System.out.println(Arrays.toString(new DictionaryFormat().largestString(arr)));
    }

    public String[] largestString(String[] A) {
        return mergeSort(A, 0, A.length-1);

    }

    private String[] mergeSort(String[] A, int start, int end) {
        if (start == end)
            return new String[] {A[start]};
        int middle = (start+end)/2;
        String[] left = mergeSort(A, start, middle);
        String[] right = mergeSort(A, middle+1, end);
        return merge(left, right);
    }

    private String[] merge(String[] left, String[] right) {
        int countLeft = 0;
        int countRight = 0;
        String[] resArr = new String[left.length+right.length];
        for (int i = 0; i<resArr.length; i++) {
            if (countLeft == left.length) {
                resArr[i] = right[countRight];
                countRight++;
            } else if (countRight == right.length) {
                resArr[i] = left[countLeft];
                countLeft++;
            } else if(compare(left[countLeft], right[countRight])) {
                resArr[i] = left[countLeft];
                countLeft++;
            } else {
                resArr[i] = right[countRight];
                countRight++;
            }
        }
        return resArr;
    }

    private boolean compare(String left, String right) {

        for (int i = 0; i<Math.min(left.length()-1, right.length()-1); i++) {
            if (left.charAt(i) < right.charAt(i)) {
                return true;
            }else if (left.charAt(i) > right.charAt(i)){
                return false;
            }
        }
        return left.length()<right.length();
    }
}
