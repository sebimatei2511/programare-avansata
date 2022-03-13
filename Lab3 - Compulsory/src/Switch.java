public class Switch extends Node implements Identifiable, Storage{
    public Switch(String name) {
        super(name);
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
        return this.getName().compareTo(o.getName());
    }
}
