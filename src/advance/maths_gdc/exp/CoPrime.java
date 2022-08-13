package advance.maths_gdc.exp;

/*
* Given an array, return true if there exist a subsequence with gcd 1.
* */
public class CoPrime {

    public static void main(String[] args) {
        int[] A = {4, 2, 6, 8};

        System.out.println(coprime(A));
    }

    public static boolean coprime(int[] arr) {
        int N = arr.length;
        int gcd = 0;
        for (int i : arr){
            gcd = GCD.gcd3(gcd, i);
            if (gcd == 1)
                return true;
        }
        return false;
    }
}
