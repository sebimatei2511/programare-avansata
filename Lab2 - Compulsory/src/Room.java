public class Room {

    private static String name;
    private static Integer cap;

    public enum type {
        lab,lectureHall;
    }
    private static type roomType;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Room.name = name;
    }

    public static Integer getCap() {
        return cap;
    }

    public static void setCap(Integer cap) {
        Room.cap = cap;
    }

    public Room(){}

    public Room(String name, int cap, type roomType){
        Room.name = name;
        Room.cap = cap;
        Room.roomType = roomType;
    }
}
