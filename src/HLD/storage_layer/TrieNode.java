package HLD.storage_layer;

import java.util.HashMap;
import java.util.LinkedList;

/**This class represent Trie datastructure
 * It has some basic functionality
 * like put, get, contains that will insert node, get node and check nod
 * already present or not*/
class TrieNode {

    private boolean isEnd;
    HashMap<String, Long> map;
    LinkedList<Pair> linkedList; // stores the string in asc order
    private TrieNode[] links ;

    void Node() {
        links = new TrieNode[26];
        map = new HashMap<>();
        linkedList = new LinkedList<>();
    }

    public void insert(TrieNode node, char ch) {
        links['a' - ch] = node;
        int linkedListSize = 0;
    }

    public void insertInMap(String typeSearch, long frequency){
        if (map.containsKey(typeSearch)){
            long totalFreq = map.get(typeSearch) + frequency;
            map.put(typeSearch, totalFreq);
        }else {
            map.put(typeSearch, frequency);
        }
    }

    public void insertInLinkedList(String typeSearch, long frequency) {}


    public TrieNode get(char ch) {
        if (links['a' - ch] != null)
            return links['a' - ch];
        return null;
    }

    public boolean checkIfEnd(char ch) {
        return isEnd;
    }

    public void setEnd(){
        isEnd = true;
    }

}
