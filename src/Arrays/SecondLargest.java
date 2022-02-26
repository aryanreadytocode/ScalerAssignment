package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {1,3,5, -42, 8, 45, 3};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
//        list.add(3);
//        list.add(5);
//        list.add(-42);
//        list.add(8);
//        list.add(45);
//        list.add(3);
//        System.out.println("Second Largest NO: "+ secondLargestNo(arr));
        System.out.println("Second Largest NO: "+ solve(list));
    }

    public static int solve(ArrayList<Integer> A) {
        A.sort(Comparator.naturalOrder());
        if (A.size()==1 || A.isEmpty())
            return -1;
        return A.get(A.size()-2);
    }

    private static int secondLargestNo(int[] arr) {
        int secondMax = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;
        for (int i= 0; i< arr.length-1 ; i++) {
            for (int j = i+1; j<arr.length; j++) {
                int sumed = arr[i]+arr[j];
                if (sumed>sum) {
                    sum = sumed;
                    secondMax = arr[i]<arr[j]?arr[i]:arr[j];
                }
            }
        }
        return secondMax;
    }
}
