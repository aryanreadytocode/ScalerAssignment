package advance.maths_primenumbers.asg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FactorialArray1 {

    public static void main(String[] args) {
        int[] arr = {2,3,2,3,4,5,7,9};
//        int[] arr = {251, 923, 561, 230, 100, 399, 542, 198, 548, 892, 721, 781, 174, 809, 9, 232, 165, 861, 36, 837, 377, 313, 475, 269, 210, 530, 940, 570, 24, 434, 764, 275, 709, 325, 505, 161, 724, 47, 359, 625, 291, 81, 406, 465, 242, 767, 698, 408, 629, 86, 597, 358, 399, 72, 979, 962, 603, 919, 884, 627, 353, 1, 254, 414, 678, 111, 575, 755, 511, 287, 380, 802, 720, 138, 620, 314, 905, 670, 74, 886, 756, 671, 244, 508, 744, 224, 822, 347, 495, 706, 326, 201, 707, 580, 615, 386, 43, 543, 141, 554};
        System.out.println(new FactorialArray1().solve(arr));
    }

    public int solve(int[] A) {

        Arrays.sort(A);
        //System.out.println(A);
        int n = A.length;
        int mod = 1000000007;
        int max = A[A.length-1];
        //check isPrime with the help of seive algorithm
        boolean[] isPrime = new boolean[max+1];
        for(int i = 2;i*i<=max;i++){
            if(!isPrime[i]){
                for(int j = i*i;j<=max;j=j+i){
                    isPrime[j] = true;
                }
            }
        }
        //Find primenumberscount in Factorial of element
        //for each each prime number : count of values greater than this prime
        // and less than next prime (increase count till next prime exist)
        //eg: 13!, 14!, 15! 16! will have set of primes until it reaches next greater prime
        //so sorting helpes here
        int[] isPrimeCount = new int[max+1];
        for(int i =2;i<=max;i++){
            if(!isPrime[i]){
                isPrimeCount[i] = isPrimeCount[i-1]+1;
            }else{
                isPrimeCount[i] = isPrimeCount[i-1];
            }
        }
        int count = 1;
        if(A[0]<2){
            count =0;
        }
        long sum =0;
        for(int i=0;i<n-1;i++){
            if(isPrimeCount[A[i]] == isPrimeCount[A[i+1]]){
                count++;
            }else{
                sum = (sum + (1<<count) -1)%mod;
                count = 1;
            }
        }
        sum = (sum + (1<<count) -1)%mod;
        return (int)sum;
    }
}
