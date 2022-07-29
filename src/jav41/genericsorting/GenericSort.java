package jav41.genericsorting;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GenericSort {

    /*
     * private T[] data;
     * // private List<T> data;
     * 
     * public GenericSort(T[] data) {
     * this.data = data;
     * }
     * 
     * public void setData(T[] data) {
     * this.data = data;
     * }
     * 
     * public T[] getData() {
     * return this.data;
     * }
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
                    /*
                     * System.out.println(
                     * "Break after : " + (input.length - i) + " iterations with :  " +
                     * comparison_counter
                     * + " comparisons ");
                     */
                    swapped = false;
                    break;

                }
            }
        }
        return input;
    }

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
            // No swap the smallest number and the current spot
            if (i != index) {
                input[i] = input[index];
                input[index] = numberToCompare;
            }
        }

        return input;
    }

    private int getPivot(int[] input) {
        if (input.length > 2) {
            int[] numbers = { input[0], input[input.length / 2], input[input.length - 1] };
            Arrays.sort(numbers);
            return numbers[1];
        } else {
            return input[0];
        }
    }

    public static <T extends Comparable<T>> T[] quicksort(T[] input, int low, int high) {
        if (low < high) {
            int pos = partition(input, low, high);
            quicksort(input, low, pos - 1);
            quicksort(input, pos + 1, high);
        }
        return input;
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        int p = low, j;

        for (j = low + 1; j <= high; j++) {
            if (arr[j].compareTo(arr[low]) > 0) {
                swap(arr, ++p, j);
            }
        }
        swap(arr, low, p);
        // System.out.println("Array: " + Arrays.toString(arr));
        return p;
    }

    private static <T extends Comparable<T>> void swap(T[] arr, int index1, int index2) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    // public T quickSort() {

    // }

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
        Random rd = new Random();
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = rd.nextInt(100);
        }
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
        Random rd = new Random();
        Float[] array = new Float[length];
        for (int i = 0; i < length; i++) {
            array[i] = rd.nextFloat();
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
        Random rd = new Random();
        Double[] array = new Double[length];
        for (int i = 0; i < length; i++) {
            array[i] = min + rd.nextDouble() * (max - min);
        }
        return array;
    }

}
