package advance.combinator.asg;

public class ComputeNCR {
    public long factorial(int A, int B) {
        if (A == 0) return 1;
        long facto = 1;
        for (int i = 1; i <= A; i++) {
            facto = (facto * i) % B;
        }
        return facto % B;
    }

    public long fastexpo(long A, int B, int M) {
        if (B == 0) {
            return 1;
        }
        long p = fastexpo(A, B / 2, M);

        long l = (p % M * p % M) % M;
        if ((B & 1) == 0) {
            return l;
        }

        return (l % M * A % M) % M;

    }

    public int solve(int A, int B, int C) {
        long factN = factorial(A, C);
        long factNR = factorial(A - B, C);
        long factR = factorial(B, C);
        int pow = C - 2;
        long right = ((factNR) % C * (factR) % C) % C;
        long expo = fastexpo(right, pow, C);

        return (int) ((factN % C) * (expo % C) % C);


    }
}
