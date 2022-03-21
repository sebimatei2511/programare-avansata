public class Street {
    String name;
    int lenght;
    Intersection node1, node2;
    int numberOfJoins;

    public int getNumberOfJoins() {
        return numberOfJoins;
    }

    public void setNumberOfJoins(int numberOfJoins) {
        this.numberOfJoins = numberOfJoins;
    }

    public Street(String name,
                  int lenght,
                  Intersection node1,
                  Intersection node2) {
        this.name = name;
        this.lenght = lenght;
        this.node1 = node1;
        this.node2 = node2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public Intersection getNode1() {
        return node1;
    }

    public void setNode1(Intersection node1) {
        this.node1 = node1;
    }

    public Intersection getNode2() {
        return node2;
    }

    public void setNode2(Intersection node2) {
        this.node2 = node2;
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", lenght=" + lenght +
                ", node1=" + node1 +
                ", node2=" + node2 +
                '}';
    }
}
