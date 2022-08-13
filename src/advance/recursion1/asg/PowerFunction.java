package advance.recursion1.asg;

public class PowerFunction {

    public static void main(String[] args) {
//        System.out.println(pow(-2, 3, 7));
//        System.out.println(pow(29220549, 93536687, 11236043));
        System.out.println(pow(71045970, 41535484, 64735492));
    }

    public static int pow(int A, int B, int C) {
        long product;

        if(A == 0)
            return 0;
        if (A == 1)
            return A;
        if (B == 0)
            return 1;

        long halfValue = pow(A, B/2, C);
        if (B%2 == 0) {
            product = ((halfValue%C)*(halfValue%C)) % C;
        }else {
            product = (((A%C)*(halfValue%C))%C*(halfValue%C)) % C;
            while (product < 0)
                product += C;
        }
        return (int) product;
    }
}
