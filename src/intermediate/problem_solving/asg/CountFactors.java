package intermediate.problem_solving.asg;

public class CountFactors {

    public static void main(String[] args) {
        int N = 64;
        System.out.println("factors of "+N+": "+countFactors1(N));
    }

    private static int countFactors(int N) {
        int factorCount = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0)
                factorCount ++;
        }
        return factorCount;
    }

    private static int countFactors1(int N) {
        int factorCount = 0;
        for (int i = 1; i*i <= N; i++) {
            if (N%i == 0) {
                if (i * i == N)
                    factorCount++;
                else
                    factorCount += 2;
            }

        }
        return factorCount;
    }
}
