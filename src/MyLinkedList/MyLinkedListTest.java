package MyLinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList <String> list = new MyLinkedList<String>();
        System.out.println("The List size is " +list.size());
        list.add("A");
        System.out.println("The List size is " +list.size());
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println("The List size is " +list.size());

        System.out.println(list);

        System.out.println("The List get(0) = " + list.get(0));
        System.out.println("The List get(1) = " + list.get(1));

        list.remove(2);
        System.out.println(list);

        list.clear();
        System.out.println(list);

    }
}
