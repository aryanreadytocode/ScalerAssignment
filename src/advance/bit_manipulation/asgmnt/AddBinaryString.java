package advance.bit_manipulation.asgmnt;

/*Problem Description
        Given two binary strings, return their sum (also a binary string).
        Example:

        a = "100"

        b = "11"
        Return a + b = "111".*/
public class AddBinaryString {

    public static void main(String[] args) {
//        System.out.println(addBinary("10001100010111000101100010100110001001101010000010011010", "101111000100100100111110010010101110101001100100101001111010011000000110"));
//        System.out.println(addBinary("1011", "11"));
        System.out.println(addBinary("1010110111001101101000", "1000011011000000111100110"));
    }


    public static String addBinary(String A, String B) {
        //convert to decimal and add
        int size1 = A.length();
        int size2 = B.length();
        int maxL = Math.max(size1, size2);
        int cf = 0;
        StringBuilder finalStr = new StringBuilder();
        for (int i = 0; i < maxL; i++) {
            int A1 = 0;
            int B1 = 0;
            if (i < size1)
                A1 = Integer.parseInt(String.valueOf(A.charAt(size1 - 1 - i)));
            if (i < size2)
                B1 = Integer.parseInt(String.valueOf(B.charAt(size2 - 1 - i)));

            long sum = A1 + B1 + cf;
            finalStr.append(sum % 2);
            if (sum > 1) {
                cf = (int) (sum / 2);
            } else
                cf = 0;

            if (i==maxL-1 && cf>0)
                finalStr.append(cf);
        }

        return finalStr.reverse().toString();
    }
}
