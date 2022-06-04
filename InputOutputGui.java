import javax.swing.*;
import java.awt.*;

public class InputOutputGui {
    public static void main(String[] args) {
        TimeZone t = new TimeZone("Europe/Paris");
        String[] list = t.getListOfZoneId();
        String originalTimeZone;
        String[] s = {"Change Current System Time", "Change a Specific Time"};
        String a;
        a = String.valueOf(JOptionPane.showInputDialog(null,
                "Please select in which manner you would like to make changes",
                "Time Conversion", JOptionPane.QUESTION_MESSAGE, s, s[0]));
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Time Change");
        jFrame.setResizable(false);
        jFrame.setSize(540, 480);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setLayout(new GridLayout(4,0));
        jFrame.pack();
        jFrame.setVisible(true);
        JPanel jPanel = new JPanel();
        JButton jButton = new JButton();
        jPanel.add(jButton);
        jFrame.add(jPanel);
    }
}
