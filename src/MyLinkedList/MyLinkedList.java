package MyLinkedList;

public class MyLinkedList <T>{
    private Node<T> head;
    private Node<T> tail;
    int current = 0;
    int size;

 public void add(T item) {

       Node<T> node = new Node<T>();
       node.setValue(item);
     System.out.println("Inserting " + item);
       if (head == null) {
           head = node;
       } else {
           Node<T> next = head;
           while (next.getNext() != null) {
               next = next.getNext();
           }
           next.setNext(node);
       }
   }
    public int size(){
        if (head==null) return 0;
        int count = 1;
        Node<T> last = head;
        while (last.getNext()!=null){
            last=last.getNext();
            count++;
        }
        return count;
    }

    public T get(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        Node<T> search = head;
        for (int i = 0; i < index; i++) {
            search = search.getNext();
        }
        return search.getValue();
    }

    public void remove(int index) {
        Node<T> node = new Node<T>();
        if (index<0 && index >=size())  throw new IndexOutOfBoundsException();
        System.out.println("Removing " + index);
         if (index == 0) {
                head = head.getNext();
            } else{
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.getNext();
                }
                current.setNext(current.getNext().getNext());
            }
        }

   public void clear() {
       head = null;
        tail = null;
        current = 0;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node current = head;

        while (current != null) {
            if (current.getNext() == null) {
                stringBuilder.append(current.getValue());
            } else {
                stringBuilder.append(current.getValue()).append(", ");
            }
            current = current.getNext();
        }

        return "[" + stringBuilder.toString() + "]";
    }

}
