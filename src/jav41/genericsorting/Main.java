package jav41.genericsorting;

import java.util.Arrays;

import jav41.genericsorting.GenericSort;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello there");
        int length = 200000;
        int min = 1;
        int max = 99999;
        Integer[] random_integer = GenericSort.create_integer_array(length, min, max);
        Float[] random_float = GenericSort.create_float_array(length, min, max);
        Double[] random_double = GenericSort.create_double_array(length, min, max);
        // System.out.println(Arrays.toString(random_double));
        // GenericSort<Integer[]> genericSort = new GenericSort<Integer[]>(random);
        // Double[] sorted = GenericSort.quicksort(random_double, 0,
        // random_double.length - 1);

        System.out.println("---- Start selection sort ----");

        Double[] selection_sorted_double = GenericSort.selectionSort(random_double.clone());
        // Float[] selection_sorted_float = GenericSort.selectionSort(random_float);
        // Integer[] selection_sorted_int = GenericSort.selectionSort(random_integer);
        // System.out.println(Arrays.toString(selection_sorted_double));

        System.out.println("---- Start bubble sort ----");
        Double[] bubble_sorted_double = GenericSort.bubbleSort(random_double.clone());
        // Float[] bubble_sorted_float = GenericSort.selectionSort(random_float);
        // Integer[] bubble_sorted_int = GenericSort.selectionSort(random_integer);
        // System.out.println(Arrays.toString(bubble_sorted_double));

        System.out.println("---- Start quicksort sort ----");
        Double[] quicksort_sorted_double = GenericSort.quicksort(random_double.clone(), 0, random_double.length - 1);
        // Float[] quicksort_sorted_float = GenericSort.selectionSort(random_float);
        // Integer[] quicksort_sorted_int = GenericSort.selectionSort(random_integer);
        // System.out.println(Arrays.toString(quicksort_sorted_double));

        // System.out.println(Arrays.toString(genericSort.getData()));
    }

}