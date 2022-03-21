import java.util.*;

public class City {

    List<Intersection> intersectionsList;
    LinkedList<Street> streetsList;
    Set<Intersection> intersectionSet;

    public City(List<Intersection> intersectionsList, LinkedList<Street> streetsList, Set<Intersection> intersectionSet) {
        this.intersectionsList = intersectionsList;
        this.streetsList = streetsList;
        this.intersectionSet = intersectionSet;
    }

    public List<Intersection> getIntersectionsList() {
        return intersectionsList;
    }

    public void setIntersectionsList(List<Intersection> intersectionsList) {
        this.intersectionsList = intersectionsList;
    }

    public LinkedList<Street> getStreetsList() {
        return streetsList;
    }

    public void setStreetsList(LinkedList<Street> streetsList) {
        this.streetsList = streetsList;
    }
}
