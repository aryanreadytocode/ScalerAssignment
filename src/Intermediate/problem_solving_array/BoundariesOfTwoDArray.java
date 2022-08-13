package Intermediate.problem_solving_array;
/*
* Print all the boundaries of array [N][N] in clockwise direction
* */
public class BoundariesOfTwoDArray {

    public static void main(String[] args) {
        int[][] A = {{1,6,11,16,21,26},{2,7,12,17,22,27},{3,8,13,18,23,28},{4,9,14,19,24,29},{5,10,15,20,25,30},{31,32,33,34,35,36}};
        printBoundaries(A);
    }

    public static void printBoundaries(int[][] A) {
        int N = A[0].length;
        int i = 0, j= 0;
        while (N>=1) {
            for (int k = 1; k<=N-1; k++){
                System.out.print(A[i][j]+", ");
                j++;
            }for (int k = 1; k<=N-1; k++){
                System.out.print(A[i][j]+", ");
                i++;
            }for (int k = 1; k<=N-1; k++){
                System.out.print(A[i][j]+", ");
                j--;
            }for (int k = 1; k<=N-1; k++){
                System.out.print(A[i][j]+", ");
                i--;
            }
            System.out.println();
            N -=2;
            i++;
            j++;
            if (N==1)
                System.out.print(A[i][j]);
        }
    }
}
