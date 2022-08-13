package advance.maths_primenumbers.hw;

public class LuckyNumber {

    public static void main(String[] args) {
        int A = 50000;
        System.out.println(solve(A));
    }

    public static int solve(int A) {
        int[] spf = buildSpf(A); //[0,0,2,3,2,5,2,7,2]
        int ans = 0;

        for (int k1 = 2; k1 <= A; k1++) {
            int k = k1;
            int count = 0;
            while (k>1) { // 2
                count++;  // 1
                int pf = spf[k]; // 2
                while(k%pf==0) { // 0
                    k /= pf; // 1
                }
            }
            if(count == 2)
                ans++;
        }
        return ans;
    }

    public static int[] buildSpf(int A) { //8
        int[] spf = new int[A+1];  //[0,0,0,0,0,0,0,0,0]
        for (int i =2; i<=A; i++) {
            if (spf[i] == 0) { // 2
                spf[i] = i;   // [0,0,2,3,2,5,2,7,2]
                if ((i*i) > A || i*i <0) {
                    continue;
                }
                for (int j = i*i; j<=A; j +=i) {
                    if (spf[j] == 0)
                        spf[j] = i; // [0,0,2,0,2,0,2,0,2]
                }
            }
        }
        return spf;
    }
}
