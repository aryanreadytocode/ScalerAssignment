package Intermediate.TreesBasics1;

import java.util.Stack;

/*
* Problem Description
Given two binary trees, check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.



Problem Constraints
1 <= number of nodes <= 105



Input Format
The first argument is a root node of the first tree, A.

The second argument is a root node of the second tree, B.



Output Format
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.



Example Input
Input 1:

   1       1
  / \     / \
 2   3   2   3
Input 2:

   1       1
  / \     / \
 2   3   3   3


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 Both trees are structurally identical and the nodes have the same value.
Explanation 2:

 Values of the left child of the root node of the trees are different.
* */
public class IdenticalBinaryTrees {
    public int isSameTree(TreeNode A, TreeNode B) {
        Stack<TreeNode> stA = new Stack<>();
        int returnVal = 1;
        while (true) {
            if (A != null && B != null) {
                if (A.val == B.val) {
                    stA.push(A);
                    A = A.left;
                    B = B.left;
                } else {
                    returnVal = 0;
                    break;
                }
            } else if (A == null && B == null) {
                if (stA.isEmpty())
                    break;
                A = stA.pop().right;
                B = A;

            } else {
                returnVal = 0;
                break;
            }

        }
        return returnVal;
    }
}
