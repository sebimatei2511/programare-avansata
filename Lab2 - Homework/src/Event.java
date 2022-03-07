public class Event {

    private String name;
    private Integer size;
    private Integer start;
    private Integer end;

    /**
     *
     * @return the name of an event
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name sets the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return how much people attend to the event
     */
    public Integer getSize() {
        return size;
    }

    /**
     *
     * @param size sets how much people attend to the event
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     *
     * @return the time when the event begins
     */
    public Integer getStart() {
        return start;
    }

    /**
     *
     * @param start sets the time when the event begins
     */
    public void setStart(Integer start) {
        this.start = start;
    }

    /**
     *
     * @return the time when the event ends
     */
    public Integer getEnd() {
        return end;
    }

    /**
     *
     * @param end sets the time when the event ends
     */
    public void setEnd(Integer end) {
        this.end = end;
    }

    /**
     * This method is the constructor af the event
     * @param name sets the name
     * @param size sets how much people will attend
     * @param start sets the time when it starts
     * @param end sets the time when it ends
     */
    public Event(String name, int size, int start, int end){
        this.name = name;
        this.size = size;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event event)) return false;
        return getName().equals(event.getName())
                && getSize().equals(event.getSize())
                && getStart().equals(event.getStart())
                && getEnd().equals(event.getEnd());
    }

}
