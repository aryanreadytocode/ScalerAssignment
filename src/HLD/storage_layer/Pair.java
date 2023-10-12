package HLD.storage_layer;

public class Pair implements Comparable<Pair> {
    long frequency;
    String typeSearch;

    Pair(long frequency, String typeSearch) {
        this.frequency = frequency;
        this.typeSearch = typeSearch;
    }

    @Override
    public int compareTo(Pair pair) {
        if (frequency < pair.frequency)
            return -1;
        else if (frequency > pair.frequency)
            return 1;
        else {
            return typeSearch.compareTo(pair.typeSearch);
        }
    }


    // comparison based on frequency and lexicographically

}
