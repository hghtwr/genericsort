package jav41.genericsorting;

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

    public void run() {
        String leftAlignFormat = "| %-15s | %-8d | %-15s | %-10d | %n";

        switch (this.algorithm) {
            case 'q':
                for (int i = this.start; i < this.end; i = i + this.step) {
                    long local_start = System.nanoTime();

                    T[] quicksort_sorted = GenericSort.quicksort(this.data.clone(), 0,
                            this.data.length - 1);
                    // System.out.println(Arrays.toString(quicksort_sorted));
                    long local_finish = System.nanoTime();
                    long timeElapsed = (local_finish - local_start);
                    System.out.format(leftAlignFormat, "Quicksort", this.data.length, this.type, timeElapsed);

                    this.length = i;
                    this.data = get_array();
                }
                break;
            case 'b':
                for (int i = this.start; i < this.end; i = i + this.step) {
                    // System.out.println("----------");
                    long local_start = System.nanoTime();

                    // System.out.println("Bubblesort for " + Integer.toString(i));
                    // System.out.println(Arrays.toString(this.data));
                    T[] bubbelsort_sorted = GenericSort.bubbleSort(this.data.clone());
                    // System.out.println(Arrays.toString(bubbelsort_sorted));
                    long local_finish = System.nanoTime();
                    long timeElapsed = (local_finish - local_start);
                    System.out.format(leftAlignFormat, "Bubblesort", this.data.length, this.type, timeElapsed);
                    this.length = i;

                    this.data = get_array();
                }
                break;

            case 's':
                for (int i = this.start; i < this.end; i = i + this.step) {
                    long local_start = System.nanoTime();

                    T[] quicksort_sorted = GenericSort.selectionSort(this.data.clone());
                    // System.out.println(Arrays.toString(quicksort_sorted));
                    long local_finish = System.nanoTime();
                    long timeElapsed = (local_finish - local_start);
                    System.out.format(leftAlignFormat, "SelectionSort", this.data.length, this.type, timeElapsed);

                    this.length = i;
                    this.data = get_array();
                }
        }

    }
}
