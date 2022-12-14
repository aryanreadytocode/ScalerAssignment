package advance.backtrack_1.hw;

import java.util.ArrayList;

public class NumberOfSquarefulArrays {

    public static void main(String[] args) {
        int[] A = {2226, 175, 114, 82, 39, 10, 39, 42, 102, 94, 75};
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
        int sr = (int)Math.sqrt(i);
        return ((sr * sr) == i);
    }


}
