package Intermediate.TreesBasics1;

import java.util.ArrayList;
import java.util.Stack;

/*
* Problem Description
Given a binary tree, return the Postorder traversal of its nodes' values.

NOTE: Using recursion is not allowed.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return an integer array denoting the Postorder traversal of the given binary tree.



Example Input
Input 1:

   1
    \
     2
    /
   3
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [3, 2, 1]
Output 2:

 [6, 3, 2, 1]


Example Explanation
Explanation 1:

 The Preoder Traversal of the given tree is [3, 2, 1].
Explanation 2:

 The Preoder Traversal of the given tree is [6, 3, 2, 1].
* */
public class PostorderTraversal {


    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer>answer=new ArrayList<>();
        Stack<TreeNode>st=new Stack<>();
        while(A!=null || !st.isEmpty()) {
            if (A!= null) {
                st.push(A);
                A = A.left;
            }else {
                TreeNode temp = st.peek().right;
                if (temp == null){
                    temp = st.pop();
                    answer.add(temp.val);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        answer.add(temp.val);
                    }
                } else {
                    A = temp;
                }
            }
        }

        return answer;
    }

    public ArrayList<Integer> postOrder(TreeNode A, ArrayList<Integer> arrayList) {
        if( A == null)
            return null;
        postOrder(A.left, arrayList);
        postOrder(A.right, arrayList);
        arrayList.add(A.val);
        return arrayList;
    }

}
