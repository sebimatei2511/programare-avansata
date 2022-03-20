public class Street {
    String name;
    int lenght;
    Intersection node1, node2;

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
