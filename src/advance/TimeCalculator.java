package advance;

import java.time.Duration;
import java.time.Instant;

public class TimeCalculator {
    public static void main(String[] args) {
        int A = 39;
        System.out.println(new TimeCalculator().solve(A));
    }
    static Instant start;
    public static void getCurrentTime(){
         start = Instant.now();
    }

    int ans;
    int mod = 1000000007;
    public int solve(int A) {
        ans = pow(3, A-2);
        System.out.println("ans:"+ans);
        ans = (ans * A) % mod;
        System.out.println("ans:"+ans);
        return ((ans * (A - 1)) % mod);
    }

    private int pow(int a, int b) {
        int res = 1;
        while (b>0) {
            if (b % 2 != 0) {
                res = ((res * a) % mod);
                System.out.println("res:"+res);
                b--;
            }else {
                a = ((a * a) % mod);
                System.out.println("a:"+a);
                b = b / 2;
            }
        }
        System.out.println("res:"+res);
        return  res % mod;
    }

    public static void printDuration() {
       /*def powe(a, b):
    res = 1
    while(b):
        if(b % 2):
            res = (res * a) % mod
            b -= 1
        else:
            a = (a * a) % mod
            b = b // 2
    return res % mod
class Solution:
    # @param A : integer
    # @return an integer
    def solve(self, A):
        ans = powe(3, A - 2)
        ans = (ans * A) % mod
        return int((ans * (A - 1)) % mod)*/
    }
}
