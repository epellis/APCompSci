import java.util.ArrayList;
import java.util.List;


public class VehiclePool {

    private List<Vehicle> poolList;

    public VehiclePool() {
        poolList = new ArrayList<Vehicle>();
        poolList.add(new Truck("F-150"));
        poolList.add(new Car("Chevy"));
        poolList.add(new FastCar("Maserati"));
        poolList.add(new Truck("Dodge Ram"));
        poolList.add(new FastCar("BMW Z4"));
    }

    //prints the model followed by the sound of every vehicle in PoolList
    //one vehicle per line
    public void testAllVehicles() {
        //add your code here
        for (int i = 0; i < poolList.size(); i++) {
            System.out.println("Model: " + poolList.get(i).getModel() + ", Sound: " + poolList.get(i).sound());
        }
    }

    public static void main(String[] args) {
        VehiclePool vp = new VehiclePool();
        vp.testAllVehicles();
    }
}
