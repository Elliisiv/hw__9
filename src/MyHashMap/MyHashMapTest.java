package MyHashMap;

import java.security.InvalidKeyException;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(21, "Twenty One");
        hashMap.put(22, "Twenty Two");
        hashMap.put(23, "Twenty Three");
        hashMap.put(2, "2");
        hashMap.put(1, "1");
        hashMap.printHashMap();

        System.out.println("The Hash Map size is " + hashMap.size());

        System.out.println("value corresponding to key 21="
                + hashMap.get(21));
        System.out.println("value corresponding to key 1="
                + hashMap.get(1));
        System.out.println("\n\nvalue corresponding to key 21 removed: "
                + hashMap.remove(21));
        hashMap.printHashMap();
        System.out.println("The Hash Map size is " + hashMap.size());
        hashMap.clear();
        hashMap.printHashMap();
        System.out.println("The Hash Map size is " + hashMap.size());
    }
}

        // MyHashMap<String, String> stringHashMap = new MyHashMap();
        //
        //          try {
        //                  stringHashMap.put("One", "One");
        //                  stringHashMap.put("Two", "Two");
        //                  stringHashMap.put("Three", "Twenty One");
        //                  stringHashMap.put("Four", "Twenty Two");
        //                  stringHashMap.put("Five", "Twenty Three");
        //                  stringHashMap.put("Six", "Two Hundred And Fifty Six");
        //
        //                    stringHashMap.printHashMap();
        //           } catch (InvalidKeyException e) {
        //                   e.printStackTrace();
        //          }


