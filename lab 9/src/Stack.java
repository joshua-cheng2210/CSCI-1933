public class Stack<T extends Comparable<T>>{
    private int Size;
    private int max_Size;
    Node <T>node = null;
    public Stack(){
        this.Size = 0;
        max_Size = 5;
    }

    public Stack(int size){
        this.Size = 0;
        max_Size = size;
    }

    public T pop()throws StackException{
        if (Size == 0){
            Node <T>out = null;
            throw new StackException(Size);
        } else {
            Node <T>out = null;
            out.setData(node.getData());

            node = node.getNext();
            Size--;
            return out.getData();
        }
    }

    public void push(T item)throws StackException{
        if (Size == max_Size){
          throw new StackException(max_Size);
        }else {
            node = new Node<T>(item, node);
            Size++;
        }
    }
}
