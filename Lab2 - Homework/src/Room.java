import java.util.Objects;

public abstract class Room {

    private String name;
    private Integer cap;
    private final String type;

    /**
     *
     * @return the name of the room
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name sets the name of the room
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return the capacity of the room
     */
    public Integer getCap() {
        return cap;
    }

    /**
     *
     * @param cap sets the capacity of the room
     */
    public void setCap(Integer cap) {
        this.cap = cap;
    }

    /**
     * This method is the constructor of the room
     * @param name is the name
     * @param cap is the capacity
     * @param type is the type of the room: LectureHall or ComputerLabs
     */
    public Room(String name, int cap, String type){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room room)) return false;
            return getName().equals(room.getName()) && getCap().equals(room.getCap()) && Objects.equals(type, room.type);
    }

}
