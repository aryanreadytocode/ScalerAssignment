package advance.hashing2.exp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountRightTriangles {

    public static void main(String[] args) {
//        int[] A = {1, 1, 2};
        int[] A = {1, 1, 2, 3, 3};
//        int[] B = {1, 2, 1};
        int[] B = {1, 2, 1, 2, 1};
        int triangles = solve(A, B);
        System.out.println("triangles: "+triangles);
    }

    public static int solve(int[] A, int[] B) {
        int mod = 1000000007;
        int noOfTriangle = 0;
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();
        for (int i = 0; i<A.length; i++) {
            int freqX = mapX.get(A[i])==null?0:mapX.get(A[i]);
            int freqY = mapY.get(B[i])==null?0:mapY.get(B[i]);
            mapX.put(A[i],++freqX);
            mapY.put(B[i],++freqY);
        }
        int setX = 0;
        int setY = 0;
        for (int i = 0; i<A.length; i++) {
            setX = mapX.get(A[i]);
            setY = mapY.get(B[i]);
            noOfTriangle += (((setX-1)%mod) * ((setY-1)%mod))%mod;
        }
        return noOfTriangle;
    }
}
