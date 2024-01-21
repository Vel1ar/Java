package myHomework.homework2.task2;

public class Room {
    private int height;
    private int width;
    private int length;

    public Room(int height, int width, int length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }
    public String getSettings(){
        return "height = "+ height +
                " width = " + width +
                " length = "+ length;
    }
}
