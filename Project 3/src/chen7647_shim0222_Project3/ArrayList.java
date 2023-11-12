public class ArrayList<T extends Comparable<T>> implements List<T> {
    private boolean Sorted;
    public int array_size;
    private T[] a;
    public ArrayList(){
        this.array_size = 2;
        this.a = (T[]) new Comparable[array_size];
        this.Sorted = true;
    }

    public boolean add(T element){
        if (element == null){
            return false;
        }
        if (a[a.length-1] != null){
            grow();
        }
        for (int i = 0; i < a.length; i++){
            if (this.a[i] == null){
                a[i] = element;
                break;
            }
        }

        this.Sorted = false;
        return true;
    }

    private void grow(){
        this.array_size *= 2;
        T[] b = (T[]) new Comparable[this.array_size];
        for (int i = 0; i < a.length; i++){
            b[i] = a[i];
        }
        this.a = b;
    }

    public boolean add(int index, T element){
        if (element == null || index < 0 || index > this.array_size){
            return false;
        }
        if (a[a.length-1] != null){
            grow();
        }
        if (a[index] == null){
            a[index] = element;
            return true;
        }else {
            T temp = a[index];
            a[index] = element;
            T temp2 = a[this.array_size / 2];
            for (int i = index + 1; i < a.length; i++) {
                temp2 = a[i];
                a[i] = temp;
                temp = temp2;
            }

            this.Sorted = false;
            return true;
        }
    }

    public int size(){
        int out = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i] != null){
                out++;
            }
        }
        return out;
    }
    public void clear(){
        this.Sorted = true;
        this.array_size = 2;
        a = (T[]) new Comparable[array_size];
    }

    public T get(int index){
        if (index < 0 || index >= this.array_size){
            return null;
        }else{
            return this.a[index];
        }
    }

    public int indexOf(T element){
        if (element == null){
            return -1;
        }
        for (int i = 0; i < this.a.length; i++){
            if (this.a[i] != null && this.a[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        for (int i = 0; i < this.a.length; i++){
            if (a[i] != null){
                return false;
            }
        }
        return true;
    }

    public void sort(){
        if (this.Sorted || this.isEmpty()){
            return ;
        }
        for (int i = 0; i < this.a.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < this.a.length - i - 1; j++) {
                if (this.a[j + 1] != null && this.a[j].compareTo(this.a[j + 1]) > 0) {
                    T temp = this.a[j];
                    this.a[j] = this.a[j + 1];
                    this.a[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
        this.Sorted = true;
    }

    public T remove(int index){
        if (index < 0 || index >= this.array_size){
            return null;
        }

        T out = this.a[index];
        for (int i = index; i < a.length - 1; i++){
            this.a[i] = this.a[i + 1];
        }
        this.a[a.length - 1] = null;

        if (this.isSorted() == false) {
            this.Sorted = false;
        } else{
            this.Sorted = true;
        }

//        this.array_size--;
        return out;
    }

    public void equalTo(T element){
        if (element == null){
            return ;
        }
        int counter = 0;
        for (int i = this.a.length - 1; i >= 0; i--){
            if (this.a[i] == element) {
                counter++;
                this.a[i] = null;
            } else if (this.a[i] != null && this.a[i] != element){
                this.a[i] = null;
            }
        }
        for (int i = 0; i < counter; i++){
            this.a[i] = element;
        }
        this.Sorted = true;
    }

    public void reverse(){
        int j = this.size() / 2;
        T temp;
        for (int i = 0; i < j; i++){
            temp = this.a[i];
            this.a[i] = this.a[this.size() - i - 1];
            this.a[this.size() - i - 1] = temp;
        }
    }

    public void merge(List<T> otherList){
        if (otherList == null){
            return ;
        }

        ArrayList<T> other = (ArrayList<T>) otherList;
        this.sort();
        other.sort();

        T[] out = (T[]) new Comparable[this.a.length + other.a.length];
        int i = 0;
        int j =0;
        int k = 0;
        while (i < this.a.length && j < other.a.length && this.a[i] != null && other.a[i] != null) {
            if (this.a[i].compareTo((T) other.a[j]) <= 0) {
                out[k++] = this.a[i++];
            } else {
                out[k++] = (T) other.a[j++];
            }
            if (this.a[i] == null){
                while (j < other.a.length) {
                    out[k++] = (T) other.a[j++];
                }
            } else if (other.a[i] == null){
                while (i < this.a.length) {
                    out[k++] = this.a[i++];
                }
            }
        }
        this.a = out;
        this.Sorted = true;
        this.array_size = this.a.length + other.a.length;
    }

    public boolean rotate(int n){
        if (n <= 0 || a.length <= 1 || this.size() <= 1){
            return false;
        }
        n = n % this.size();
        T temp;
        for (int rotation = 0; rotation < n; rotation++) {
            temp = this.a[this.size() - 1];
            this.a[this.size() - 1] = null;
            add(0, temp);
        }
        this.Sorted = false;
        return true;
    }

    public String toString(){
        String out = "";
        for (int i = 0; i < this.a.length; i++){
            out += a[i] + ", ";
        }
        return out;
    }

    public boolean isSorted(){
        for (int i = 0; i < this.size() - 1; i++){
//            System.out.println(i + " / " + this.size() + " / " + this.array_size);
            if (this.a[i] != null && this.a[i + 1] != null && this.a[i].compareTo(a[i + 1]) > 0){
                return false;
            }
        }
        return true;
    }
}