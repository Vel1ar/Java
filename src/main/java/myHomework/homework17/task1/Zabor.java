package myHomework.homework17.task1;

public class Zabor {
    private int countTrue = 62 * 5 + 3 * 12;

    public void getInfo(int count) {
        if (count >= countTrue) {
            System.out.println("Забор подходит");
        } else System.out.println("Забор не подходит");
    }
}
