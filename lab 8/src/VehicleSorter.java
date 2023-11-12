import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class VehicleSorter {
	public static void main(String[] args) {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();

		//TODO: add vehicle objects of different types to your list
		//	e.g. vehicles.add(new Vehicle());

		Car aa = new Car(20);
		Car bb = new Car(23);
		Helicopter cc = new Helicopter(90);
		Helicopter dd = new Helicopter();
		Train ee = new Train();
		Train ff = new Train(90);

		vehicles.add(aa);
		vehicles.add(bb);
		vehicles.add(cc);
		vehicles.add(dd);
		vehicles.add(ee);
		vehicles.add(ff);

		Collections.sort(vehicles);
		for (Vehicle v : vehicles) {
			System.out.println(v);
		}
	}
}
