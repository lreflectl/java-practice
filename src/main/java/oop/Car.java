package oop;

public class Car implements Vehicle {
    private final String name;
    private final int maxSpeed;
    private int currentSpeed = 0;
    private boolean isStarted = false;

    public Car(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void start() {
        if (!isStarted) {
            isStarted = true;
            currentSpeed = maxSpeed;
            System.out.println(name + " is started.");
        } else {
            System.out.println(name + " is already started.");
        }
    }

    @Override
    public int getSpeed() {
        return currentSpeed;
    }
}
