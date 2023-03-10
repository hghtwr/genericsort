package jav41.genericsorting;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A generic class that implements 3 different sorting algorithms: Bubblesort,
 * Selectionsort, Quicksort as static methods.
 */
public class GenericSort {
    /**
     * Takes a generic item set as input and performs bubblesort on the item set in
     * ascending order.
     * 
     * @param <T>   Type of the original item set
     * @param input Original item set
     * @return sorted item set
     */
    public static <T extends Comparable<T>> T[] bubbleSort(T[] input) {
        // int[] worker = input.clone();

        boolean swapped = true;
        while (swapped) {
            for (int i = input.length - 1; i > 0; i--) {
                int count = 0;
                for (int e = 0; e < i; ++e) {
                    // System.out.println(i + "/" + e);
                    if (input[e].compareTo(input[e + 1]) < 0)
                    // if (input[e] > input[e + 1]) {
                    {
                        T first_number = input[e];
                        T second_number = input[e + 1];
                        input[e] = second_number;
                        input[e + 1] = first_number;
                        count = count + 1;
                    }
                }
                if (count == 0 || i == 1) {
                    swapped = false;
                    break;
                }
            }
        }
        return input;
    }

    /**
     * Takes a generic item set as input and performs selectionsort on the item set
     * in ascending order.
     * 
     * @param <T>   Type of the original item set
     * @param input Original item set
     * @return sorted item set
     */
    public static <T extends Comparable<T>> T[] selectionSort(T[] input) {

        for (int i = 0; i < input.length; i++) {
            int index = i;
            T numberToCompare = input[i];
            T temp = input[i];

            // Natively get the smallest number from the array
            for (int j = i; j < input.length - 1; j++) {
                if (input[j + 1].compareTo(temp) > 0) {
                    temp = input[j + 1];
                    index = j + 1; // Save index for swap
                }
            }
            // Don't swap the smallest number and the current spot
            if (i != index) {
                input[i] = input[index];
                input[index] = numberToCompare;
            }
        }

        return input;
    }

    /**
     * Takes an item set of a generic type and recursively performs quicksort on it
     * 
     * @param <T>   Generic Type of the original item set
     * @param input Original item set
     * @param low   Index to start from the left
     * @param high  Index to start from the right
     * @return sorted item set
     */
    public static <T extends Comparable<T>> T[] quicksort(T[] input, int low, int high) {
        if (low < high) {
            int pos = partition(input, low, high);
            try {
                quicksort(input, low, pos - 1);
                // System.out.println("Pos" + pos);
                // System.out.println("High" + high);

                quicksort(input, pos + 1, high);

            } catch (StackOverflowError e) {
                // System.out.println(Arrays.toString(input));

            }
        }
        return input;

    }

    /**
     * Part of the quicksort algorithm. Takes a partition of the original set of
     * items and compares/swaps the necessary elements. For this is goes through the
     * array and sorts the larger items to the left.
     * Then it will store the position of the last larger item as designated
     * position for the pivot element (p).
     * 
     * @param <T>  Generic Type of the original item set
     * @param arr  Partition of the original item set
     * @param low  Point to start from the left
     * @param high Point to start from the right
     * @return pivot element (the index of the pivot element in the end)
     */
    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {

        int p = low, j;
        try {
            // System.out.print(Arrays.toString(arr));
            // Check for the list from the left if the item is larger. If yes, swap them
            // after increasing the designated place for the pivot item at the end (p).
            for (j = low + 1; j <= high; j++) {
                if (arr[j].compareTo(arr[low]) > 0) {
                    swap(arr, ++p, j);
                }
            }
            // Finally swap the original pivot element to the place it should be between the
            // larger and smaller items.
            swap(arr, low, p);

        } catch (StackOverflowError e) {
            // System.out.println(e);
        }
        return p;
    }

    private static <T extends Comparable<T>> void swap(T[] arr, int index1, int index2) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /**
     * Simple function to create an array with random values of a certain length.
     * 
     * @param length length of the array to be created
     * @param max    max value of each random vlaue
     * @param min    min value of each random value
     * @return Integer[] with random values taking length, max and min into
     *         consideration
     */
    public static Integer[] create_integer_array(int length, int max, int min) {
        // ThreadLocalRandom rd = new ThreadLocalRandom();
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(max - min) + min;
            // array[i] = min + rd.nextInt() * (max - min);
        }
        // System.out.println(Arrays.toString(array));
        return array;
    }

    /**
     * Simple function to create an array with random values of a certain length.
     * 
     * @param length length of the array to be created
     * @param max    max value of each random vlaue
     * @param min    min value of each random value
     * @return Float[] with random values taking length, max and min into
     *         consideration
     */
    public static Float[] create_float_array(int length, int max, int min) {
        // ThreadLocalRandom rd = new ThreadLocalRandom();
        Float[] array = new Float[length];
        for (int i = 0; i < length; i++) {
            array[i] = min + ThreadLocalRandom.current().nextFloat() * (max - min);
        }
        return array;
    }

    /**
     * Simple function to create an array with random values of a certain length.
     * 
     * @param length length of the array to be created
     * @param max    max value of each random vlaue
     * @param min    min value of each random value
     * @return Double[] with random values taking length, max and min into
     *         consideration
     */
    public static Double[] create_double_array(int length, int max, int min) {
        Double[] array = new Double[length];
        for (int i = 0; i < length; i++) {
            array[i] = min + ThreadLocalRandom.nextDouble() * (max - min);
        }
        return array;
    }

}
