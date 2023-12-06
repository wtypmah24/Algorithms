package lesson_6_stack_queue.lesson20231129;

public class CustomArrayQueue {

    private int[] data;
    private int tail;
    private int head;
    private int count;

    public CustomArrayQueue(int capacity) {
        data = new int[capacity];
        count = 0;
        head = -1;
        tail = -1;
    }

    public void enqueue(int element){
        if (count >= data.length) throw new RuntimeException("Queue is full");
        if (++tail == data.length) tail = 0;
        data[tail] = element;
        if (head == -1) head++;
        count++;
    }

    public int dequeue(){
        if (count == 0) throw new RuntimeException("Queue is empty");
        int result = data[head];
        if (++head == data.length) head = 0;
        if (--count == 0) {
            head = -1;
            tail = -1;
        }
        return result;
    }
    public int search(int elem){
        for (int i = 0; i < count; i++) {
            int index = (head + i) % data.length;
            if (elem == data[i]) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CustomArrayQueue queue = new CustomArrayQueue(5);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(2);

        System.out.println(queue.search(5));
        System.out.println(queue.search(2));

        queue.dequeue();
    }


}

    //HW task 2
    /*
    * Имеется класс RandomizedQueue (см. код в репозитории). Это тип очереди, из которой данные извлекаются в случайном порядке.
    Проанализировать класс и провести оценку эффективности методов RandomizedQueue с ростом числа элементов в очереди
    асимптотическим и амортизированным анализом:

    // is the randomized queue empty?
    public boolean isEmpty() ------- O(1)

    // return the number of items on the randomized queue
    public int size() -------------- O(1)

    // add the item
    public void enqueue(Item item) -------------- amortized O(1) // worst case O(N)

    // remove and return a random item
    public Item dequeue() -------------- amortized O(1)

    // return a random item (but do not remove it)
    public Item sample() -------------- O(1)

    // return an independent iterator over items in random order
    public Iterator iterator() -------------- O(N)
    * */

