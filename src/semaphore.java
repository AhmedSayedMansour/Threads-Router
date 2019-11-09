import java.io.FileWriter;
import java.io.IOException;

public class semaphore {
    protected int value = 0 ;
    protected semaphore() { value = 0 ; }
    protected semaphore(int initial) { value = initial ; }
    public synchronized void P(Device x) throws IOException {
        FileWriter myWriter = new FileWriter("Output.txt",true);
        value-- ;
        if (value < 0){
            myWriter.write("(" + x.getNames()+ ")(" + x.getType() + ")" + "arrived and waiting\n");
            try { wait() ; } catch( InterruptedException e ) { }
        }
        myWriter.write("(" + x.getNames()+ ")(" + x.getType() + ")" +"arrived and Occupied\n");
        myWriter.close();
    }
    public synchronized void V() {
        value++ ; if (value <= 0) notify() ;
    }

}

