package lesson_6_stack_queue.lesson20231129;

public class SpecialStack {

    private CustomArrayStack data;
    private CustomArrayStack minValues;

    public SpecialStack(int capacity) {
        data = new CustomArrayStack(capacity);
        minValues = new CustomArrayStack(capacity);
    }

    public void push(int element) { // O(1)
        data.push(element);
        if (!minValues.isEmpty()){
            int currentMin = minValues.peek();
            minValues.push(Math.min(element, currentMin));
        } else {
            minValues.push(element);
        }
    }

    public int pop(){ // O(1)
        int result = data.pop();
        minValues.pop();
        return result;
    }

    public int getMin(){ // O(1)
        return minValues.peek();
    }

    public static void main(String[] args) {
        SpecialStack stack = new SpecialStack(5);
        stack.push(18);
        stack.push(19);
        stack.push(29);
        stack.push(15);
        stack.push(16);
        System.out.println(stack.getMin()); // 15
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin()); // 18
        stack.push(5);
        System.out.println(stack.getMin()); // 5
    }

}
