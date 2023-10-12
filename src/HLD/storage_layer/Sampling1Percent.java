package HLD.storage_layer;

import java.util.Random;

public class Sampling1Percent {
    Boolean filter() {
        // Complete the function
        Random r = new Random();
        int value = r.nextInt(100);
        return value < 1;
    }
}
