import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        ArrayList<Event> events = new ArrayList<Event>();
        ArrayList<Room> rooms = new ArrayList<Room>();

        Event C1 = new Event("C1",100,8,10);
        events.add(C1);
        System.out.println(C1.getName()+"(size="+C1.getSize()+", start="+C1.getStart()+", end="+C1.getEnd()+")");
        Event C2 = new Event("C2",100,10,12);
        events.add(C2);
        System.out.println(C2.getName()+"(size="+C2.getSize()+", start="+C2.getStart()+", end="+C2.getEnd()+")");
        Event L1 = new Event("L1",30,8,10);
        events.add(L1);
        System.out.println(L1.getName()+"(size="+L1.getSize()+", start="+L1.getStart()+", end="+L1.getEnd()+")");
        Event L2 = new Event("L2",30,8,10);
        events.add(L2);
        System.out.println(L2.getName()+"(size="+L2.getSize()+", start="+L2.getStart()+", end="+L2.getEnd()+")");

        Room room401 = new Room("401",30, Room.type.lab);
        rooms.add(room401);
        Room room403 = new Room("403",30, Room.type.lab);
        rooms.add(room403);
        Room room405 = new Room("405",30, Room.type.lab);
        rooms.add(room405);
        Room room309 = new Room("309",100, Room.type.lectureHall);
        rooms.add(room309);

    }
}
