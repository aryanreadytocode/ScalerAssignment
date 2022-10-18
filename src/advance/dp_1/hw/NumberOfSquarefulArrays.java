package advance.dp_1.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberOfSquarefulArrays {

    public static void main(String[] args) {
        int[] A = {41};
        ArrayList<Integer> al = new ArrayList<>();
        for (int n : A) {
            al.add(n);
        }
        System.out.println(new NumberOfSquarefulArrays().solve(al));

    }
    int permCount;
    public int solve(ArrayList<Integer> A) {
        int index = 0;
        permCount = 0;
        sfa(index, A);
        return permCount;
    }

    private void sfa(int index, ArrayList<Integer> a) {
        // sanity check
        if (index < 0 || index >= a.size())
            return;
        // base case
        if (a.size() == 1) {
            if (checkPFS(a.get(0)))
                permCount++;
            return;
        }
        if (index == a.size()-1) {
            boolean pf = true;
            for (int i = 0; i < a.size() - 1; i++) {
                pf = checkPFS(a.get(i) + a.get(i + 1));
                if (!pf)
                    break;
            }
            if (pf)
                permCount++;
        }

            // backtrack logic
            for (int i = index; i<a.size();i++) {
                // do
                if (i != index && a.get(i).equals(a.get(index)))
                    continue;
                swap(index, i , a);

                sfa(index+1, a);

                // undo
                swap(index, i , a);
            }
    }

    private void swap(int index, int i, ArrayList<Integer> a) {
        int temp = a.get(index);
        a.set(index, a.get(i));
        a.set(i, temp);
    }

    private boolean checkPFS(int i) {
        for (int index = 1; index <= Math.sqrt(i); index++) {
            if (index * index == i)
                return true;
        }
        return false;
    }


}
