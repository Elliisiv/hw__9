package MyArrayList;

import java.util.Arrays;

public class MyArrayList <E> {

    private Object[] array = new Object[0];
    private int myIndex = 0;
    public void add(E element) {
        System.out.println("Inserting " + element);
        array = Arrays.copyOf(array, array.length +1);
        array[myIndex] = element;
        myIndex++;
    }
    public E get(int index) {
        return (E) array[index];
    }
    public void remove(int index) {
        for (int i = index; i < myIndex - 1; i++)
            array[i] = array[i + 1];
        System.out.println("Removing " + index);
        array[myIndex - 1] = null;
        myIndex--;
        array = Arrays.copyOf(array, array.length -1);
    }
    public int size() {
        return myIndex;
    }

    public void clear(){
        for (int i = 0; i<myIndex; i++) {
            array[i] = "";
            array = Arrays.copyOf(array, array.length - 1);
            myIndex--;
        }
    }

    @Override
    public String toString() {
        return "array="+Arrays.toString(array);
    }

}