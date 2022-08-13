package Intermediate.TreesBasics1;

import java.util.ArrayList;
import java.util.Stack;

/*
* Problem Description
Given a binary tree, return the inorder traversal of its nodes' values.

NOTE: Using recursion is not allowed.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return an integer array denoting the inorder traversal of the given binary tree.



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

 [1, 3, 2]
Output 2:

 [6, 1, 3, 2]


Example Explanation
Explanation 1:

 The Inorder Traversal of the given tree is [1, 3, 2].
Explanation 2:

 The Inorder Traversal of the given tree is [6, 1, 3, 2].
* */

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class InorderTraversal {


    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> al = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = A;
        while(true) {
            if(node != null) {
                st.push(node);
                node = node.left;
            }else {
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                al.add(node.val);
                node = node.right;
            }
        }
        return al;
    }

    public ArrayList<Integer> inOrder(TreeNode A, ArrayList<Integer> arrayList) {
        if( A == null)
            return null;
        inOrder(A.left, arrayList);
        arrayList.add(A.val);
        inOrder(A.right, arrayList);
        return arrayList;

    }
}
