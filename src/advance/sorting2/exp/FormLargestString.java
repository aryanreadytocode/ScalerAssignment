package advance.sorting2.exp;

public class FormLargestString {
    public static void main(String[] args) {
        String[] arr = {"0", "910", "9", "91", "89"};
        System.out.println(new FormLargestString().largestString(arr));
    }

    public String largestString(String[] A) {

        String[] sorted = mergeSort(A, 0, A.length-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i<sorted.length; i++) {
            sb.append(sorted[i]);
        }
        return sb.toString();
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
        String lr = left+right;
        String rl = right+left;
        for (int i = 0; i<lr.length(); i++) {
            if (lr.charAt(i) > rl.charAt(i)) {
                    return true;
            }else if (lr.charAt(i) < rl.charAt(i)){
                return false;
            }
        }
        return true;
    }


}
