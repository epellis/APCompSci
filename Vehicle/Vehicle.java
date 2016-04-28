public abstract class Vehicle {
    private String model;

    public Vehicle(String mod) {
        model = mod;
    }

    public String getModel() {
        return model;
    }

    abstract public String sound();

}
