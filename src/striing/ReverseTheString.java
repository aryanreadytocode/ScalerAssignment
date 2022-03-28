package striing;

/*
* Problem Description
You are given a string A of size N.

Return the string A after reversing the string word by word.

NOTE:

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.


Problem Constraints
1 <= N <= 3 * 105



Input Format
The only argument given is string A.



Output Format
Return the string A after reversing the string word by word.



Example Input
Input 1:
    A = "the sky is blue"
Input 2:
    A = "this is ib"


Example Output
Output 1:
    "blue is sky the"
Output 2:
    "ib is this"


Example Explanation
Explanation 1:
    We reverse the string word by word so the string becomes "the sky is blue".
Explanation 2:
    We reverse the string word by word so the string becomes "this is ib".
* */
public class ReverseTheString {

    public static void main(String[] args) {
//        String s = "crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq  hv ";
        String s = "Raj   Aryan   Yadav";
        System.out.println(new ReverseTheString().solve(s));
    }

    public StringBuilder reverse(StringBuilder s, int l, int r) {
        while (l < r) {
            char temp = s.charAt(l);
            s.setCharAt(l, s.charAt(r));
            s.setCharAt(r, temp);
            l++;
            r--;
        }
        return s;
    }

    public String solve1(String A) {
        A = A.trim();
        StringBuilder sb = new StringBuilder(A);
        int n = A.length();
        reverse(sb, 0, n - 1);
        int r = 0;
        int l = 0;
        while (r < n) {
            while (sb.charAt(r == n ? n - 1 : r) != ' ' && r < n) {
                r++;
            }
            if (l > r - 1) {
                sb = removeSpaces(sb, n, l, r);
                n = sb.length();
            }else{
                    reverse(sb, l, r - 1);
                    l = r + 1;
                    r = l;
                }
            }
            return sb.toString().trim();

        }

    private StringBuilder removeSpaces(StringBuilder sb, int n, int l, int r) {
        return new StringBuilder(sb.substring(0, r - 1) + sb.substring(r, n));
    }

    public String solve(String A) {
        char[] s = A.toCharArray();
        int start = 0;
        int end = s.length-1;

        while(start<=end && s[start]==' '){
            start++;
        }

        while(start<=end && s[end]==' '){
            end--;
        }
        reverse(s, start, end);

        int i = start;
        int j = start;
        int mark = start;

        while(j<=end){
            if(s[j]!=' '){
                s[mark]=s[j];
                mark++;
            }

            if(j== end || s[j]==' '){
                reverse(s,i,mark -1);
                if(j==end) break;
                s[mark++]=' ';
                i= mark;

                while(s[j]==' '){
                    j++;
                }
                j=j-1;
            }
            j++;
        }

        return new String(s, start, mark-start);
    }

    public void reverse(char[] s, int a, int b){

        while(a<b){
            char temp = s[a];
            s[a] =s[b];
            s[b] = temp;
            a++;
            b--;
        }
    }
}
