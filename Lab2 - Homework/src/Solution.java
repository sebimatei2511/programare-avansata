import java.util.ArrayList;

public class Solution {
    private final ArrayList<Event> eventsList;
    private final ArrayList<Event> eventsResult;
    private final ArrayList<Room> roomsList;
    private final ArrayList<Room> roomsResult;

    /**
     * This method created a new solution for the required problem.
     * @param problem represents a problem-type object with which we will work later
     */
    public Solution(Problem problem){
        eventsList = problem.getEvents();
        eventsResult = new ArrayList<>();
        roomsList = problem.getRooms();
        roomsResult = new ArrayList<>();
    }

    /**
     * This method consists in the main code which create a feasible solution for the
     * input problem
     */
    public void algorithm(){
        // create a boolean matrix which will have the functions of a classic timetable
        boolean[][] timeTable = new boolean[6][eventsList.size()];
        //When we get a candidate room for our event, we mark in the timetable that
        //this room is occupied between the hours when the event is taking place.
        //When we find an eligible room, we add the event and the room in the results lists,
        // so they will have the same index there
        for (Event event : eventsList) {
            for (int j = 0; j < roomsList.size(); j++) {
                if (event.getSize() <= roomsList.get(j).getCap()
                        && !timeTable[(event.getStart() / 2) - 4][j]) {
                    eventsResult.add(event);
                    roomsResult.add(roomsList.get(j));
                    //this formula down below transforms the start time into an index: 8->0, 10->1, etc
                    timeTable[(event.getStart() / 2) - 4][j] = true;
                    break;
                }
            }
        }

        for ( int i =0; i < eventsResult.size(); i++)
            System.out.println(eventsResult.get(i).getName()
                    + " -> " + roomsResult.get(i).getName());

    }

    
}
