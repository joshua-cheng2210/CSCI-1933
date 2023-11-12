import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class BookshelfReader {
    public static Bookshelf readBooksFromFile(String filename) throws FileNotFoundException{
        Bookshelf out;
        File f = new File(filename);
        Scanner scanner = new Scanner(f);

        // read the file for the first time to count how many lines are there in the file or in other word count how many books are there
        int numLines = 0;
        while(scanner.hasNextLine()){
            numLines++;
            String s = scanner.nextLine();
        }

        // create a new bookshelf with size of the amount of lines previously counted
        out = new Bookshelf(numLines);
        // restart the pointer of reading the file back to the beginning
        scanner = new Scanner(f);

        // writing all the books in the read from the file into "out" which is a bookshelf object
        int index = 0;
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            String[] values = s.split(",");
            Book temp = new Book(values[0], values[1], Double.parseDouble(values[2]));
            // System.out.println(temp);
            out.add(temp);
            index++;
        }
        
        // System.out.println(out);
        return out;
    }

    public static void writeShelfToFile(Bookshelf b, String fileName){
        // assume our filename is stored in the string fileName
        Scanner s = null; // declare s outside try-catch block
        try {
            s = new Scanner(new File(fileName));
            // System.out.println("test1");
        } catch (FileNotFoundException e) { // returns false if fails to find fileName
            System.out.println("No such filename"); // return an
            // error message to the user
        }
        // Now use s in the same way we used Scanners previously for user input
        // To write to an arbitrary textfile, do the following:
        // assume our filename is stored in the string fileName
        // System.out.println("test2");
        PrintWriter p = null; // declare p outside try-catch block
        try {
            // System.out.println("test3");
            p = new PrintWriter(new File(fileName));
            // System.out.println("test4");
            // writing the books into the newfile
            for (int i = 0; i < b.getshelf_size() ; i++) {
                Book book = b.getshelf()[i];
                p.println(book.toString());
                // System.out.println("test5");
            }
            // p.println("hello"); // "hello" is added to the file, ending with newline character (\n)
            p.close();//if you do not close the file, the output file will remain
        } catch (FileNotFoundException e) {
            System.out.println("No such filename"); // return an error message to the user
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Bookshelf temp = null;
        try {
            temp = new Bookshelf(100);
            temp = readBooksFromFile("bookinput.txt");
            temp.sort('r');
            // System.out.println(temp);
            writeShelfToFile(temp, "bookoutput.txt");
        } catch (FileNotFoundException f){
            System.out.println("File not found.");
        }
    }
}
