package advance.sorting2.hw;

import java.util.Arrays;
import java.util.Comparator;

public class ClosetPoint {

    public static void main(String[] args) {
        int[][] A= {{1, 3}, {-2, 2}};
        int B = 1;
        System.out.println(Arrays.deepToString(new ClosetPoint().solve(A, 1)));
    }

    public int[][] solve(int[][] A, int B) {
        int result[][]=new int[B][A[0].length];
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int x=o1[0]*o1[0]+o1[1]*o1[1];  //o1={1,3} x=1*1+3*3=10;
                int y=o2[0]*o2[0]+o2[1]*o2[1];  //o2={-2,2} x=-2*-2+2*2=8;
                if(x>y){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        for(int i=0;i<B;i++){
            for(int j=0;j<A[0].length;j++){
                result[i][j]=A[i][j];
            }
        }
        return result;
    }

}
