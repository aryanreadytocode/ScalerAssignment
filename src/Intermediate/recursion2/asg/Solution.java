package Intermediate.recursion2.asg;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        int a = 3;
        System.out.println(new Solution().grayCode(a));
    }

    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<String> al = new Solution().gc(a);
        for (String ele: al) {
            res.add(Integer.parseInt(ele,2));
        }
        return res;
    }

    public ArrayList<String> gc(int a) {
        if(a==1){
            ArrayList<String> al = new ArrayList<>();
            al.add("0");
            al.add("1");
            return al;
        }
        ArrayList<String> res = gc(a-1);
        ArrayList<String> ans = new ArrayList<>();
        for (String ele: res) {
            ans.add("0"+ele);
        }
        for (int i = res.size()-1; i>=0; i--) {
            ans.add("1"+res.get(i));
        }
        return ans;
    }
}
