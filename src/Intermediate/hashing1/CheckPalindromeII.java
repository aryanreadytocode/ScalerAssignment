package Intermediate.hashing1;

import java.util.HashMap;

public class CheckPalindromeII {

    public static void main(String[] args) {
        String s = "mnxljrajwhxiaquajokwvoqqphylxpbanmmhfxsmssxzsdnprtgibuhaxnwxzfozexiascybplaaqjcthuydnoowmkzyamodzknkqmwdglqqnhflfslqyowcangsddhcjjuiyfbdkevlghbictrvnmnathotrekyrggwcmbzorqtyeowksywlbetsyhjvczcnvusfdrxythrhhoxtuuprqftgwohcgpngktkharijsovuknae";
        System.out.println(new CheckPalindromeII().solve(s));
    }

    public int solve(String A) {
        char[] ch = A.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c: ch) {
            hm.put(c, hm.getOrDefault(c, 0)+1);
        }
        int singleEleCount = 0;
        for(char ele: hm.keySet()){
            if(hm.get(ele)%2 == 1)
                singleEleCount++;
        }
        return singleEleCount>1?0:1;
    }
}
