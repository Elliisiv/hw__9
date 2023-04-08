package MyStack;

import java.util.Arrays;

public class MyStack <E>{
    private Object[] myStackArr = new Object[0];
    private int top=-1;

    public MyStack() {
    }

    public void push(E element) //добавление в конец
    {
        System.out.println("Inserting " + element);
        myStackArr = Arrays.copyOf(myStackArr, myStackArr.length +1);
        myStackArr[++top] = element;

    }
    public void remove(int index) { //удаление по индексу
        for (int i = index; i < top - 1; i++)
            myStackArr[i] = myStackArr[i + 1];
        System.out.println("Removing " + index);
        myStackArr[top - 1] = 0;
        top--;
        myStackArr = Arrays.copyOf(myStackArr, myStackArr.length -1);
    }
    public int peek() //возврат первого "последнего" елемента стека
    {
        if (!isEmpty()) {
        return (int) myStackArr[top];
    }
        else {
        System.exit(-1);
    }

        return -1;
    }
        public int pop() {
            if (isEmpty())
            {
                System.out.println("Underflow\nProgram Terminated");
                System.exit(-1);
            }

            System.out.println("Removing " + peek());


            return (int) myStackArr[top--];
    }
    public void clear() {
        for (int i = 0; i < myStackArr.length; i++) {
            myStackArr[i] = 0;
            myStackArr = Arrays.copyOf(myStackArr, myStackArr.length - 1);
            top--;
        }
    }
    public int size() {
        return top + 1;
    }


    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        return "MyStack= " + Arrays.toString(myStackArr);
    }


}
