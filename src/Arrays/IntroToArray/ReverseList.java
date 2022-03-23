package Arrays.IntroToArray;

import java.util.ArrayList;
import java.util.List;

/*Problem Description

You are given a constant array A.

You are required to return another array which is the reversed form of input array.



Problem Constraints

1 <= A.size() <= 10000

1 <= A[i] <= 10000



Input Format

First argument is a constant array A.



Output Format

You have to return an integer array.



Example Input

Input 1:

A = [1,2,3,2,1]
Input 2:

A = [1,1,10]


Example Output

Output 1:

 [1,2,3,2,1]
Output 2:

 [10,1,1]


Example Explanation

Explanation 1:

Reversed form of input array is same as original array
Explanation 2:

Clearly, Reverse of [1,1,10] is [10,1,1]
*/
public class ReverseList {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(new ReverseList().solve(list));
    }
    public ArrayList<Integer> solve(final List<Integer> A) {

        ArrayList<Integer> list = new ArrayList<>(A);
        int from = 0;
        int to = A.size()-1;
        while (from<to){
            list.set(from, list.get(to)+list.get(from));
            list.set(to, list.get(from)-list.get(to));
            list.set(from, list.get(from)-list.get(to));
            to--;
            from++;
        }
        return list;
    }
}
