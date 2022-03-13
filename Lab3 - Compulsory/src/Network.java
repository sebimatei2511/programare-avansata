import java.util.ArrayList;
import java.util.List;

public class Network extends Node implements Identifiable, Storage {

    private List<Node> nodesList = new ArrayList<>();

    public Network(String name) {
        super(name);
    }

    public List<Node> getNodesList() { return nodesList; }

    public void setNodesList(List<Node> nodesList) { this.nodesList = nodesList; }

    public void addNode(Node node){
        nodesList.add(node);
    }

    public void deleteNode(Node node){ nodesList.remove(node); }


    @Override
    public String toString() {
        return "Network{ " +
                "nodesList= " + nodesList +
                " }";
    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public int getStorageCapacity() {
        return 0;
    }

    @Override
    public int compareTo(Node o) {
        return 0;
    }
}
