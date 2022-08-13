package Intermediate.StackAndQueues;

import java.util.ArrayList;
import java.util.Collections;

/*
* Problem Description

Little Ponny has been given a string A, and he wants to find out the lexicographically minimum subsequence from it of size >= 2. Can you help him?

A string a is lexicographically smaller than string b, if the first different letter in a and b is smaller in a. For example, "abc" is lexicographically smaller than "acc" because the first different letter is 'b' and 'c' which is smaller in "abc".





Problem Constraints

1 <= |A| <= 105

A only contains lowercase alphabets.



Input Format

The first and the only argument of input contains the string, A.



Output Format

Return a string representing the answer.



Example Input

Input 1:

 A = "abcdsfhjagj"
Input 2:

 A = "ksdjgha"


Example Output

Output 1:

 "aa"
Output 2:

 "da"


Example Explanation

Explanation 1:

 "aa" is the lexicographically minimum subsequence from A.
Explanation 2:

 "da" is the lexicographically minimum subsequence from A.
* */
public class LittlePonnyAnd2Subsequence {

    public static void main(String[] args) {
//        String A = "zxdfoxxxzsszzshhhxhhdxxodhodffxxxxshhozzofhzhdhfoddohzofdsxhddszhhofdxdsfsdszsdxzzfodzoshsdxdsfssoxsofxhszzfffozsfzxzxhsdsxdzoosdofoxdzxhozfdzfhofzhddzfsdfzhxoxohxddhxfxhszfhdsfhfxzzhozxdoshzsfszshdfxsfffxfsososxoshxszzzdzxzdhdxxosfxzxodhdhhsoxoxfxfsdxhzfzhozxzxfhdsofxzffhzzdzdsoxhfzxzzofdfffohzdfszhdhhzdzhzoooxxfhfshofddhxdhfzfhozsfzsszodzzfdfssdxxfxoszzfxdsfzxzofsofosxhsohohszxxodfhhsozshxzsfzdddhhdhfxhfszohdozzosfozxxzoxoxdshxxfsszzodfzdsohfzodzoxoosdhosfxhsxxhzozddffhdodfosdzdxxdfdxhsdszszdofzfdoszzffdshdsxsdsfosoxdzdzzfxxdhdzxzdozhsdzofhfszxoxhzhhhzzfoxsc";
        String A = "cba";
        System.out.println(new LittlePonnyAnd2Subsequence().solve(A));
    }
    public String solve(String A) {
        ArrayList<Integer> al = new ArrayList<>();
        Collections.sort(al);
        char min = 'x';
        char max = 'z';
        for (int i = 0; i<A.length(); i++) {
            char ch = A.charAt(i);
            if (ch < min && i != A.length()-1){
                min = ch;
            }else if (ch < max && i!= 0) {
                max = ch;
            }
        }
        return String.valueOf(min) + max;
    }
    public String solve1(String A) {
        char[] charArray = A.toCharArray();
        int length = charArray.length;
        String min = "";
        for(int i = 3; i< Math.pow(2, length); i++) {
            String s = "";
            int count = 0;
            for (int j = 0; (j<length && j<=i); j++) {
                if (count == 2)
                    break;;
                if(checkBit(i, j)) {
                    s += charArray[j];
                    count++;
                }
            }
            if (s.length()>=2) {
                if(min.isEmpty())
                    min = s;
                else {
                    if(s.compareTo(min) < 0){
                        min = s;
                    }
                }
            }
        }
        return min;
    }
    int count = 0;
    public boolean checkBit(int i, int j) {
        System.out.println(++count);
        return ((i & (1<<j)) > 0);
    }
}
