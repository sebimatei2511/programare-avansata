public class Router extends Node implements Identifiable, Storage{
    public Router(String name) {
        super(name);
    }

    @Override
    public String getAddress() { return null; }

    @Override
    public int getStorageCapacity() { return 0; }

}
