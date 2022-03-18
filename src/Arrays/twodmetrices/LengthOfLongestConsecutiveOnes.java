package Arrays.twodmetrices;

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
