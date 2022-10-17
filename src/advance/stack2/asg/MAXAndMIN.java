package advance.stack2.asg;

import javax.swing.plaf.synth.SynthIcon;
import java.util.Arrays;
import java.util.Stack;

public class MAXAndMIN {

    public static void main(String[] args) {
//        int[] A = {4, 7, 3, 8};
//        int[] A = { 4, 5, 5, 0, 3, 5, 7, 3};
        int[] A = {994390, 986616, 976849, 979707, 950477, 968402, 992171, 937674, 933065, 960863, 980981, 937319,
                951236, 959547, 991052, 991799, 992213, 941294, 978103, 997198, 960759, 988476, 963517, 980366, 921767,
                979757, 977912, 983761, 981869, 947454, 930202, 999086, 973538, 999798, 996446, 944001, 974217, 951595,
                942688, 975075, 970973, 970130, 897109, 927660, 862233, 997130, 986068, 954098, 978175, 889682, 988973,
                996036, 969675, 985751, 977724, 881538, 988613, 924230, 906475, 915565, 986952, 975702, 994316, 964011,
                986848, 983699, 949076, 989673, 981788, 929094, 988310, 926471, 994763, 999736, 980762, 973560, 996622,
                934475, 998365, 966255, 998697, 998700, 911868, 983245, 996382, 996992, 953142, 994104, 987303, 853837,
                960626, 904203, 998063, 977596, 977868, 996012, 946345, 949255, 988138, 996298, 954933, 965036, 886976,
                998628, 990878, 953725, 916744, 985233, 919661, 970903, 986066 };
        int ans = solve1(A);
        System.out.println("Ans:"+ans);
    }

    public static int solve1(int[] A) {
        //pre-compute all of this
        int[] prevSmall = prevSmallerIndex(A);
        int[] nextSmall = nextSmallerIndex(A);
        int[] prevGreater = prevGreaterIndex(A);
        int[] nextGreater = nextGreaterIndex(A);
        int mod = 1000 * 1000 * 1000 + 7;

        long ans = 0;
        for (int i = 0; i < A.length; i++) {
            //subarray in which A[i] is min
            int p1 = prevSmall[i];
            int p2 = nextSmall[i];
            long prodMin = (1L * (i - p1) * (p2 - i)) % mod;
            long minContribution = (prodMin * A[i]) % mod;

            //subarray in which A[i] is max
            int p3 = prevGreater[i];
            int p4 = nextGreater[i];
            long prodMax = (1L * (i - p3) * (p4 - i)) % mod;
            long maxContribution = (prodMax * A[i]) % mod;

            //computing ans
            ans = (ans % mod) + ((maxContribution - minContribution) % mod);
            ans = ans % mod;
        }
        if (ans < 0) {
            ans = (ans + mod) % mod;
        }
        return (int)(ans % mod);
    }

    private static int[] prevSmallerIndex(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        Stack < Integer > stack = new Stack < > ();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] nextSmallerIndex(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, N); //edge case
        Stack < Integer > stack = new Stack < > ();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] prevGreaterIndex(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        Stack < Integer > stack = new Stack < > ();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] nextGreaterIndex(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, N); //edge case
        Stack < Integer > stack = new Stack < > ();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    public static int solve(int[] A) {

        int mod = 1000*1000*1000+7;
        int[] maxLeftArray = prevBigger(A);
        int[] maxRightArray = nextBigger(A);
        int[] minLeftArray = prevSmaller(A);
        int[] minRightArray = nextSmaller(A);


        // find differences for each element after calculating min and max using contribution technique
        int minContVal = 0;
        int maxContVal = 0;
        for (int i = 0; i<A.length; i++) {
            int contributionMin = (i - minLeftArray[i]) * (minRightArray[i] - i);
            minContVal = (minContVal%mod) + contributionMin * A[i];

            int contributionMax = (i - maxLeftArray[i]) * (maxRightArray[i] - i);
            maxContVal = (maxContVal%mod) + (contributionMax * A[i]);
        }
        return (maxContVal - minContVal)%mod;
    }

    public static int[] prevSmaller(int[] A) {
        int length = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] lb = new int[length]; // array to store index
        for (int index = 0; index < length; index++) {
            while (stack.size()>0 && A[index] <= A[stack.peek()]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                lb[index] = -1;
            }else {
                lb[index] = stack.peek();
            }
            stack.push(index);
        }
        return lb;
    }

    public static int[] nextSmaller(int[] A) {
        int length = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] rb = new int[length]; // array to store index
        for (int index = length-1; index>= 0; index--) {
            while (stack.size()>0 && A[index] <= A[stack.peek()]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                rb[index] = length;
            }else {
                rb[index] = stack.peek();
            }
            stack.push(index);
        }
        return rb;
    }

    public static int[] prevBigger(int[] A) {
        int length = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] lb = new int[length]; // array to store index
        for (int index = 0; index < length; index++) {
            while (stack.size()>0 && A[index] >= A[stack.peek()]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                lb[index] = -1;
            }else {
                lb[index] = stack.peek();
            }
            stack.push(index);
        }
        return lb;

    }

    public static int[] nextBigger(int[] A) {
        int length = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] rb = new int[length]; // array to store index
        for (int index = length-1; index>= 0; index--) {
            while (stack.size()>0 && A[index] >= A[stack.peek()]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                rb[index] = length;
            }else {
                rb[index] = stack.peek();
            }
            stack.push(index);
        }
        return rb;

    }






}
