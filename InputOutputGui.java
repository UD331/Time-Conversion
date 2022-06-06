import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputOutputGui {
    public static void main(String[] args) {
        TimeZone t = new TimeZone("Europe/Paris");
        String[] list = t.getListOfZoneId();
        String originalTimeZone;
        String[] s = {"Change Current System Time", "Change a Specific Time"};
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Time Change");
        jFrame.setResizable(false);
        jFrame.setSize(340, 280);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setLayout(new GridLayout(4,0));
        JComboBox<String> cb = new JComboBox<>(s);
        cb.setBounds(250, 250,290,220);
        jFrame.add(cb);
        JButton jButton = new JButton();
        jButton.setLayout(null);
        jButton.setBounds(300, 275, 100, 100);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String choice;

                choice = (String) cb.getSelectedItem();

                System.out.println(choice);
            }
        });
        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
