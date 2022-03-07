import java.util.ArrayList;
import java.util.List;

public class Network extends Node implements Identifiable, Storage {

    List<Node> nodesList = new ArrayList<>();

    public Network(String name) {
        super(name);
    }

    public List<Node> getNodesList() { return nodesList; }

    public void setNodesList(List<Node> nodesList) { this.nodesList = nodesList; }

    public void addNode(Node node){
        nodesList.add(node);
    }

    @Override
    public String toString() {
        return "Network{ " +
                "nodesList= " + nodesList +
                " }";
    }

}
