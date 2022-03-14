import java.util.*;

public class Network extends Node {

    private List<Node> nodesList = new ArrayList<>();
    private List<Node> identifiableNodesList = new ArrayList<>();

    public Network(String name) {
        super(name);
    }

    public List<Node> getNodesList() { return nodesList; }

    public void setNodesList(List<Node> nodesList) { this.nodesList = nodesList; }

    public void addNode(Node node){
        nodesList.add(node);
    }

    public void deleteNode(Node node){ nodesList.remove(node); }

    public void setIdentifiableNodes(){
        for(Node i : getNodesList()){
            if(i instanceof Computer || i instanceof Router)
                identifiableNodesList.add(i);
        }
    }

    public List<Node> getIdentifiableNodesList() {
        return identifiableNodesList;
    }

    //algorithm to sort 2 nodes by their addresses, using .compareTo
    public void orderByAddress(){
        Collections.sort(getIdentifiableNodesList(), new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if ( o1 instanceof Computer) {
                    if (o2 instanceof Computer)
                        return ((Computer) o1).getAddress().compareTo(((Computer) o2).getAddress());
                    else if (o2 instanceof Router)
                        return ((Computer) o1).getAddress().compareTo(((Router) o2).getAddress());
                }
                else
                    if ( o1 instanceof Router){
                        if ( o2 instanceof Computer)
                            return ((Router) o1).getAddress().compareTo(((Computer) o2).getAddress());
                        else
                        if ( o2 instanceof Router)
                            return ((Router) o1).getAddress().compareTo(((Router) o2).getAddress());
                    }
                return 0;
            }
        });
    }


    @Override
    public String toString() {
        return "Network{ " +
                "nodesList= " + nodesList +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Network network)) return false;
        return Objects.equals(getNodesList(), network.getNodesList()) && Objects.equals(identifiableNodesList, network.identifiableNodesList);
    }

}
