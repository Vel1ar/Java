package myHomework.homework2.task2;

public class Main2 {
    public static void main(String[] args) {
        Room firstRoom = new Room(10,10,10);
        Room secondRoom = new Room(5,5,5);
        Flat flat_1 = new Flat(firstRoom,secondRoom);

        System.out.println(flat_1.getSettingsRooms());
    }
}
