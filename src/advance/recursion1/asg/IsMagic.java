package advance.recursion1.asg;

public class IsMagic {

    public static void main(String[] args) {
        int A = 83557;
        System.out.println(solve(A));
    }

    static int solve(int A) {
        int sum = findSum(A);
        if (sum>9)
            sum = solve(sum);

        if (sum == 1)
            return 1;
        else
            return 0;
    }

    private static int findSum(int A) {
        if (A == 0)
            return A;

        return A%10 + findSum(A/10);
    }
}
