package myHomework.homework5.task2;

public class MyProgramCar {
    public static void main(String[] args) {
        Car car = new Car("Audi");
        System.out.println(car.getCurrentSpeed());
        car.speedUp(25);
        System.out.println(car.getCurrentSpeed());
        car.breakSpeed();
        System.out.println(car.getCurrentSpeed());
        car.breakSpeed();
        System.out.println(car.getCurrentSpeed());
        car.breakSpeed();
        System.out.println(car.getCurrentSpeed());
    }
}
