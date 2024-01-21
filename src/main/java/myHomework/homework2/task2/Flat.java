package myHomework.homework2.task2;

public class Flat {
    private Room room_1;
    private Room room_2;

    public Flat(Room room_1, Room room_2) {
        this.room_1 = room_1;
        this.room_2 = room_2;
    }
    public String getSettingsRooms() {
        return "Room_1: " +room_1.getSettings() + "\n"+
        "Room_2: " +room_2.getSettings();
    }
}
