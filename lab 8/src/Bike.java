public class Bike implements Drivable{

    @Override
    public void movingForward() {
        System.out.println("Bike moving Forward");
        int a = 0;
    }

    @Override
    public void movingBackward() {
        System.out.println("Bike moving Backward");
    }

    public void test(){
        System.out.println("testing 123");
    }

}
