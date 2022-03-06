public class Room {

    private String name;
    private Integer cap;
    private RoomType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCap() {
        return cap;
    }

    public void setCap(Integer cap) {
        this.cap = cap;
    }

    public Room(){}

    public Room(String name, int cap, RoomType type){
        this.name = name;
        this.cap = cap;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", cap=" + cap +
                ", " + type +
                '}';
    }
}
