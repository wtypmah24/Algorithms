package lesson_5_arraylist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomIterator implements Iterator<Integer>{
    int index = 0;
    int size;
    int[] arr;
    public CustomIterator(int[] array) {
        this.size = array.length;
        this.arr = array;
    }
    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public Integer next() {
        if (hasNext())throw new NoSuchElementException();
        int num = arr[index];
        index++;
        return num;
    }
}
