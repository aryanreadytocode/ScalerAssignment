package HLD.Popular_Interview_Question;

import java.util.Arrays;
import java.util.HashMap;

public class RateLimiter {

    public static void main(String[] args) {
        int[]  A = {181,181,859,245,181,859,859,700,181,859,859,700,181,700,245,
                859,859,470,470,181,245,700,859,700,700,181,859,181,470,470,859,
                700,859,181,245,470,245,470,700,859,181,470,470,700,470,859,245,
                859,245,245,470,181,700,245,859,181,245};

        int[] B = {2,4,5,5,6,8,10,12,12,14,15,17,18,18,20,20,21,21,21,21,21,23,
                24,24,25,26,27,28,30,31,32,34,34,35,37,38,39,41,41,41,42,44,45,
                47,49,50,52,52,54,55,55,57,57,58,58,59,61};

        System.out.println(Arrays.toString(new RateLimiter().solve(A, B)));
    }

    public int[] solve(int[] A, int[] B) {
        int clientId;
        int timeStamp;
        int[] ans = new int[A.length];
        HashMap<Integer, Integer> clientStartTimeMap = new HashMap<>();
        HashMap<Integer, Integer> ClientNoOfReqMap = new HashMap<>();
        for(int i = 0; i< A.length; i++) {
            clientId = A[i];
            timeStamp = B[i];
            // check if clientId present in HashMap
            // if present update the noOfReq
            // else add new client with noOfREq and firstCall timeStamp
            if(clientStartTimeMap.containsKey(clientId)) {
                //check the time interval
                // if time interval is less or equal to 10 xde-q
                // update frequency
                // else remove client clientId
                int timeInterval = timeStamp - clientStartTimeMap.get(clientId);
                // check for frequency
                // if less than 3 update value
                // else no change
                int existingFrq = ClientNoOfReqMap.get(clientId);
                if(timeInterval <= 10) {
                    if(existingFrq <3) {
                        ans[i] = 1;
                        ClientNoOfReqMap.put(clientId, ++existingFrq);
                        System.out.println(Arrays.toString(ans));
                    }else {
                        ans[i] = 0;
                        System.out.println(Arrays.toString(ans));
                    }
                }else {
                    ans[i] = 1;
                    ClientNoOfReqMap.put(clientId, 1);
                    clientStartTimeMap.put(clientId, timeStamp);
                    System.out.println(Arrays.toString(ans));
                }
            }else {
                ans[i] = 1;
                clientStartTimeMap.put(clientId, timeStamp);
                ClientNoOfReqMap.put(clientId, 1);
                System.out.println(Arrays.toString(ans));
            }
        }
        return ans;
    }

}
