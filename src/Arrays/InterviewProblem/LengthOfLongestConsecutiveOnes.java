package Arrays.InterviewProblem;
/*
* Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.


Input Format

The only argument given is string A.
Output Format

Return the length of the longest consecutive 1’s that can be achieved.
Constraints

1 <= length of string <= 1000000
A contains only characters 0 and 1.
For Example

Input 1:
    A = "111000"
Output 1:
    3

Input 2:
    A = "111011101"
Output 2:
    7
* */
public class LengthOfLongestConsecutiveOnes {
    public static void main(String[] args) {
       String A =  "010100110101";
       System.out.println(new LengthOfLongestConsecutiveOnes().solve(A));
    }
    public int solve(String A) {
        //get the total number of count
        int onesCount = 0;
        boolean zeroFound = false;
        int maxCount = 0;
        for(int i = 0; i<A.length(); i++){
            if(A.charAt(i) == '1')
                onesCount++;
        }
        int l = 0;
        int r = 0;
        StringBuilder sb = new StringBuilder();
        String s = "kjfk";
        int i = s.charAt(0);

        for(int j = 0; j<A.length(); j++){
            l = 0;
            r = 0;
            if(A.charAt(j) == '0'){
                zeroFound = true;
                for(int k = j-1; k>=0; k--){
                    if(A.charAt(k)=='1')
                        l++;
                    else
                        break;
                }

                for(int q = j+1; q<A.length(); q++){
                    if(A.charAt(q)=='1')
                        r++;
                    else
                        break;
                }
                maxCount = Math.max(maxCount, (l+r));
            }
        }
        if(zeroFound){
            if(maxCount+1<=onesCount){
                return maxCount+1;
            }else{
                return maxCount;
            }
        }else
            return A.length();
    }
}
