package myHomework.homework5.task2;

public class Car {

    private Integer currentSpeed = 0;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public Integer getCurrentSpeed() {
        return currentSpeed;
    }

    public void speedUp(Integer i) {
        this.currentSpeed = currentSpeed + i;
    }

    public void breakSpeed() {
        if (currentSpeed <= 10) {
            this.currentSpeed = 0;
        } else {
            this.currentSpeed = currentSpeed - 10;
        }
    }
}
