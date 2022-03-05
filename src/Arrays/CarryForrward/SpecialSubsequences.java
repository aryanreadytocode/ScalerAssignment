package Arrays.CarryForrward;

public class SpecialSubsequences {

    public static void main(String[] args) {

    }

    public int solve(String A) {
        int aCount = 0;
        int result = 0;
        for(int i = 0; i< A.length(); i++){
            if ('A' == A.charAt(i)){
                aCount++;
            }
            if ('G' == A.charAt(i))
                result += aCount;
        }
        return result;
    }

}
