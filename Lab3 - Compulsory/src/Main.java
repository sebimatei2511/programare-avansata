import java.util.Collections;

public class Main {
    public static void main(String[] args){
        Node v1 = new Computer("Computer A");
        Node v2 = new Router("Router A");
        Node v3 = new Switch("Switch A");
        Node v4 = new Switch("Switch B");
        Node v5 = new Router("Router B");
        Node v6 = new Computer("Computer B");

        Network network = new Network("Graph");

        network.addNode(v1);
        network.addNode(v2);
        network.addNode(v3);
        network.addNode(v4);
        network.addNode(v5);
        network.addNode(v6);

        Collections.sort(network.getNodesList());

        System.out.println("The nodes from the network are:");
        for ( Node i : network.getNodesList())
            System.out.println(i.getName().toString());

    }
}
