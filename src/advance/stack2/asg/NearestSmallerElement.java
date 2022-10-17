package advance.stack2.asg;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {

    public int[] prevSmaller(int[] A) {
        Stack<Integer> st = new Stack<>();
        int[] ansArr = new int[A.length];
        Arrays.fill(ansArr, -1);

        int count = 0;
        while (count < A.length) {
            // check max element in stack, and remove until found min or equal
            while (st.size()>0 && A[count] <= st.peek()) {
                st.pop();
            }
            if (st.size()>0) {
                ansArr[count] = st.peek();
            }
            st.push(ansArr[count]);
            count++;
        }
        return ansArr;

    }
}
