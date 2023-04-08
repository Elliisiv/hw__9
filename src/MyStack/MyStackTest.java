package MyStack;

public class MyStackTest {
    public static void main (String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        System.out.println("The top element is " + myStack.peek());

        myStack.pop();

        System.out.println("The top element is " + myStack.peek());
        System.out.println("The stack size is " + myStack.size());

        myStack.remove(1);

        myStack.clear();
        System.out.println("The stack size is " + myStack.size());

    }
}
