package bit_manipulation1;
/*
* Problem Description

Given two binary strings, return their sum (also a binary string).
Example:

a = "100"

b = "11"
Return a + b = "111".
* */
public class AddBinaryStrings {
    public String addBinary(String A, String B) {
        int al = A.length() - 1;
        int bl = B.length() - 1;
        int rem;
        int quo = 0;
        int sum;
        StringBuilder res = new StringBuilder();
        if (al > bl) {
            while (al >= 0) {
                if (bl < 0) {
                    sum = (quo + Character.getNumericValue(A.charAt(al)));
                } else {
                    sum = (quo + Character.getNumericValue(A.charAt(al)) + Character.getNumericValue(B.charAt(bl)));
                }
                rem = sum % 2;
                quo = sum / 2;
                res.append(rem);
                if (al == 0) {
                    while (quo>0) {
                        rem = quo % 2;
                        quo /= 2;
                        res.append(rem);
                    }
                }
                al--;
                bl--;
            }
        } else {
            while (bl >= 0) {
                if (al < 0) {
                    sum = (quo + Character.getNumericValue(B.charAt(bl)));
                } else {
                    sum = (quo + Character.getNumericValue(A.charAt(al))  + Character.getNumericValue( B.charAt(bl)));
                }
                rem = sum % 2;
                quo = sum / 2;
                res.append(rem);
                if (bl == 0) {
                    while (quo>0) {
                        rem = quo % 2;
                        quo /= 2;
                        res.append(rem);
                    }
                }
                al--;
                bl--;
            }
        }

        return res.reverse().toString();
    }
}
