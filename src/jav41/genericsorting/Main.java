package jav41.genericsorting;

import java.util.Arrays;

import jav41.genericsorting.GenericSort;

public class Main {

        /**
         * Main function that will create a conncurently executed test suite for the
         * test cases.
         * 
         * @param args
         */
        public static void main(String[] args) {

                int length = 0;
                int min = 1;
                int max = 100000;
                int step = 25000;
                int start = length;

                Thread quicksort_int = new Thread(new Tester<>(step, start, 500000, 'q', length, min, max, 'i'));
                Thread bubblesort_int = new Thread(new Tester<>(step, start, 500000, 'b', length, min, max, 'i'));
                Thread selectionSort_int = new Thread(new Tester<>(step, start, 500000, 's', length, min, max, 'i'));
                Thread quicksort_double = new Thread(new Tester<>(step, start, 500000, 'q', length, min, max, 'd'));
                Thread bubblesort_double = new Thread(new Tester<>(step, start, 500000, 'b', length, min, max, 'd'));
                Thread selectionSort_double = new Thread(
                                new Tester<>(step, start, 500000, 's', length, min, max, 'd'));
                Thread quicksort_float = new Thread(new Tester<>(step, start, 500000, 'q', length, min, max, 'f'));
                Thread bubblesort_float = new Thread(new Tester<>(step, start, 500000, 'b', length, min, max, 'f'));
                Thread selectionSort_float = new Thread(new Tester<>(step, start, 500000, 's', length, min, max, 'f'));

                quicksort_int.start();
                bubblesort_int.start();
                selectionSort_int.start();
                quicksort_double.start();
                bubblesort_double.start();
                selectionSort_double.start();
                quicksort_float.start();
                bubblesort_float.start();
                selectionSort_float.start();
        }

}
