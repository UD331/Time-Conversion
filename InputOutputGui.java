import javax.swing.*;
import java.awt.*;

public class InputOutputGui {
    public static void main(String[] args) {
        TimeZone t = new TimeZone("Europe/Paris");
        String[] list = t.getListOfZoneId();
        String originalTimeZone;
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Time Change");
        jFrame.setResizable(false);
        jFrame.setSize(540, 480);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);
        JPanel jPanel = new JPanel();
        JButton jButton = new JButton();
        jPanel.add(jButton);
        jFrame.add(jPanel);
    }
}
