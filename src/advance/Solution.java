package advance;

// { Driver Code Starts
//Initial Template for Java
import javax.swing.text.NumberFormatter;
import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;


//User function Template for Java
class Solution
{
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {-1,0,0};
        double den = s.density(3, arr);
        System.out.println(den);
    }
    private class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    private class Tree {
        Node root;
        public void Tree(){};
    }
    double density(int N, int par[])
    {
        // build node first using array
        Tree t = new Tree();
        t.root = insertLevelOrder(par, 0);
        int maxDepth = findMaxDepth(t.root);
       return ((long)(double)N) /((long) (double) maxDepth);
    }

    private int findMaxDepth(Node n) {
        if(n == null)
            return 0;
        else {
            int left = findMaxDepth(n.left);
            int right = findMaxDepth(n.right);
            return Math.max(left, right)+1;
        }
    }

    private Node insertLevelOrder(int[] arr, int i) {
        Node root = null;
        if(i < arr.length) {

            root = new Node(arr[i]);
            root.left = insertLevelOrder(arr, i*2 + 1);
            root.right = insertLevelOrder(arr, i*2 + 2);
        }
        return root;
    }
}
