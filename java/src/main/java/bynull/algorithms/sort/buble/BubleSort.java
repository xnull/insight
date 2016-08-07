package bynull.algorithms.sort.buble;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Bubble sort
 * Created by null on 8/7/16.
 */
public class BubleSort {

    public static void main(String[] args) {

        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            values.add(new Random().nextInt(100));
        }
        System.out.println("Unsorted array: " + values);

        for (int i = 0; i < values.size() - 1; i++) {
            for (int j = 0; j < values.size() - 1; j++) {
                if (values.get(j) > values.get(j + 1)) {
                    Integer min = values.get(j + 1);
                    values.set(j +1, values.get(j));
                    values.set(j, min);
                }
            }
        }

        System.out.println("Sorted array:   " + values);
    }
}
