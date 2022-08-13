package advance.sorting3.hw;

import java.util.Arrays;

public class SumTheDifferences {

    public static void main(String[] args) {
        int[] A = { 7, 8, 6, 4, 6, 7, 3, 10, 2, 3, 8, 1, 10, 4, 7, 1, 7, 3, 7, 2, 9, 8, 10, 3, 1, 3, 4, 8, 6, 10, 3, 3, 9, 10, 8, 4, 7, 2, 3, 10, 4, 2, 10, 5, 8, 9, 5, 6, 1, 4, 7, 2, 1, 7, 4, 3, 1, 7, 2, 6, 6, 5, 8, 7, 6, 7, 10, 4, 8, 5, 6, 3, 6, 5, 8, 5, 5, 4, 1, 8, 9, 7, 9, 9, 5, 4, 2, 5, 10, 3, 1, 7, 9, 10, 3, 7, 7, 5, 10, 6, 1, 5, 9, 8, 2, 8, 3, 8, 3, 3, 7, 2, 1, 7, 2, 6, 10, 5, 10, 1, 10, 2, 8, 8, 2, 2, 6, 10, 8, 8, 7, 8, 4, 7, 6, 7, 4, 10, 5, 9, 2, 3, 10, 4, 10, 1, 9, 9, 6, 1, 10, 7, 4, 9, 6, 7, 2, 2, 6, 10, 9, 5, 9, 2, 1, 4, 1, 5, 5, 5, 5, 8, 7, 4, 2, 8, 6, 10, 7, 3, 2, 8, 9, 6, 8, 5, 2, 9, 6, 10, 8, 6, 4, 9, 9, 4, 2, 9, 10, 7, 5, 4, 4, 4, 9, 7, 1, 5, 9, 9, 9, 10, 8, 8, 7, 5, 4, 1, 4, 1, 10, 3, 6, 5, 1, 6, 10, 5, 7, 10, 3, 3, 5, 8, 8, 6, 5, 9, 2, 3, 9, 10, 4, 7, 9, 1, 3, 2, 1, 6, 2, 2, 1, 9, 6, 1, 7, 5, 7, 3, 6, 9, 7, 3, 9, 5, 8, 3, 5, 1, 7, 3, 10, 10, 1, 9, 2, 4, 2, 2, 1, 4, 5, 1, 4, 10, 2, 10, 7, 10, 4, 4, 9, 1, 6, 7, 7, 5, 1, 1, 5, 7, 3, 7, 8, 6, 7, 10, 9, 8, 3, 9, 3, 10, 10, 7, 1, 3, 8, 7, 2, 4, 3, 2, 6, 10, 10, 2, 5, 10, 2, 1, 8, 6, 9, 8, 1, 5, 9, 1, 5, 3, 10, 7, 2, 1, 5, 3, 3, 3, 1, 6, 6, 3, 10, 1, 3, 9, 4, 9, 1, 5, 1, 10, 2, 10, 7, 3, 6, 5, 5, 10, 10, 4, 7, 1, 6, 1, 3, 10, 5, 4, 6, 2, 8, 5, 4, 2, 5, 7, 10, 5, 3, 3, 7, 5, 2, 3, 9, 9, 10, 3, 9, 9, 9, 7, 9, 4, 9, 4, 4, 4, 9, 1, 5, 8, 7, 9, 10, 1, 7, 9, 8, 10, 1, 4, 4, 4, 8, 4, 3, 7, 6, 3, 7, 6, 9, 8, 10, 7, 1, 5, 2, 1, 5, 9, 8, 1, 9, 7, 3, 5, 8, 10, 4, 10, 3, 9, 4, 1, 2, 8, 9, 10, 2, 6, 5, 10, 3, 6, 8, 5, 10, 10, 5, 6, 10, 4, 6, 8, 1, 9, 2, 10, 10, 8, 9, 3, 6, 4, 5, 10, 1, 3, 1, 2, 10, 7, 3, 2, 3, 1, 8, 4, 2, 2, 10, 1, 6, 7, 8, 8, 5, 1, 7, 5, 8, 5, 9, 6, 9, 3, 7, 1, 7, 7, 5, 7, 3, 9, 10, 7, 1, 8, 1, 2, 1, 2, 4, 8, 8, 3, 7, 5, 6, 3, 1, 3, 10, 1, 10, 10, 5, 6, 2, 1, 4, 8, 9, 9, 7, 1, 5, 7, 8, 7, 1, 10, 8, 6, 10, 8, 9, 6, 4, 4, 9, 4, 8, 10, 4, 8, 9, 8, 5, 2, 10, 1, 10, 9, 9, 6, 9, 5, 4, 8, 2, 4, 9, 1, 10, 8, 10, 10, 4, 3, 5, 4, 8, 2, 3, 3, 1, 3, 2, 8, 6, 2, 8, 5, 2, 8, 2, 2, 2, 8, 1, 5, 1, 9, 6, 2, 7, 7, 3, 2, 10, 7, 5, 9, 1, 9, 2, 1, 3, 3, 10, 8, 6, 7, 5, 7, 4, 8, 10, 8, 5, 10, 2, 8, 1, 7, 1, 9, 6, 4, 10, 5, 2, 6, 5, 2, 6, 6, 5, 10, 9, 4, 9, 6, 3, 3, 3, 8, 1, 4, 5, 7, 4, 7, 4, 4, 5, 5, 4, 10, 8, 3, 6, 9, 10, 1, 3, 5, 8, 7, 6, 8, 2, 4, 4, 4, 9, 6, 2, 1, 9, 8, 7, 4, 6, 1, 9, 1, 5, 2, 2, 4, 6, 10, 4, 5, 2, 6, 1, 9, 4, 6, 7, 6, 10, 10, 1, 8, 7, 4, 8, 7, 2, 6, 1, 7, 6, 1, 9, 2, 3, 3, 7, 10, 2, 1, 5, 3, 8, 5, 1, 4, 3, 9, 1, 4, 8, 1, 1, 4, 5, 10, 3, 8, 5, 3, 6, 3, 5, 5, 4, 9, 7, 1, 9, 10, 3, 3, 4, 2, 9, 4, 5, 3, 3, 5, 6, 2, 8, 6, 8, 2, 7, 10, 9, 2, 4, 4, 4, 8, 10, 9, 7, 8, 1, 5, 9, 5, 9, 2, 7, 9, 6, 3, 2, 10, 10, 7, 1, 7, 5, 10, 10, 1, 9, 10, 4, 2, 5, 9, 10, 7, 8, 8, 4, 8, 2, 3, 3, 2, 6, 1, 10, 1, 5, 1, 2, 4, 8, 5, 2, 2, 4, 1, 4, 3, 2, 8, 6, 7, 6, 5, 3, 3, 2, 8, 3 };
//        int[] A = { 2,4,5};
        System.out.println(solve(A));
    }

