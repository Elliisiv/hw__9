package MyHashMap;

import java.security.InvalidKeyException;
import java.util.Arrays;

public class MyHashMap <K, V>{
    private Node<K, V>[] nodeList = new Node[ARRAY_SIZE];
    private static final int ARRAY_SIZE = 16;
    private static final float TH = ARRAY_SIZE*0.75f;
    int count=0;
    //        long hashCode = this.getHashCode(key);
    //        int index = this.getIndex(hashCode);
    //
    //        if (index > ARRAY_SIZE) {
    //            throw new InvalidKeyException("Invalid key, please check again!");
    //        }
    //        if (this.nodeList[index] != null) {
    //            Node<K, V> nodeList = this.nodeList[index];
    //            while (nodeList.getNext() != null) {
    //                nodeList = nodeList.getNext();
    //            }
    //            Node<K, V> newNode = new Node<K, V>();
    //            newNode.setKey(key);
    //            newNode.setValue(value);
    //            newNode.setHashCode(hashCode);
    //
    //            nodeList.setNext(newNode);
    //
    //        } else {
    //
    //            Node<K, V> newNode = new Node<K, V>();
    //            newNode.setKey(key);
    //            newNode.setValue(value);
    //            newNode.setHashCode(hashCode);
    //
    //            this.nodeList[index] = newNode;
    //            count++;
    //        }
    public void put(K key, V value)  {
        if(key==null)
            return;
        int hashCode=this.getHashCode(key);

        Node<K,V> newEntry = new Node<K,V>(key, value, null);
        if(nodeList[hashCode] == null){
            nodeList[hashCode] = newEntry;
            count++;
        }else{
            Node<K,V> previous = null;
            Node<K,V> current = nodeList[hashCode];

            while(current != null){
                if(current.getKey().equals(key)){
                    if(previous==null){
                        newEntry.setNext(current.getNext());
                        nodeList[hashCode]=newEntry;
                        return;
                    }
                    else{
                        newEntry.setNext(current.getNext());
                        previous.setNext(newEntry);
                        return;
                    }
                }
                previous=current;
                current = current.getNext();
            }
            previous.setNext(newEntry);
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