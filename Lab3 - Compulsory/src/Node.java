public abstract class Node implements Identifiable, Storage{

    public String name;

    public Node(String name) { this.name = name; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return super.toString();
    }
}
