public class Event {


    private static String name;
    private static Integer size;
    private static Integer start;
    private static Integer end;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Event.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setSize(Integer size) {
        Event.size = size;
    }

    public void setStart(Integer start) {
        Event.start = start;
    }

    public void setEnd(Integer end) {
        Event.end = end;
    }

    public Event() {}

    public Event(String name, int size, int start, int end){
        Event.name = name;
        Event.size = size;
        Event.start = start;
        Event.end = end;
    }

}
