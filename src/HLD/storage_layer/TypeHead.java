package HLD.storage_layer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

class TypeHead {

    class Pair implements Comparable<Pair> {
        long frequency;
        String string;

        Pair(long frequency, String string) {
            this.frequency = frequency;
            this.string = string;
        }

        @Override
        public int compareTo(Pair pair) {
            if (this.frequency < pair.frequency) {
                return -1;
            } else if (this.frequency > pair.frequency) {
                return 1;
            } else {
                if(this.string.compareTo(pair.string)<0)
                    return -1;
                else if(this.string.compareTo(pair.string)>0)
                    return 1;
                return 0;
            }
        }

    }

    class TrieNode {
        int isEndOfWord;
        LinkedList<Pair> list;
        TrieNode[] child;

        TrieNode() {
            child = new TrieNode[26];
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }
            list = new LinkedList<>();
        }
    }

    TrieNode root = new TrieNode();

    void insert(String inputString, int frequency) {
        TrieNode temp = root;
        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            int index = ch -'a';
            if (temp.child[index] == null) {
                temp.child[index] = new TrieNode();
            }
            temp = temp.child[index];
            long newFrequency = frequency;
            int j = 0;
            while (j < temp.list.size() && !temp.list.get(j).string.equals(inputString)) {
                j++;
            }
            if (j != temp.list.size()) {
                newFrequency += temp.list.get(j).frequency;
                temp.list.remove(j);
            }
            Pair pair = new Pair(newFrequency, inputString);
            j = 0;
            while ((j < temp.list.size()) && (pair.compareTo(temp.list.get(j)) == 1)) {
                j++;
            }
            temp.list.add(j, pair);
        }
    }

    String[] find(String queryPrefix, int x) {
        String[] outputStrings = new String[x];
        TrieNode temp = root;
        int index = 0;
        for (int i = 0; i < queryPrefix.length(); i++) {
            char ch = queryPrefix.charAt(i);
            index = ch -'a';
            if (temp.child[index] == null) {
                for (int j = 0; j < x; j++) {
                    outputStrings[j] = "";
                }
                return outputStrings;
            } else {
                temp = temp.child[index];
            }
        }
        if (temp == null) {
            for (int j = 0; j < x; j++) {
                outputStrings[j] = "";
            }
            return outputStrings;
        }
        int k = 0;
        int listSize = temp.list.size() - 1;
        while (k < x && listSize >= 0) {
            outputStrings[k] = temp.list.get(listSize).string;
            listSize--;
            k++;
        }
        while (k < x) {
            outputStrings[k] = "";
            k++;
        }
        Arrays.sort(outputStrings);
        return outputStrings;
    }

    void decreaseFrequency(int decayFactor, TrieNode temp) {
        for (int i = 0; i < 26; i++) {
            if (temp.child[i] != null) {
                for (Pair p : temp.child[i].list) {
                    p.frequency /= decayFactor;
                }
                decreaseFrequency(decayFactor, temp.child[i]);
            }
        }
        return;
    }

    public void incrementSearchTermFrequency(String search_term, int increment) {
        insert(search_term, increment);
    }

    public String[] findTopXSuggestion(String queryPrefix, int X) {
        return find(queryPrefix, X);
    }

    public void dayPasses(int decayFactor) {
        decreaseFrequency(decayFactor, root);
    }
}