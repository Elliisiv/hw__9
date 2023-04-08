package MyQueue;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.add(4);
        myQueue.add(2);
        myQueue.add(3);
        System.out.println(myQueue);
        System.out.println("The queue size is " + myQueue.size());
        System.out.println("The front element is " + myQueue.peek());
        myQueue.poll();
        System.out.println("The front element is " + myQueue.peek());

        myQueue.clear();
        System.out.println("The queue size is " + myQueue.size());
    }

}
