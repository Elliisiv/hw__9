package MyHashMap;

import java.security.InvalidKeyException;
import java.util.Arrays;

public class MyHashMap <K, V>{
    private Node<K, V>[] nodeList = new Node[ARRAY_SIZE];
    private static final int ARRAY_SIZE = 16;
    int count=0;
    public void put(K key, V value) throws InvalidKeyException {
        long hashCode = this.getHashCode(key);
        int index = this.getIndex(hashCode);

        if (index > ARRAY_SIZE) {
            throw new InvalidKeyException("Invalid key, please check again!");
        }
        if (this.nodeList[index] != null) {
            Node<K, V> nodeList = this.nodeList[index];
            while (nodeList.getNext() != null) {
                nodeList = nodeList.getNext();
            }
            Node<K, V> newNode = new Node<K, V>();
            newNode.setKey(key);
            newNode.setValue(value);
            newNode.setHashCode(hashCode);

            nodeList.setNext(newNode);

        } else {

            Node<K, V> newNode = new Node<K, V>();
            newNode.setKey(key);
            newNode.setValue(value);
            newNode.setHashCode(hashCode);

            this.nodeList[index] = newNode;
            count++;
        }
    }


    public V get(K key){
        int hashCode = this.getHashCode(key);
        if(nodeList[hashCode] == null){
            return null;
        }else{
            Node<K,V> temp = nodeList[hashCode];
            while(temp!= null){
                if(temp.getKey().equals(key))
                    return temp.getValue();
                temp = temp.getNext();
            }
            return null;
        }
    }

    public void clear() {
        Arrays.fill(nodeList, null);
        count = 0;
    }
    public boolean remove(K deleteKey){
        int hashCode = this.getHashCode(deleteKey);

        if(nodeList[hashCode] == null){
            return false;
        }else{
            Node<K,V> previous = null;
            Node<K,V> current = nodeList[hashCode];

            while(current != null){
                if(current.getKey().equals(deleteKey)){
                    if(previous==null){
                        nodeList[hashCode]= nodeList[hashCode].getNext();
                        count--;
                        return true;
                    }
                    else{
                        previous.setNext(current.getNext());
                        return true;

                    }
                }
                previous=current;
                current = current.getNext();
            }
            return false;
        }

    }

    public int size(){
        return count;
    }

    private int getHashCode(K key) {
        return Math.abs(key.hashCode()) % ARRAY_SIZE;
    }

    private int getIndex(long hashCode) {
        return Math.toIntExact(hashCode % ARRAY_SIZE);
    }
    public void printHashMap() {

        System.out.println("==============================================");
        System.out.println("Your Hash Map:");
        int index = 0;
        while (index < ARRAY_SIZE) {
            Node<K, V> node = this.nodeList[index];
            if (node != null) {
                int listIndex = 0;
                while (node != null) {
                    if (listIndex < 0) {
                        System.out.print(" || ");
                    }
                    System.out.print(node.getKey().toString() + " -> ");
                    System.out.print(node.getValue().toString());
                    node = node.getNext();
                    listIndex++;
                }
                System.out.println("");
            }
            index++;
        }

    }
    @Override
    public String toString() {
        return "MyHashMap{" +
                "nodeList=" + Arrays.toString(nodeList) +
                '}';
    }
    public static void main(String[] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap();
        try {
            hashMap.put(1, "One");
            hashMap.put(2, "Two");
            hashMap.put(21, "Twenty One");
            hashMap.put(22, "Twenty Two");
            hashMap.put(23, "Twenty Three");
            hashMap.put(256, "Two Hundred And Fifty Six");
            hashMap.put(1, "1");
            hashMap.put(1, "2");
            hashMap.put(1, "3");
            hashMap.printHashMap();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        System.out.println("The Hash Map size is " + hashMap.size());

        System.out.println("value corresponding to key 21="
                + hashMap.get(21));
        System.out.println("\n\nvalue corresponding to key 21 removed: "
                + hashMap.remove(21));
        hashMap.printHashMap();
        System.out.println("The Hash Map size is " + hashMap.size());
        hashMap.clear();
        hashMap.printHashMap();
        System.out.println("The Hash Map size is " + hashMap.size());
    }

}