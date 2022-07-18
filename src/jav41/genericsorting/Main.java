package jav41.genericsorting;

import java.util.Arrays;

import jav41.genericsorting.GenericSort;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        int[] random = GenericSort.create_array(10);
        System.out.println(Arrays.toString(random));
        GenericSort<int[]> genericSort = new GenericSort<int[]>(random);
        System.out.println(Arrays.toString(genericSort.getData()));
    }

}