import java.lang.*;
import java.util.Objects;

public class Computer extends Node implements Identifiable, Storage {

    private String address;
    private int storageCapacity;

    public Computer(String name, String address) {
        super(name);
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public long getStorageCapacity(String type) {
        int gigabytes = storageCapacity;
        int megabytes = (gigabytes * 1024);
        int kilobytes = (gigabytes * 1024 * 1024);
        long bytes = ((long) gigabytes * 1024 * 1024 * 1024);
        if (Objects.equals(type, "megabyte"))
            return megabytes;
        else if (Objects.equals(type, "kilobyte"))
            return kilobytes;
        else if (Objects.equals(type, "byte"))
            return bytes;
        else if (Objects.equals(type, "gigabyte"))
            return gigabytes;
        else
            return 0;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

}
