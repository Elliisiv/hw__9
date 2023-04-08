package MyQueue;

import java.util.Arrays;

public class MyQueue <E> {
    private Object[] myQ= new Object[0];
    private int front;
    private int rear;
    private int capacity;
    private int count;
   // public MyQueue(int size) {
   //        myQ = new int[size];
   //        capacity = size;
   //        front = 0;
   //        rear = -1;
   //        count = 0;
   //    }

    public MyQueue() {
    }

    void add(E element){
        System.out.println("Inserting " + element);
        myQ = Arrays.copyOf(myQ, myQ.length +1);
        myQ[count] = element;
        count++;
    }

    public int peek()
    {
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        return (int) myQ[front];
    }
    public int poll() {

        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }

        int x = (int) myQ[front];

        System.out.println("Removing " + x);

        front = (front + 1) % size();
        count--;

        return x;
    }

    public void clear() {
        for (int i = 0; i < myQ.length; i++) {
            myQ[i]=0;
            myQ = Arrays.copyOf(myQ, myQ.length - 1);
            count--;
        }
    }
    public int size() {
        return count;
    }
    public boolean isEmpty() {
        return (size() == 0);
    }
    public boolean isFull() {
        return (size() == capacity);
    }
    @Override
    public String toString() {
        return "MyQueue =" + Arrays.toString(myQ);
    }


}
