package advance.bit_manipulation.exp;

public class CheckBit {

    public static void main(String[] args) {
        System.out.println(checkBit(5, 0));
    }

    public static boolean checkBit(int N, int pos) {
        return  ((N>>pos) & 1) == 1;
    }
}
