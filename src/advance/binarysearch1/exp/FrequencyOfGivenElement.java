package advance.binarysearch1.exp;
/*Given an ascending order array. Find the frequency of K
* For Example:
* if A[] = {1,2,2,3,3,4,4,4,6,6,6,8,8}
* where k = 6*/
public class FrequencyOfGivenElement {
    public static void main(String[] args) {
        int[] intArray = {-5, -5, -5, 4, 4, 4, 4, 30, 30, 30, 30, 60, 60, 70};
        int noToFindTheFreq = -5;
        int frequencyCount = findFrequency(intArray, noToFindTheFreq);
        System.out.println("Frequency of "+noToFindTheFreq+" :"+frequencyCount);
    }

    private static int findFrequency(int[] intArray, int noToFindTheFreq) {
        int start = 0;
        int end = intArray.length-1;
        int startIndex = end;
        int endIndex = start;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (intArray[mid] > noToFindTheFreq)
                end = mid -1;
            else if (intArray[mid] < noToFindTheFreq)
                start = mid + 1;
            else {
                startIndex = Math.min(startIndex, mid);
                end = mid - 1;
            }
        }
        start = 0;
        end = intArray.length-1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (intArray[mid] > noToFindTheFreq)
                end = mid -1;
            else if (intArray[mid] < noToFindTheFreq)
                start = mid + 1;
            else {
                endIndex = Math.max(endIndex, mid);
                start = mid + 1;
            }
        }
        return (endIndex - startIndex)+1;
    }
}
