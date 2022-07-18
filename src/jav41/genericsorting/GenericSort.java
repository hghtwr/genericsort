package jav41.genericsorting;

import java.util.Arrays;
import java.util.Random;

public class GenericSort<T> {

    private T data;

    public GenericSort(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public T bubbleSort() {

    }

    public T selectionSort() {

    }

    public T quickSort() {

    }

    public static int[] create_array(Integer length) {
        Random rd = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = rd.nextInt(100);
        }
        return array;
    }

}
