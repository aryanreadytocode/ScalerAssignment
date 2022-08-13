package advance.bit_manipulation.home_work;

public class DivideIntegers {

    public static void main(String[] args) {
        System.out.println(divide(5, 1));
    }

    public static int divide(int A, int B) {
        long AA = A;
        long BB = B;
        if (AA < 0 && BB < 0) {
            AA = AA * -1;
            BB = BB * -1;
        }
        if (AA == 0) {
            return 0;
        }
        if (BB == 1) {
            if (AA >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return A;
        }
        if (AA < 0) {
            AA = AA * -1;
        } else if (BB < 0) {
            BB = BB * -1;
        }
        int count = 0;
        while (AA >= BB) {
            count++;
            AA = AA - BB;
        }
        if ((A < 0 && B > 0) || (A > 0 && B < 0)) {
            count = count * -1;
        }
        return count;
    }


}
