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
        jFrame.setResizable(true);
        jFrame.setSize(340, 280);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setLayout(new GridLayout(4,0));
        JComboBox<String> cb = new JComboBox<>(s);
        cb.setBounds(250, 250,290,220);
        jFrame.add(cb);
        JButton jButton = new JButton();
        jButton.setLayout(null);
        jButton.setBounds(300, 275, 100, 100);
        jFrame.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String choice;

                choice = (String) cb.getSelectedItem();
                if (choice.equalsIgnoreCase(s[0])) {
                    jFrame.remove(jButton);
                    jFrame.remove(cb);
                    jFrame.setLayout( new GridLayout(5,0));
                    JLabel j1 = new JLabel();
                    j1.setText("Please select new Timezone");
                    JComboBox jComboBox = new JComboBox<>(list);
                    jComboBox.setMaximumRowCount(3);
                    JLabel j2 = new JLabel();
                    j2.setText("New Time");
                    JLabel j3 = new JLabel();
                    JButton go = new JButton();
                    j1.setVisible(true);
                    j2.setVisible(true);
                    j3.setVisible(true);
                    jComboBox.setVisible(true);
                    go.setVisible(true);
                    jFrame.add(j1);
                    jFrame.add(jComboBox);
                    jFrame.add(go);
                    jFrame.add(j2);
                    jFrame.add(j3);
                    jFrame.revalidate();
                    jFrame.repaint();
                } else {
                    jFrame.remove(jButton);
                    jFrame.remove(cb);
                    jFrame.setLayout( new GridLayout(9,0));
                    JLabel j1 = new JLabel();
                    j1.setText("Please select original Timezone");
                    JComboBox jComboBox = new JComboBox<>(list);
                    jComboBox.setMaximumRowCount(3);
                    JLabel j2 = new JLabel();
                    j2.setText("Please select new Timezone");
                    JComboBox comboBox = new JComboBox<>(list);
                    comboBox.setMaximumRowCount(3);
                    JLabel j3 = new JLabel();
                    j3.setText("Please select the time");
                    JLabel j4 = new JLabel();
                    JLabel j5 = new JLabel();
                    j5.setText("New Time");
                    JLabel j6 = new JLabel();
                    JButton go = new JButton();
                    j1.setVisible(true);
                    j2.setVisible(true);
                    j3.setVisible(true);
                    j4.setVisible(true);
                    j5.setVisible(true);
                    j6.setVisible(true);
                    comboBox.setVisible(true);
                    jComboBox.setVisible(true);
                    go.setVisible(true);
                    jFrame.add(j1);
                    jFrame.add(jComboBox);
                    jFrame.add(j2);
                    jFrame.add(comboBox);
                    jFrame.add(j3);
                    jFrame.add(j4);
                    jFrame.add(go);
                    jFrame.add(j5);
                    jFrame.add(j6);
                    jFrame.revalidate();
                    jFrame.repaint();
                }
            }
        });

        jFrame.pack();
        jFrame.setVisible(true);
    }
}
