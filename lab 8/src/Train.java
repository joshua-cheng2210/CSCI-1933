public class Train extends Vehicle{
    private double mpg;
    public Train(){
        nVehicles++;
        mpg = 470.0;
    }
    public Train(double xxx){
        nVehicles++;
        mpg = xxx;
    }


    public double getMPG() {
        return mpg;
    }

    public void enteringStation(){
        System.out.println("Train entering station");
    }

    public void leavingStation(){
        System.out.println("Train exiting station");
    }

    public void movingForward() {
        System.out.println("Train moving Forward");
    }

    public void movingBackward() {
        System.out.println("Train moving Backward");
    }

    public String toString(){
        return "Train: " + Double.toString(getMPG());
    }
}
