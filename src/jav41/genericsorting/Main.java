package jav41.genericsorting;

import java.util.Arrays;

import jav41.genericsorting.GenericSort;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello here");
        int length = 1000;
        int min = 1;
        int max = 10;
        String leftAlignFormat = "| %-15s | %-8d | %-15s | %-10d | %n";

        // Integer[] random_integer = GenericSort.create_integer_array(length, min,
        // max);

        System.out.format("+-----------+-------------+--------------+----------------+%n");
        System.out.format("| Algorithms | Input length | Input Type | Execution time |%n");

        Thread quicksort = new Thread(new Tester<>(1000, 1000, 1000000, 'q', length, min, max, 'i'));
        Thread bubblesort = new Thread(new Tester<>(1000, 1000, 500000, 'b', length, min, max, 'i'));
        Thread selectionSort = new Thread(new Tester<>(1000, 1000, 500000, 's', length, min, max, 'i'));

        quicksort.start();
        bubblesort.start();
        selectionSort.start();
        /*
         * for (var i = length; i < 500000; i = i + 10000) {
         * Float[] random_float = GenericSort.create_float_array(length, min, max);
         * Double[] random_double = GenericSort.create_double_array(i, min, max);
         * // System.out.println(Arrays.toString(random_double));
         * // GenericSort<Integer[]> genericSort = new
         * GenericSort<Integer[]Inter>(random);
         * // Double[] sorted = GenericSort.quicksort(random_double, 0,
         * // random_double.length - 1);
         * long local_start = System.nanoTime();
         * 
         * Double[] selection_sorted_double =
         * GenericSort.selectionSort(random_double.clone());
         * long local_finish = System.nanoTime();
         * long timeElapsed = (local_finish - local_start);
         * System.out.format(leftAlignFormat, "Selection Sort", i, "Double",
         * timeElapsed);
         * 
         * // Float[] selection_sorted_float = GenericSort.selectionSort(random_float);
         * // Integer[] selection_sorted_int =
         * GenericSort.selectionSort(random_integer);
         * local_start = System.nanoTime();
         * Double[] bubble_sorted_double =
         * GenericSort.bubbleSort(random_double.clone());
         * local_finish = System.nanoTime();
         * timeElapsed = (local_finish - local_start);
         * System.out.format(leftAlignFormat, "BubbleSort", i, "Double", timeElapsed);
         * 
         * // Float[] bubble_sorted_float = GenericSort.selectionSort(random_float);
         * // Integer[] bubble_sorted_int = GenericSort.selectionSort(random_integer);
         * 
         * local_start = System.nanoTime();
         * 
         * Double[] quicksort_sorted_double =
         * GenericSort.quicksort(random_double.clone(), 0,
         * random_double.length - 1);
         * // Float[] quicksort_sorted_float = GenericSort.selectionSort(random_float);
         * // Integer[] quicksort_sorted_int =
         * GenericSort.selectionSort(random_integer);
         * // System.out.println(Arrays.toString(quicksort_sorted_double));
         * local_finish = System.nanoTime();
         * timeElapsed = (local_finish - local_start);
         * System.out.format(leftAlignFormat, "Quicksort", i, "Double", timeElapsed);
         * 
         * // System.out.println(Arrays.toString(genericSort.getData()));
         * }
         * long global_finish = System.nanoTime();
         * System.out.println((global_finish - global_start) / 10000000);
         */
    }

}
