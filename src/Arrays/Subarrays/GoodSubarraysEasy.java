package Arrays.Subarrays;

import java.util.ArrayList;

public class GoodSubarraysEasy {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        System.out.println(new GoodSubarraysEasy().solve(al, 4));
    }

    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        for (int i = 0; i< A.size(); i++){
            int sum = 0;
            for (int j = i; j<A.size(); j++) {
                sum += A.get(j);

                if (sum<B && (j-i+1)%2==0)
                  count++;

                if (sum>B && (j-i+1)%2!=0)
                    count++;

            }
        }
        return count;
    }
}
