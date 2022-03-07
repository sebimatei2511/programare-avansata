public class LectureHall extends Room{
    /**
     * This method helps us create a room which is also a lecture hall
     * @param name sets the name of the room
     * @param cap is the maximum capacity of the room
     * @param isVideoProjector tells us if the room has a video projector or not
     */
    public LectureHall(String name, int cap, boolean isVideoProjector) {
        super(name, cap, "LectureHall");
    }
}
