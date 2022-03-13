public class Computer extends Node implements Identifiable, Storage{
    private String address;
    private int storageCapacity;

    public Computer(String name) {
        super(name);
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }

    @Override
    public int compareTo(Node o) {
        return this.getName().compareTo(o.getName());
    }
}
