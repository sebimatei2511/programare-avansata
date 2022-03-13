import java.lang.instrument.Instrumentation;
import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node>{

    public String name;
    private Map<Node, Integer> cost = new HashMap<>();

    public Map<Node, Integer> getCost() {
        return cost;
    }

    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    public Node(String name) { this.name = name; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public int compareTo(Node other) {
        if (this.getName()!=null)
            return this.getName().compareTo(other.getName());
        else
            return 0;

    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                '}';
    }

}


