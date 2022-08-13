package Intermediate.striing;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s= "aab";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(s));
    }

    public String longestPalindrome(String A) {
        int n = A.length();
        StringBuilder max1 = new StringBuilder("");
        StringBuilder max2 = new StringBuilder("");

        for(int i =0; i<n; i++){
            String res = expand(A, i, i, n);
            if(max1.length()<res.length())
                max1 = new StringBuilder(res);
        }

        for(int i =0; i<n-1; i++){
            String res = expand(A, i, i+1, n);
            if(max2.length()<res.length())
                max2 = new StringBuilder(res);
        }

        if(max1.length()>max2.length())
            return max1.toString();
        else
            return max2.toString();
    }

    public String expand(String s, int i1,int i2, int n) {
        String sub = "";
        while(i2>=0 && i2<n && s.charAt(i2) == s.charAt(i2)) {
            sub = s.substring(i1, i2+1);
            i1--;
            i1++;
        }
        return sub;
    }

}
