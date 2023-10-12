package HLD.storage_layer;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class TypeheadSearch {
    Instant updateFrequency = Instant.EPOCH;

    // Pair to store the input string and frequency
    private class Pair implements Comparable<Pair> {
        long frequency;
        String typeSearch;

        Pair(long frequency, String typeSearch) {
            this.frequency = frequency;
            this.typeSearch = typeSearch;
        }

        @Override
        public int compareTo(Pair pair) {
            if (this.frequency < pair.frequency)
                return -1;
            else if (this.frequency > pair.frequency)
                return 1;
            else {
                return typeSearch.compareTo(pair.typeSearch);
            }
        }
    }

    // Trie for storing the search
    private class TrieNode {
        boolean isEnd;
        HashMap<String, Long> map; // stores freq
        LinkedList<Pair> list; // stores the string in ascending order of frequency
        TrieNode[] childLinks;

        TrieNode() {
            childLinks = new TrieNode[26];
            map = new HashMap<>();
            list = new LinkedList<>();
        }
    }

    public void incrementSearchTermFrequency(String search_term, int increment){
        insert(search_term, increment);
    }
    public String[] findTopXSuggestion(String queryPrefix, int X) {
        return find(queryPrefix, X);
    }

    // creating a common root node;
    TrieNode root = new TrieNode();
    private void insert(String typeSearch, long frequency) {
        TrieNode temp = root;
        // insert the string in the trienode
        for(char ch : typeSearch.toCharArray()) {
            if (temp.childLinks[ch-'a'] == null)
                temp.childLinks[(ch - 'a')] = new TrieNode();
            temp = temp.childLinks[ch - 'a'];

            // if typeString is present, the increase frequency in map and remove
            // string with the older frequency from the list and add string with new
            // frequency in sorted manner in list
            int j = 0;
            if (temp.map.containsKey(typeSearch)) {
                long totalFrequency = temp.map.get(typeSearch) + frequency;
                temp.map.put(typeSearch, totalFrequency);

                // remove typeSearch from list
                while (j < temp.list.size() && !temp.list.get(j).typeSearch.equals(typeSearch)) {
                    j++;
                }
                temp.list.remove(j);
            } else {
                temp.map.put(typeSearch, frequency);
            }
            // add the removed pair to the linkedlist
            long newFrequency = temp.map.get(typeSearch);
            Pair pair = new Pair(newFrequency, typeSearch);
            j = 0;
            // adding pair to the linked in ascending order
            while (j < temp.list.size() && pair.compareTo(temp.list.get(j)) > 0) {
                j++;
            }
            temp.list.add(j, pair);
        }
        temp.isEnd = true;
    }

    // finding strict prefixes else returning black strings
    private String[] find(String queryPrefix, int x) {
        String[] outputString = new String[x];
        TrieNode temp = root;
        for (char ch : queryPrefix.toCharArray()) {
            // if prefix is not present in trie, return list with
            // blank strings
            if (temp.childLinks[ch-'a'] == null){
                for (int j = 0; j<x; j++) {
                    outputString[j] = "";
                }
                return outputString;
            }else {
                temp = temp.childLinks[ch - 'a'];
            }
        }
        // if strict prefix is not present in trie, returning list
        // blank strings
        if (temp == null) {
            for (int i = 0; i<x; i++) {
                outputString[i] = "";
            }
        }
        int k = 0;
        int listSize = temp.list.size() -1;
        while (k < x && listSize>=0) {
            outputString[k] = temp.list.get(listSize).typeSearch;
            k++;
            listSize --;
        }
        // adding black string if found strings are less than x
        while (k < x) {
            outputString[k] = "";
            k++;
        }
        Arrays.sort(outputString);
         return outputString;
    }

    public static void main(String[] args) {
        TypeheadSearch search = new TypeheadSearch();
        search.incrementSearchTermFrequency("rajan", 100);
        search.incrementSearchTermFrequency("raj", 90);
        search.incrementSearchTermFrequency("rajini", 120);
        search.incrementSearchTermFrequency("rajesh", 51);
        System.out.println(Arrays.toString(search.findTopXSuggestion("ra", 4)));
    }
}