    private static int solve(int[] A){
        int mod=1000000007;
        Arrays.sort(A);
        int n=A.length;
        long max = 0;
        long min = 0;
        for(int i=0 ; i<n ; i++){
            // number * no of subsequences the number exists in
            max = ((max+(long)A[n-i-1] * pow(2, n-i-1, mod))%mod); //total max calculation
            min = ((min+ (long)A[i] * pow(2, n-i-1, mod))%mod);  //total min calculation
        }
        return (int)(max-min+mod)%mod;  // (a-b)%m = (a%m - b%m + m)%m
    }

    static long pow(int n, int p, int mod){

        if(p==0) return 1;
        if(p==1) return n;
        long pow=1;

        pow=(pow%mod * pow(n, p/2, mod))%mod;
        pow=(pow%mod * pow%mod)%mod;
        if(p%2==1){
            pow=(n%mod * pow%mod)%mod;
        }
        return pow;

    }


    private static int power(int N, int exp, int mod) {
        if (exp == 0)
            return 0;
        if (exp == 1)
            return N;

        long halfPower = power(N, exp/2, mod);
        if (exp%2==0)
            return (int) (((halfPower%mod) *(halfPower%mod))%mod);
        else
            return (int) (((halfPower%mod) * N%mod)%mod);
    }

    public static int pow1(int A, int B, int C) {
        long product;
        if(A==1)
            return 1;
        else if(A==0)
            return 0;
        else if(B == 0)
            return 1;

        long halfValue = pow(A, B/2, C);
        if(B%2 ==0) {
            product = ((halfValue%C)*(halfValue%C))%C;
        }else {
            product =  (((A%C) * (halfValue % C))%C * (halfValue % C)) % C;
            if(product<0)
                product += C;
        }
        return (int)(product);
    }
}
