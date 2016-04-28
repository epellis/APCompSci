
public class FastCar extends Car {

    //add code for constructor and any needed methods
    public FastCar(String mod) {
        super(mod);
    }

    public String sound() {
        return super.sound() + super.sound() + super.sound();
    }

}
