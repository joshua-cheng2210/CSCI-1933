public class Bookshelf{
    private Book[] shelf;
    private int shelf_size;
    int next_empty;

    public Bookshelf(){
        this.shelf_size = 20;
        this.shelf = new Book[shelf_size];
        this.next_empty = 0;
    }

    public Bookshelf(int i){
        this.shelf_size = i;
        this.shelf = new Book[shelf_size];
        this.next_empty = 0;
    }

    public int getshelf_size() { return this.shelf_size; }

    public Book[] getshelf() { return shelf; }

    public boolean add(Book newBook){
        if (next_empty == shelf_size){
            return false;
        } else {
            this.shelf[next_empty] = newBook;
            next_empty++;
            return true;
        }
    }

    public Bookshelf getBooksByAuthor(String author){
        Bookshelf writer = new Bookshelf(this.shelf_size);

        for (int i = 0; i < this.next_empty; i++){
            if (shelf[i].getAuthor() == author){
                // System.out.print("test");
                writer.add(shelf[i]);
            }
        }
        return writer;
    }

    public String toString(){
        String out = "";

        for (int i = 0; i < this.next_empty; i++){
            out += shelf[i].toString();
            out += "\n";
        }
        return out;
    }

    public void sort(char sortBy){
        for (int i = 0; i < next_empty; i++){
            for (int j = 0; j < next_empty - 1; j++){
                if (shelf[j].compareTo(shelf[j + 1], sortBy) > 0){
                    Book temp = shelf[j];
                    shelf[j] = shelf[j + 1];
                    shelf[j + 1] = temp;
                }
                // System.out.println(i +" " + j);
            }
        }
    }

    public static void main(String[] args) {
        Bookshelf bs = new Bookshelf(5);
        bs.add(new Book("Eragon", "Christopher Paolini", 10.0));
        bs.add(new Book("The Fellowship of the Ring", "J.R.R. Tolkein", 10.0));
        bs.add(new Book("Twilight", "Stephenie Meyer", 0.0));
        bs.add(new Book("The Diary of a Wimpy Kid", "Jeff Kinney", 0.0));
        bs.add(new Book("Dracula", "Bram Stoker", 7.5));
        System.out.println(bs.toString());
        bs.sort('a');
        System.out.println(bs);
    }
}
