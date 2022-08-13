package advance.maths_gdc.exp;

public class GCD {

    public static void main(String[] args) {
        int a = 60, b= 200;
        System.out.println(gcd4(a, b));
    }

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        int min = Math.min(a, b);
        int gcd = 1;
        if (a == 0 || b == 0)
            return Math.max(a,b);

        for (int i = min; i>=1; i--) {
            if(a%i == 0 && b%i==0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    public static int gcd1(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        int min = Math.min(a, b);
        if (a == 0 || b == 0)
            return Math.max(a,b);
        int gcd = 1;
        for (int i = 1; i*i <min; i++) {
            int i1 = min/i;
            if(a%i1 == 0 && b%i1==0) {
                gcd = Math.max(gcd, i1);
                break;
            }

        }
        return gcd;
    }

    public static int gcd3(int a, int b) {
        if (a == 0 || b ==0)
            return Math.max(a, b);
        if (a>b) {
            int temp = a;
            a = b;
            b = temp;
        }
//        return gcd3(a, b-a);
        return gcd3(a, b%a);
    }

    public static int gcd4(int a, int b) {
        if (a == 0 || b ==0)
            return Math.max(a, b);

        return gcd3(b%a, a);
    }

    private static void swap(int a, int b) { //10, 20
        a = a+b;
        b = a-b;
        a = a-b;
    }
}
