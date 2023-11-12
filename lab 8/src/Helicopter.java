public class Helicopter extends Vehicle{
    private double mpg;
    public Helicopter(){
        nVehicles++;
        mpg = 0.3;
    }
    public Helicopter(double xxx){
        nVehicles++;
        mpg = xxx;
    }

    @Override
    public double getMPG() {
        return mpg;
    }

    public void movingUp(){
        System.out.println("Helicopter moving up");
    }

    public void movingdown(){
        System.out.println("Helicopter moving down");
    }

    public void movingForward() {
        System.out.println("Helicopter moving Forward");
    }

    @Override
    public void movingBackward() {
        System.out.println("Helicopter moving Backward");
    }

    public String toString(){
        return "Helicopter: " + Double.toString(getMPG());
    }
}
