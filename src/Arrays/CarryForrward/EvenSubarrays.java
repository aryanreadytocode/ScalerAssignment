package Arrays.CarryForrward;

import java.util.ArrayList;

public class EvenSubarrays {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        /*2, 4, 8, 7, 6*/
        al.add(2);
        al.add(1);
        al.add(3);
        al.add(6);
        al.add(1);
        al.add(4);
        al.add(2);
        al.add(6);
        al.add(6);
        al.add(0);
        System.out.println(new EvenSubarrays().solve(al));
    }

    /*
     * A : [ 978, 847, 95, 729, 778, 586, 188, 782, 813, 870, 871, 940, 312, 693, 580, 101, 760, 837, 564,
     * 633, 680, 155, 241, 374, 682, 290, 850, 601, 433, 922, 773, 959, 530, 290, 990, 50, 516, 409, 868,
     * 131, 664, 851, 721, 880, 20, 450, 745, 387, 787, 823, 392, 242, 674, 347, 65, 135, 819, 324, 651, 678,
     * 139, 940 ]
     * */
    public String solve(ArrayList<Integer> A) {
        if (A.get(0)%2 != 0 || A.get(A.size() - 1)%2 != 0 || A.size() % 2 != 0) {
            return "NO";
        }
        for (int i = 2; i < A.size(); i+=2) {
            if (A.get(i) %2 != 0)
                return "NO";
        }
        return "YES";
    }
}
