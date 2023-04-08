package MyArrayList;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        System.out.println("The List size is " + myArrayList.size());
        myArrayList.add("123");
        System.out.println(myArrayList);
        myArrayList.add("igor");
        System.out.println(myArrayList);
        myArrayList.add("liza");
        System.out.println(myArrayList);
        System.out.println("The search element is " + myArrayList.get(1));
        System.out.println("The List size is " + myArrayList.size());

        myArrayList.remove(1);
        System.out.println(myArrayList);
        System.out.println("The List size is " + myArrayList.size());
        myArrayList.clear();
        System.out.println("The List size is " + myArrayList.size());


    }
}
