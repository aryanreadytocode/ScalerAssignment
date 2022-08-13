package advance.maths_primenumbers.hw;

public class ExcelColumnTitle {

    public static void main(String[] args) {
        int s = 943566;
//        int s = 75;
        System.out.println(solve(s));
    }


    public static String solve(int N) {
        char[] alphaArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder s = new StringBuilder();
        while (N>=1) {
            int i = N%26;
            if (i == 0)
                i = 26;
            char c = alphaArray[i-1];
            s.append(c);
            N -= i;
            N /= 26;
        }
        s.reverse();
        return s.toString();
    }
}
