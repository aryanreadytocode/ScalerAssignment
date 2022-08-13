package Intermediate.TreesBasics1;

import java.util.ArrayList;
import java.util.Stack;

/*
* Problem Description
Given a binary tree, return the preorder traversal of its nodes' values.

NOTE: Using recursion is not allowed.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return an integer array denoting the preorder traversal of the given binary tree.



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

 [1, 2, 3]
Output 2:

 [1, 6, 2, 3]


Example Explanation
Explanation 1:

 The Preoder Traversal of the given tree is [1, 2, 3].
Explanation 2:

 The Preoder Traversal of the given tree is [1, 6, 2, 3].
* */
public class PreorderTraversal {

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> resultArrayList = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = A;
        while(true){
            if(node != null){
                resultArrayList.add(node.val);
                st.push(node);
                node = node.left;
            }else {
                if(st.isEmpty())
                    break;
                node = st.pop();
                node = node.right;
            }
        }
        return resultArrayList;
    }
}
