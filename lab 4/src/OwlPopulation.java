import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OwlPopulation {
    private String fileName;
    private Owl[] data;

    public int populateData() throws FileNotFoundException {
        File f = new File(fileName);
        Scanner scanner = new Scanner(f);

        int numLines = 0;
        while(scanner.hasNextLine()){
            numLines++;
            String s = scanner.nextLine();
        }
//        scanner.close();

        data = new Owl[numLines];   //data is is allocated the exact amount of space it needs
        scanner = new Scanner(f);

        int index = 0;
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            String[] values = s.split(",");
            data[index] = new Owl(values[0], Integer.parseInt(values[1]), Double.parseDouble(values[2]));
            index++;
        }

        return numLines;
    }

    public OwlPopulation(String file) throws FileNotFoundException {
        fileName = file;
        populateData();
    }

    public double averageAge(){
        int total_age = 0;
        for (Owl owl: data){
            total_age += owl.getAge();
        }
        return total_age / data.length;
    }

    public Owl getYoungest(){
        Owl youngest_owl = data[0];
        int[] agee = new int[data.length];

        // geting all the ages
        for (int i = 0; i < data.length; i++){
            agee[i] = data[i].getAge();
        }
        // finding the smallest age in int[] age
        int smallest = agee[0];
        for (int i = 1; i < agee.length; i++) {
            if (agee[i] < smallest) {
                smallest = agee[i];
            }
        }
        //finding how many owl has that smallest age.
        int lowest_check = 0;
        for (int i = 0; i < data.length; i++){
            if (agee[i] == smallest){
                youngest_owl = data[i];
                lowest_check++;
            }
        }

        if (lowest_check != 1){
            return youngest_owl;
        } else{
            return youngest_owl;
        }
    }

    public Owl getHeaviest(){
        Owl heaviest_owl = data[0];
        double[] ww = new double[data.length];

        //geting all teh weight
        for (int i = 0; i < data.length; i++){
            ww[i] = data[i].getWeight();
        }

        // finding the heaviest weight in int[] age
        double heaviest = ww[0];
        for (int i = 1; i < ww.length; i++) {
            if (ww[i] > heaviest) {
                heaviest = ww[i];
            }
        }

        //finding how many owl has that heaviest weight.
        int heaviest_check = 0;
        for (int i = 0; i < ww.length; i++){
            if (ww[i] == heaviest){
                heaviest_owl = data[i];
                heaviest_check++;
            }
        }

        if (heaviest_check != 1){
            return heaviest_owl;
        } else{
            return heaviest_owl;
        }
    }

    public String toString(){
        String out = "youngest owl = " + getYoungest().getAge() + "\n" + "heaviest owl = " + getHeaviest().getWeight() + "\n" + "average age = " + averageAge() + "\n";
        return out;
    }

    public boolean containsOwl(Owl other){
        for (Owl owl: data){
            if (owl.equals(other)){
                return true;
            }
        }
        return false;
    }

    public void merge(OwlPopulation other){
        int ori_pop_len = data.length;
        int other_pop_len = other.data.length;

        int counter = 0;
        for (int i = 0; i < other.data.length; i++){
            if (containsOwl(other.data[i]) == false) {
                counter++;
            }
        }

        Owl[] new_pop = new Owl[ori_pop_len + counter];

        for (int i = 0; i < data.length; i++){
            new_pop[i] = data[i];
        }



        int index = 0;
        for (int i = 0; i < other.data.length; i++){
            if (containsOwl(other.data[i]) == false) {
                new_pop[data.length + index] = other.data[i];
                index++;
            }
        }

        data = new Owl[ori_pop_len + counter];
        data = new_pop;
    }

    public int popSize(){
        return data.length;
    }

    public static void main(String[] args) {
        try {
//            The following should run when you are complete. Feel free to comment out as you see fit while you work.
            OwlPopulation pop1 = new OwlPopulation("owlPopulation1.csv");
            System.out.println(pop1.toString());
            System.out.println(pop1);
            System.out.println(pop1.popSize());

            OwlPopulation pop2 = new OwlPopulation("owlPopulation2.csv");
            System.out.println(pop2);
            System.out.println(pop2.popSize());

            pop1.merge(pop2);
            System.out.println(pop1);
            System.out.println(pop1.popSize());
        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
        }
    }
}
