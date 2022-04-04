package hashing1;

import java.util.ArrayList;
import java.util.HashMap;

public class SubArrayWith0Sum {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        System.out.println(new SubArrayWith0Sum().solve(al));
    }

    public int solve(ArrayList<Integer> A) {
        long sum = 0;
        int ans = -1;
        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put(0L, -1);
        for (int i = 0; i<A.size(); i++){
            sum += A.get(i);
            if(hm.containsKey(sum))
                ans = Math.max(ans, i- hm.get(sum));
            else
                hm.put(sum, i);
        }
        return ans>=0?1:0;
    }
}
