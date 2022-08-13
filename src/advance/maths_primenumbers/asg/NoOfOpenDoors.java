package advance.maths_primenumbers.asg;

public class NoOfOpenDoors {

    public static void main(String[] args) {
        int A = 10;
        System.out.println(solve(A));
    }

    public static int solve(int A) {
        int[] res = new int[A+1];
        for(int i = 1; i<=A; i++) {
            res[i] = res[i] == 1?0:1;
            for (int j = i+i; j<=A; j +=i) {
                res[j] = res[j] == 1?0:1;
            }

        }
        int openDoors = 0;
        for( int j= 1; j<=A; j++) {
            if (res[j] == 1)
                openDoors++;
        }
        return openDoors;
    }
}
