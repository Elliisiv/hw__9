package MyStack;

import java.util.Arrays;

public class MyStack <E>{
    private int[] myStackArr;
    private int top;
    private int capacity;

    public MyStack(int size) {
        myStackArr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int element) //добавление в конец
    {
        if (isFull())
        {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(-1);
        }

        System.out.println("Inserting " + element);
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
        return myStackArr[top];
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

            // уменьшаем размер stack на 1 и (необязательно) возвращаем извлеченный элемент
            return (int) myStackArr[top--];
    }
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            myStackArr = Arrays.copyOf(myStackArr, myStackArr.length - 1);
            capacity--;
        }
    }
    public int size() {
        return top + 1;
    }

    // Вспомогательная функция для проверки, пуст stack или нет
    public boolean isEmpty() {
        return top == -1;               // или return size() == 0;
    }

    // Вспомогательная функция для проверки, заполнен ли stack или нет
    public boolean isFull() {
        return top == capacity - 1;
    }
    @Override
    public String toString() {
        return "MyStack= " + Arrays.toString(myStackArr);
    }

}
