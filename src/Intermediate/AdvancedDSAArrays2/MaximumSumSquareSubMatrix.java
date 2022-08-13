package Intermediate.AdvancedDSAArrays2;

public class MaximumSumSquareSubMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, -6}, {7, -8, -9}};
        int B = 1;
        System.out.println(new MaximumSumSquareSubMatrix().solve(arr, B));
    }

    public int solve(int[][] A, int B) {
        int maxsum=Integer.MIN_VALUE;
        int[][]pf= getPrefixSumMatrix(A);
        int i;
        for(i=1;i<pf.length;i++){
            int sum=Integer.MIN_VALUE;
            for(int j=1;j<pf[0].length;j++){
                if((i-B)>=0 && (j-B)>=0){
                    sum=pf[i][j]-pf[i-B][j]-pf[i][j-B]+pf[i-B][j-B];
                    maxsum=Math.max(sum,maxsum);
                }
            }
        }
        return maxsum;
    }

    static int[][] getPrefixSumMatrix(int[][] A){
        int N=A.length;
        int M=A[0].length;
        int[][] psa=new int[N+1][M+1];
        for(int i=1;i<psa.length;i++){
            for(int j=1;j<psa[0].length;j++){
                psa[i][j]= A[i-1][j-1]+psa[i-1][j]+psa[i][j-1]-psa[i-1][j-1] ;
            }
        }
        return psa;
    }
}
