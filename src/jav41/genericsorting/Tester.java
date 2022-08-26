package jav41.genericsorting;

import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import java.util.Arrays;

public class Tester<T extends Comparable<T>> implements Runnable {
    private T[] data;
    private int step;
    private int start;
    private int end;
    private char algorithm;
    private int length;
    private int min;
    private int max;
    private char type;

    /**
     * Class for creating generic tests of different sorting algorithms.
     * 
     * @param step      How many items are added to the arrays per test step
     * @param start     Number of items to start with in the first step of execution
     * @param end       Threshold up until what number of items test are performed
     * @param algorithm What sorting algorithm to be used (q -> Quicksort, b ->
     *                  Bubblesort, s -> selectionsort)
     * @param length    The length of the currently handled array
     * @param min       Minimal value of each array item
     * @param max       Maximal value of each array item
     * @param type      Type of the array items (f -> float, d -> Double, i ->
     *                  Integer)
     */
    public Tester(int step, int start, int end, char algorithm, int length, int min, int max, char type) {
        this.step = step;
        this.start = start;
        this.end = end;
        this.algorithm = algorithm;
        this.length = length;
        this.min = min;
        this.max = max;
        this.type = type;
        this.data = this.get_array();

    }

    /**
     * Will create an array with fixed length. The type of the array is determined
     * by this.type.
     * It takes into consideration what min and max values for each item are set.
     * 
     * @return
     */
    private T[] get_array() {
        switch (this.type) {
            case 'i':
                return (T[]) GenericSort.create_integer_array(this.length, this.max, this.min);
            case 'f':
                return (T[]) GenericSort.create_float_array(this.length, this.max, this.min);
            case 'd':
                return (T[]) GenericSort.create_double_array(this.length, this.max, this.min);
            default:
                return (T[]) GenericSort.create_integer_array(this.length, this.max, this.min);

        }
    }

    /**
     * Writes a list of results to the disk. Automatically uses combination of
     * this.algorithm and this.type to create the file name.
     * 
     * @param strings
     */
    private void write_file(List<String> strings) {
        try {
            Path path = Paths.get("" + this.algorithm + this.type + ".txt");
            Files.write(path, strings);
            System.out.println("Written file to " + path);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Performs a sorting algorithm based on the given algorithm, type, beginning
     * and end.
     * Afterwards, writes the results to the disk, including the elapsed time for
     * each step.
     */
    public void run() {
        List<String> output = new ArrayList<String>();
        switch (this.algorithm) {
            case 'q':
                for (int i = this.start; i < this.end; i = i + this.step) {
                    long local_start = System.nanoTime();
                    System.out.println("q|" + i + "|" + this.type);

                    // Actually sort the items.
                    T[] quicksort_sorted = GenericSort.quicksort(this.data.clone(), 0,
                            this.data.length - 1);
                    // System.out.println(Arrays.toString(quicksort_sorted));

                    long timeElapsed = (System.nanoTime() - local_start);
                    output.add("Quicksort" + "|" + this.data.length + "|" + this.type + "|" + timeElapsed);

                    // Create new array with elements and with increased length.
                    this.length = i + this.step;
                    this.data = get_array();
                }
                write_file(output);
                break;

            case 'b':
                for (int i = this.start; i < this.end; i = i + this.step) {
                    // System.out.println("----------");
                    long local_start = System.nanoTime();
                    System.out.println("b|" + i + "|" + this.type);

                    T[] bubbelsort_sorted = GenericSort.bubbleSort(this.data.clone());
                    long timeElapsed = (System.nanoTime() - local_start);
                    output.add("Bubblesort" + "|" + this.data.length + "|" + this.type + "|" + timeElapsed);

                    this.length = i + this.step;

                    this.data = get_array();
                }
                write_file(output);
                break;

            case 's':
                for (int i = this.start; i < this.end; i = i + this.step) {
                    long local_start = System.nanoTime();
                    System.out.println("s|" + i + "|" + this.type);
                    T[] selectionsort_sorted = GenericSort.selectionSort(this.data.clone());
                    long timeElapsed = (System.nanoTime() - local_start);
                    output.add("SelectionSort" + "|" + this.data.length + "|" + this.type + "|" + timeElapsed);

                    this.length = i + this.step;
                    this.data = get_array();
                }
                write_file(output);
                break;
        }

    }
}
