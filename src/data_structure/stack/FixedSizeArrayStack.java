package stack;

public class FixedSizeArrayStack {

    protected int capacity;
    public static final int CAPACITY = 10;

    protected int[] stackRep;
    protected int top = -1;

    public FixedSizeArrayStack() {
    }

    public FixedSizeArrayStack(int cap) {
        capacity = cap;
        stackRep = new int[capacity];
    }

    public int size() {
        return (top + 1);
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public void push(int data) throws Exception {
        if(size() == capacity) {
            throw new Exception("Stack is empty");
        }

        stackRep[++top] = data;
    }


    public int top() throws Exception {
        if(isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return stackRep[top];
    }

    public int pop() throws Exception {
        int data;
        if(isEmpty()) {
            throw new Exception("Stack is Empty");
        }
        data = stackRep[top];
        stackRep[top--] = Integer.MIN_VALUE;
        return data;
    }

    public String toString() {
        String s;
        s = "[";
        if (size() > 0) {
            s += stackRep[0];
        }

        if (size() > 1) {
            for(int i =0; i<=size() -1; i++) {
                s += "," + stackRep[i];
            }
        }
        return s + "]";
    }

    public static void main(String[] args) throws Exception {
        FixedSizeArrayStack fixedSizeArrayStack = new FixedSizeArrayStack(10);
        fixedSizeArrayStack.push(10);
        fixedSizeArrayStack.push(50);
        fixedSizeArrayStack.push(5);
        System.out.println(fixedSizeArrayStack.toString());
        System.out.println(fixedSizeArrayStack.size());
        System.out.println(fixedSizeArrayStack.isEmpty());
        System.out.println(fixedSizeArrayStack.top());
        System.out.println(fixedSizeArrayStack.pop());
        System.out.println(fixedSizeArrayStack.toString());
    }
}
