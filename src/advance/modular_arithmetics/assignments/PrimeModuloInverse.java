package advance.modular_arithmetics.assignments;

public class PrimeModuloInverse {
    public static void main(String[] args) {
        int A = 68794;
        int B = 999996227;
        System.out.println(solve(A, B));
    }
    public static int solve(int A, int B) {
        int res = 1;
        while (true) {
            if ((A * res) % B == 1) {
                return res;
            }
            res++;
        }
    }
}
