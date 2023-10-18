package HLD.Popular_Interview_Question;

import java.util.ArrayList;
import java.util.HashMap;

public class RT2 {

        public int[] solve(int[] A, int[] B) {
            int n = A.length;
            int[] ans = new int[n];
            HashMap<Integer, ArrayList<Integer>> clientWindow = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int clientId = A[i];
                int timeStamp = B[i];
                if (!clientWindow.containsKey(clientId)) {
                    clientWindow.put(clientId, new ArrayList<>());
                }
                ArrayList<Integer> requests = clientWindow.get(clientId);
                // Remove requests that are older than 10 seconds
                while (!requests.isEmpty() && requests.get(0) <= timeStamp - 10) {
                    requests.remove(0);
                }
                // Check if the client has made fewer than 3 requests in the last 10 seconds
                if (requests.size() < 3) {
                    requests.add(timeStamp);
                    ans[i] = 1;
                } else {
                    ans[i] = 0;
                }
            }
            return ans;
        }
}
