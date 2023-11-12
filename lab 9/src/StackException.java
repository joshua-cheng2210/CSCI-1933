public class StackException extends Exception{
    int Size;
    public StackException(int size){
        this.Size = size;
    }

    public int getSize(){
        return this.Size;
    }
}
