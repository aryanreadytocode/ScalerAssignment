package Intermediate.ProblemSolvingBasics.exp;
/*Given a perfect square number N. find the square root of given number*/
public class Squareroot {
    public static void main(String[] args) {
        int input = 36;
//        int ans = findSquareRoot(input);
        int ans = findSquareRootBinary(input, 1, input);
        System.out.println("Square Root: "+ans);
    }

    private static int findSquareRoot(int input) {
        for (int i = 1; i <= input; i++) {
            if (i * i == input)
                return i;
        }
        return -1;
    }

    private static int findSquareRootBinary(int input, int first, int last) {
        int mid = (first+last)/2;
        while (first <= last) {
            if (mid * mid > input) {
                return findSquareRootBinary(input, first, last-1);
            }else if (mid * mid < input) {
                return findSquareRootBinary(input, first+1, last);
            }else
                return mid;
        }
        return -1;
    }
}
