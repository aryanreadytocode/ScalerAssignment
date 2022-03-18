package modular_arithmetics;

public class LeastCommonMultiple {

    public int LCM(int A, int B) {
        int min = 0, max = 0;
        if(A == B)
            return A;
        min = (Math.min(A, B));
        max = (min == A ? B : A);
        //int lcm = 0;
        for(int i = 2; i < max; i++){
            int mul = min * i;
            if(mul%max == 0)
                return mul;
        }
        return A*B;
    }
}
