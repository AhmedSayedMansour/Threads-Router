import java.io.IOException;

public class Device extends Thread {
    private String name;
    private String type;
    private router x;
    private int server;
    @Override
    public void run() {
        try {
            x.connect(this);
            x.performActivity(this);
            x.disconnect(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Device(int size,router z) throws IOException {
        this.x= new router(size);
        this.x = z;

    }
    public void setNames(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNames() {
        return name;
    }

    public String getType() {
        return type;
    }
    public void setServer(int s) {
        this.server = s;
    }
    public int getServer() {
        return server;
    }
}
