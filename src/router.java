import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class router {
    public int size;
    semaphore available;
    ArrayList<Integer>q=new ArrayList<Integer>();
    router(int size) {
        this.size = size;
        available =  new semaphore(size);
        for (int i=1;i<=size;i++) {
            q.add(i);
        }
    }
    public synchronized int getQ() {
        int i=q.get(0);
        q.remove(0);
        return i;
    }
    public synchronized void setQ(int i) {
        q.add(i);
    }
    public void connect(Device x) throws IOException {
        available.P(x);
    }

    public void performActivity (Device x) throws IOException {
        Random ran = new Random();
        int rand = ran.nextInt(5000);
        x.setServer(getQ());
        FileWriter myWriter = new FileWriter("Output.txt",true);
        myWriter.write("connection"+x.getServer()+" :"+x.getNames()+" Performs Online activity\n");
        myWriter.close();
        try {
            Thread.sleep((long) rand);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void disconnect(Device x) throws IOException {
        setQ(x.getServer());
        FileWriter myWriter = new FileWriter("Output.txt",true);
        myWriter.write("(" + x.getNames()+ ")(" + x.getType() + ")" + "Logged out\n");
        myWriter.close();
        available.V();
    }
}