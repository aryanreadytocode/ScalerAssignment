package advance.bit_manipulation.exp;
/*
* Given N array elements, every elements repeats twice except 1, find unique element*/
public class UniqueElementsI {

    public static void main(String[] args) {
        int[] A = {3,4,5,4,6,5,6};
        System.out.println(uniqueElement(A));
    }

    public static int uniqueElement(int[] A) {
        int uniqueElement = A[0];
        for (int i = 1; i<A.length; i++) {
            uniqueElement ^= A[i];
        }
        return uniqueElement;
    }
}
