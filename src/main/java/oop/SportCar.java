package oop;

public class SportCar extends Car {
    private final int speedBoost;
    public SportCar(String name, int maxSpeed, int speedBoost) {
        super(name, maxSpeed);
        this.speedBoost = speedBoost;
    }

    @Override
    public int getSpeed() {
        return super.getSpeed() + speedBoost;
    }
}
