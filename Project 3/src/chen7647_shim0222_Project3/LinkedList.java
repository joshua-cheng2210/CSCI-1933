public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> head;
    private int array_size;
    private boolean Sorted;
    public LinkedList() {
        this.head = null;
        this.array_size = 0;
        this.Sorted = true;
    }
    private Node get_last_node(Node n){
        Node temp = n;
        while (temp.getNext() != null){
            temp = temp.getNext();
        }
        return temp;
    }
    private Node get_index_node(int n){
        Node curr = this.head;

        for(int i = 0; i < n - 1; i++){ // i think i iterate one time less
            curr = curr.getNext();
//            n--;
        }
        return curr;
    }
    @Override
    public boolean add(T element) {
        if (element == null) {
            return false;
        }
        Node<T> newNode = new Node<T>(element);
        if (this.head == null) {
            this.head = newNode;
            this.array_size++;
            return true;
        } else {
            Node<T> curr = this.head;
            curr = this.get_last_node(curr);
            curr.setNext(newNode);
            this.Sorted = false;
        }
        this.array_size++;
//            System.out.println(array_size);
        return true;
    }

    @Override
    public boolean add(int index, T element) {
        if (element == null || index < 0 || index > array_size) {
            return false;
        } else {
            this.array_size++;
            this.Sorted = false;
        }
        Node<T> newNode = new Node<T>(element);
        if (index == 0) {
            newNode.setNext(this.head);
            this.head = newNode;
            this.array_size++;
            this.Sorted = false;
            return true;
        }
        Node<T> curr = this.head;
        curr = this.get_index_node(index);
        newNode.setNext(curr.getNext());
        curr.setNext(newNode);

        return true;
    }

    @Override
    public void clear() {
        head = null;
        array_size = 0;
        Sorted = true;
    }

    public T get(int index) {
        if(index < 0 || index >= this.size()){
            return null;
        }else{
            Node<T> curr = this.head;
            curr = this.get_index_node(index + 1);
            T out = curr.getData();
            return out;
        }
    }

    @Override
    public int indexOf(T element) {
        Node curr = this.head;
        for (int i = 0; i < this.array_size; i++) {
            if (curr.getData().equals(element)) {return i;}
            curr = curr.getNext();
        }
        return -1;
    }

    public boolean isEmpty() {
        Node curr = this.head;
        while (curr != null){
            if (curr.getData() != null){return false;}
            curr = curr.getNext();
        }
        return true;
    }

    public int size() {
        Node current = this.head;
        int out = 0;
        while (current != null){
            if (current.getData() != null){
                out++;
            }
            current = current.getNext();
        }
        return out;
    }

    public void sort() {
        if (this.array_size <= 1) {
            return;
        }
        boolean swapped = true;
        Node<T> left = head;
        Node<T> right = null;

        while(swapped) {
            swapped = false;
            left = head;
            while (left.getNext() != right) {
                if (left.getData().compareTo(left.getNext().getData()) > 0) {
                    // swap left and left.next
                    T temp = left.getData();
                    left.setData(left.getNext().getData());
                    left.getNext().setData(temp);
                    swapped = true;
                }
                left = left.getNext();
            }
            right = left;
        }
    }

    public T remove(int index) {
        if (index < 0 || index >= this.array_size) {
            return null;
        }
        T out;
        if (index == 0) {
            out = head.getData();
            head = head.getNext();
            this.array_size--;
            return out;
        }
        Node curr = this.head;
        for (int i = 0; i < index - 1; i++){
            curr = curr.getNext();
        }
        out = (T) curr.getNext().getData();
        curr.setNext(curr.getNext().getNext());

        this.array_size--;
        return out;
    }

    @Override
    public void equalTo(T element) {
        if (element == null) {
            return;
        }
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            if (!curr.getData().equals(element)) {
                if (prev == null) {
                    this.head = curr.getNext();
                } else {
                    prev.setNext(curr.getNext());
                }
                this.array_size--;
            } else {
                prev = curr;
            }
            curr = curr.getNext();
        }
    }

    @Override
    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }

    @Override
    public void merge(List<T> otherList) {
        if (otherList == null) {
            return;
        }

        LinkedList<T> other = (LinkedList<T>) otherList;

        this.sort();
        other.sort();

        Node<T> current1 = head;
        Node<T> current2 = other.head;

        // Create a dummy head node for the merged list
        Node<T> dummyHead = new Node<T>(null);
        Node<T> tail = dummyHead;

        // Merge the two sorted lists into a new list
        while (current1 != null && current2 != null) {
            if (current1.getData().compareTo(current2.getData()) <= 0) {
                tail.setNext(current1);
                current1 = current1.getNext();
            } else {
                tail.setNext(current2);
                current2 = current2.getNext();
            }
            tail = tail.getNext();
        }

        // Append the remaining nodes from either list
        if (current1 != null) {
            tail.setNext(current1);
        } else if (current2 != null) {
            tail.setNext(current2);
        }

        // Update the head of the merged list
        head = dummyHead.getNext();
        this.array_size += other.size();
        this.Sorted = true;
    }

    @Override
    public boolean rotate(int n) {
        if (n <= 0 || array_size <= 1 || head == null) {
            return false;
        }
        n = n % array_size;
        if (n == 0) {
            return true;
        }
        Node<T> newTail = head;
        for (int i = 0; i < array_size - n - 1; i++) {
            newTail = newTail.getNext();
        }
        Node<T> newHead = newTail.getNext();
        newTail.setNext(null);
        Node<T> tail = newHead;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        tail.setNext(head);
        head = newHead;
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            sb.append(curr.getData()).append("\n");
            curr = curr.getNext();
        }
        return sb.toString();
    }

    public boolean isSorted() {
        if (head == null || head.getNext() == null) {
            return true; // empty list or single-element list is always sorted
        }

        Node<T> current = head;
        while (current.getNext() != null) {
            if (current.getData().compareTo(current.getNext().getData()) > 0) {
                return false; // not sorted
            }
            current = current.getNext();
        }
        return true; // sorted
    }
}
