public class Owl {
    private String name;
    private int age;
    private double weight;
    public Owl(String nama, int tahun, double mg){
        name = nama;
        age = tahun;
        weight = mg;
    }

    public String getName(){
        return name;
    }

    public void setName(String new_name){
        name = new_name;
    }

    public int getAge(){
        return age;
    }

    public void setage(int new_age){
        age = new_age;
    }

    public double getWeight(){
        return weight;
    }

    public void setWeight(double new_weight){
        weight = new_weight;
    }

    public boolean equals(Owl other){
        if (name.equals(other.name) && age == other.age && weight == other.weight){
            return true;
        }
        return false;
    }

//    public static void main(String[] args) {
//        Owl owl1 = new Owl("owl1", 5, 12.0);
//        Owl owl2 = new Owl("owl2", 5, 12.0);
//        Owl owl3 = new Owl("owl1", 5, 12.0);
//        System.out.println(owl1.equals(owl2));
//        System.out.println(owl1.equals(owl3));
//    }

}
