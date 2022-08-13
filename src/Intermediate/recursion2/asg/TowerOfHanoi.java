package Intermediate.recursion2.asg;

import java.util.Arrays;

public class TowerOfHanoi {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(towerOfHanoi(3)));
    }
    static int[][] result;
    static int move = 0;


    public static int[][] towerOfHanoi(int A) {
        int M = (1<<A) - 1;
        result = new int[M][3];

        toh(A,1,2,3);
        return result;
    }

    public static void toh(int diskSize, int source, int auxi, int des) {
        if (diskSize ==0)
            return;
        toh(diskSize-1, source, des, auxi);
        result[move++] = new int[]{diskSize, source, des};
        toh(diskSize-1, auxi, source, des);
    }
}
