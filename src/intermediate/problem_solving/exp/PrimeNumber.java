package intermediate.problem_solving.exp;

public class PrimeNumber {

    public static void main(String[] args) {
        int N = 13;
        System.out.println(primeNo(N));
    }

    private static boolean primeNo(int N) {
        if (N == 2 || N==3)
            return false;
        for (int i = 2; i*i <= N; i++) {
            if ( N%i == 0)
                return false;
        }
        return true;
    }
}
