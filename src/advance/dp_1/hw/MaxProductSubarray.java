package advance.dp_1.hw;

public class MaxProductSubarray {

    public static void main(String[] args) {
        int[] input = {4,0,-5,0};
        int ans = maximumProduct(input);
        System.out.println(ans);
    }

    private static int maximumProduct(int[] input) {
        int result = Integer.MIN_VALUE;
        int curMin = 1, curMax = 1;

        for (int i = 0; i<input.length; i++) {
            int val = input[i];
            int tempMax = val * curMax;
            curMax = Math.max(curMax * val, curMin * val);
            curMax = Math.max(curMax, val);

            curMin = Math.min(tempMax, curMin * val);
            curMin = Math.min(curMin, val);

            result = Math.max(result, curMax);
        }
        return result;
    }
}
