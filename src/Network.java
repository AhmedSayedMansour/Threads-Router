import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Network {
    public Device [] a;
    private router r;
    public int wishing;
    Network(int capacity,int wishing) throws IOException {
        r = new router(capacity);
        this.wishing = wishing;
        this.a = new Device[wishing];
        for (int i=0; i<wishing; i++){
            a[i] = new Device(capacity,r);

            String input = JOptionPane.showInputDialog("Enter Name of Device " + (i+1) );
            a[i].setNames( input.substring(0,input.indexOf(" ")));
            a[i].setType(input.substring(input.indexOf(" ")+1));
            while(input.matches("")){
                a[i].setNames( input.substring(0,input.indexOf(" ")));
                a[i].setType(input.substring(input.indexOf(" ")+1));
            }
        }
    }

    public void startNetwork(){
        for (int i=0; i<wishing; i++){
            a[i].start();
        }
    }
}
