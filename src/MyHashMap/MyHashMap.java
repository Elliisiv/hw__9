package MyHashMap;

import java.security.InvalidKeyException;
import java.util.Arrays;

import static java.util.Objects.hash;

//put(Object key, Object value) додає пару ключ + значення+++++
//remove(Object key) видаляє пару за ключем
//clear() очищає колекцію+-
//size() повертає розмір колекції++
//get(Object key) повертає значення (Object value) за ключем+++
public class MyHashMap <K, V>{
    private Node<K, V>[] nodeList = new Node[ARRAY_SIZE];
    private static final int ARRAY_SIZE = 16;
    int count=0;
    public void put(K key, V value) throws InvalidKeyException {
        long hashCode = this.getHashCode(key);
        int index = this.getIndex(hashCode);
        Node newNode = new Node();
        if (index > ARRAY_SIZE) {
            throw new InvalidKeyException("Invalid key, please check again!");
        }

        if (this.nodeList[index] != null) {
            Node<K, V> exitingNode = this.nodeList[index];

            while (exitingNode.getNext() != null) {
                exitingNode = exitingNode.getNext();
            }
            newNode.setKey(key);
            newNode.setValue(value);
            newNode.setHashCode(hashCode);

            exitingNode.setNext(newNode);
            count++;


        } else {
            newNode.setKey(key);
            newNode.setValue(value);
            newNode.setHashCode(hashCode);
            count++;

            this.nodeList[index] = newNode;

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
                temp = temp.getNext(); //return value corresponding to key.
            }
            return null;   //returns null if key is not found.
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

            while(current != null){ //we have reached last entry node of bucket.
                if(current.getKey().equals(deleteKey)){
                    if(previous==null){  //delete first entry node.
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
                    if (listIndex > 0) {
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



}
