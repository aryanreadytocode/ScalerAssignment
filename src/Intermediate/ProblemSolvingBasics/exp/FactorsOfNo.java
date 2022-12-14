package Intermediate.ProblemSolvingBasics.exp;
/*Given a number N, count all the factors of N
* Exp- 24 >> 1,2,3,4,6,8,12,24>> 8 Ans*/
public class FactorsOfNo {
    public static void main(String[] args) {
        int input = 36;
        int ans = countFactors(input);
        System.out.println("Factor Count: "+ans);
    }

    private static int countFactors(int input) {
        int count = 0;
        for (int i = 1; i*i<=input; i++) {
            if (input % i == 0) {
                if (i*i == input)
                    count += 1;
                else
                    count += 2;
            }
        }
        return count;
    }
}
