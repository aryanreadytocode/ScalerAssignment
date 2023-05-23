package intermediate.problem_solving.asg;

public class SquareRoot {

    public static void main(String[] args) {
        int N = 1024;
        System.out.println("Square root of "+N+" :"+sqrt(N));
    }

    private static int sqrt(int N) {
        int sr = 1;
        for (int i = 1; i<N; i++) {
            if (i*i == N)
                sr = i;
        }
        return sr;
    }
}
