package jav41.genericsorting;

import java.util.Arrays;

import jav41.genericsorting.GenericSort;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello there");

        // Integer[] random_integer = GenericSort.create_integer_array(10);
        // Float[] random_float = GenericSort.create_float_array(10);
        Double[] random_double = GenericSort.create_double_array(10, 1, 10);
        System.out.println(Arrays.toString(random_double));
        // GenericSort<Integer[]> genericSort = new GenericSort<Integer[]>(random);
        System.out.println(Arrays.toString(GenericSort.quicksort(random_double, 0, random_double.length - 1)));
        // System.out.println(Arrays.toString(genericSort.getData()));
    }

}