package HLD.no_sql_internals;

import java.util.HashSet;

public class BloomFilter {

    private static final HashSet<Integer> set = new HashSet<>();

    static int hash(String str) {
        long mod=1000000007;
        long hash=0L;

        for(int i = 0; i< str.length(); i++) {
            char ch=str.charAt(i);
            hash = (hash%mod + ((long) (int) ch %mod * (long)(Math.pow(26,i)%mod) ) %mod )%mod;
        }
        return (int)hash;
    }

    static Boolean lookup(String s){
        // Complete the function
        int hash = hash(s);
        return set.contains(hash);

    }

    static void insert(String s){
        // Complete the function
        int hash = hash(s);
        set.add(hash);
    }
}
