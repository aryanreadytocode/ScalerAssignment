package Arrays;

import java.util.ArrayList;
import java.util.List;

public class MultipleLeftRotationOfArray {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        list2.add(2);
        list2.add(3);


        new MultipleLeftRotationOfArray().solve(list1, list2);
    }

    public void solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>> arrays = new ArrayList<>();
        for (int rotation: B){
            if (rotation>A.size())
                rotation %= A.size();
            ArrayList<Integer> arrayList = new ArrayList<>(A);
            reverseArray(arrayList, 0, A.size()-1);
            reverseArray(arrayList, 0, (A.size()-1)-rotation);
            reverseArray(arrayList, A.size()-rotation, A.size()-1);
            arrays.add(arrayList);
        }
            System.out.println(arrays);
//        return arrays;
    }

    private void reverseArray(ArrayList<Integer> list, int from, int to) {
        while (from<to){
            list.set(from, list.get(to)+list.get(from));
            list.set(to, list.get(from)-list.get(to));
            list.set(from, list.get(from)-list.get(to));
            to--;
            from++;
        }
    }
}
