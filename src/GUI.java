import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;

public class GUI {
    private JPanel panelMain;
    private JList list;

    public GUI() {
    }

    public static void main(String[] args) throws IOException {
        String capacity  = JOptionPane.showInputDialog("Enter number of WI-FI Connections");
        String wishing = JOptionPane.showInputDialog("Enter number of Devices");
        Network x = new Network(Integer.parseInt(capacity),Integer.parseInt(wishing));
        x.startNetwork();
    }
}
