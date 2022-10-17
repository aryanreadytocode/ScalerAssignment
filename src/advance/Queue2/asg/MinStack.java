package advance.Queue2.asg;

import java.util.ArrayList;
import java.util.Stack;

public class MinStack {

    private ArrayList<Integer> arrayList = new ArrayList<>();
    private ArrayList<Integer> minArrayList = new ArrayList<>();
    private int min = Integer.MAX_VALUE;
    private int arrSize = 0;
    private int minArrSize = 0;

    public void push(int x) {
        if (x < min) {
            minArrayList.add(min);
            minArrSize++;
        }
        arrayList.add(x);
        arrSize++;
        Stack<Integer> stack = new Stack<>();
    }

    public void pop() {
        int element = arrayList.get(arrSize -1);
        minArrayList.remove(minArrayList.size()-1);
        arrayList.remove(arrSize - 1);
        arrSize--;
    }

    public int top() {
        return arrayList.get(arrSize - 1);
    }

    public int getMin() {
        return minArrayList.get(minArrayList.size()-1);
    }
}
