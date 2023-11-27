package lesson_5_arraylist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomDynamicArray implements Iterable<Integer> {

    private int[] data;
    private int count;
    private int size;

    public CustomDynamicArray() {
        this.data = new int[1];
        this.count = 0;
        this.size = 1;
    }

    public CustomDynamicArray(int size) {
        this.data = new int[size];
        this.count = 0;
        this.size = size;
    }

    public void add(int element){ // O(1) amortized,  O(n) - worst case
        if (count == size){
            growSize();
        }
        data[count++] = element;
    }

    public void addAt(int index, int element){ // O(n)
        if (index < 0 || index >= count) throw new RuntimeException("Index is out of bounds");
        if (count == size){
            growSize();
        }
        for (int i = count - 1; i >= index ; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        count++;
    }

    private void growSize() {
        int[] newArray = new int[size * 2];
        for (int i = 0; i < data.length; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
        size = size * 2;
    }

    public void shrinkSize(){ // O(n)
        if (count < size){
            int[] newArray = new int[count];
            for (int i = 0; i < count; i++) {
                newArray[i] = data[i];
            }
            data = newArray;
            size = count;
        }
    }

    public void remove(){ // O(1)
        data[--count] = 0; // make link to object null for GC
    }

    public void removeAt(int index){ // O(n)
        if (index < 0 || index >= count) throw new RuntimeException("Index is out of bounds");

        for (int i = index; i < count; i++) {
            data[i] = data[i+1];
        }
        data[--count] = 0;
    }

    public void set(int index, int element){ // O(1)
        if (index < 0 || index >= count) throw new RuntimeException("Index is out of bounds");
        data[index] = element;
    }

    public int get(int index){ // O(1)
        if (index < 0 || index >= count) throw new RuntimeException("Index is out of bounds");
        return data[index];
    }

    public void clear(){ // O(1)
        data = new int[0];
        size = 1;
        count = 0;
    }

    public int contains(int element){ // O(n)
        for (int i = 0; i < count; i++) {
            if (data[i] == element) return i;
        }
        return -1;
    }

    public boolean isEmpty(){ // O(1)
        return count == 0;
    }

    public static void main(String[] args) {
        CustomDynamicArray array = new CustomDynamicArray();
        array.printInnerStructure();
        array.add(10);
        array.printInnerStructure();
        array.add(20);
        array.printInnerStructure();
        array.add(30);
        array.printInnerStructure();
        array.add(40);
        array.printInnerStructure();
        array.add(50);
        array.printInnerStructure();
        System.out.println(array);

        array.addAt(2, 999);
        array.printInnerStructure();

        array.shrinkSize();
        array.printInnerStructure();

        array.remove();
        System.out.println(array);
        array.printInnerStructure();

        array.removeAt(2);
        array.printInnerStructure();

        System.out.println(array.contains(20));
        System.out.println(array.contains(0));

        array.add(0);
        System.out.println(array.contains(0));
        System.out.println(array);

        System.out.println("Loop with iterator:");
        for (Integer e : array) {
            System.out.println(e);
        }
    }

    public void printInnerStructure(){
        System.out.println("Inner Structure: " + Arrays.toString(data));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("CustomDynamicArray[");
        for (int i = 0; i < count; i++) {
            result.append(data[i]).append(", ");
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public Iterator<Integer> iterator() { // TODO
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < count;
            }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException();
                int num = data[index];
                index++;
                return num;
            }
        };
    }
}
