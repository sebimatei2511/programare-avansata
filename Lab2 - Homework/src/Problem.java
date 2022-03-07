import java.util.ArrayList;

public class Problem {

    ArrayList<Event> events = new ArrayList<>();
    ArrayList<Room> rooms = new ArrayList<>();

    /**
     *
     * @return the events list
     */
    public ArrayList<Event> getEvents() {
        return events;
    }

    /**
     *
     * @return the rooms list
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     * This method adds an event and check if it was already added
     * @param event is an event we want to add
     */
    public void addEvent(Event event){
        for (Event value : events)
            if (event.equals(value)) {
                System.out.println("You entered the same event twice!!!");
                return;
            }

        events.add(event);
    }

    /**
     * This method prints the events list
     */
    public void printEvents(){
        for (Event event : events) System.out.println(event.toString());
    }

    /**
     * This method adds a room and check if it was already added
     * @param room is a room we want to add
     */
    public void addRoom(Room room){
        for (Room value : rooms)
            if (room.equals(value)) {
                System.out.println("You entered the same room twice!!!");
                return;
            }
        rooms.add(room);
    }

    /**
     * This method prints the rooms list
     */
    public void printRooms(){
        for (Room room : rooms) System.out.println(room.toString());
    }
}
