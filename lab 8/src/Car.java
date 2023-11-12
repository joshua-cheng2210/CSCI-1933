public class Car extends Vehicle{
    private double mpg;
    public Car(){
        nVehicles++;
        mpg = 30.0;
    }
    public Car(double xxx){
        nVehicles++;
        mpg = xxx;
    }

    public double getMPG() {
        return mpg;
    }

    public void movingForward() {
        System.out.println("Car moving Forward");
    }

    @Override
    public void movingBackward() {
        System.out.println("Car moving Backward");
    }

    public String toString(){
        return "Car: " + Double.toString(getMPG());
    }
}
