public class Main {
    public static void main(String[] args){
        Computer v1 = new Computer("Computer A","6130254970");
        Router v2 = new Router("Router A","2013650798");
        Switch v3 = new Switch("Switch A");
        Switch v4 = new Switch("Switch B");
        Router v5 = new Router("Router B","9046307548");
        Computer v6 = new Computer("Computer B","5013790457");

        Network network = new Network("Graph");

        network.addNode(v1);
        network.addNode(v2);
        network.addNode(v3);
        network.addNode(v4);
        network.addNode(v5);
        network.addNode(v6);

        v1.setCost(v2,10);
        v1.setCost(v3,50);
        v2.setCost(v3,20);
        v2.setCost(v4,20);
        v2.setCost(v5,10);
        v3.setCost(v4,20);
        v4.setCost(v5,30);
        v4.setCost(v6,10);
        v5.setCost(v6,20);

        for(Node i : network.getNodesList())
            System.out.println(i.getName()+": "+i.getCost().toString());

        System.out.println();
        System.out.println("Showing the storage capacity of '"+v1.getName()+"' in other units of storage:");
        v1.setStorageCapacity(10);
        System.out.println(v1.getStorageCapacity("byte"));
        System.out.println();

        network.setIdentifiableNodes();
        System.out.println("The identifiable nodes list:");
        System.out.println(network.getIdentifiableNodesList());
        network.orderByAddress();
        System.out.println("The ordered identifiable nodes list:");
        System.out.println(network.getIdentifiableNodesList());


    }
}
