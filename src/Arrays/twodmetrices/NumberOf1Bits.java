package Arrays.twodmetrices;

public class NumberOf1Bits {
    public static void main(String[] args) {
        int a = 11;
        System.out.println(new NumberOf1Bits().numSetBits(a));
    }
    public int numSetBits(int A) {
        int oneCount = 0;
        int rem;
        while(A>0){
            rem = A%2;
            if(rem==1)
                oneCount++;
            A /= 2;
        }
        return oneCount;
    }
}

