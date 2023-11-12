public class VehicleTester {
    public static void main(String[] args) {
//        Bike test1 = new Bike();
//        test1.movingForward();
//        test1.movingBackward();

        Car car = new Car(30.0);
        System.out.println(car);
        car.movingForward();
        car.movingBackward();
        System.out.println("Total Number of Vehicles: " + Vehicle.getNumVehicles());
    }
}
