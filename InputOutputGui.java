import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.time.*;


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
                    j3.setText(String.valueOf(LocalTime.now()));
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
                    go.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String a = (String)jComboBox.getSelectedItem();
                            TimeZone t1 = new TimeZone(a);
                            j3.setText(String.valueOf(t1.getZoneDateTime()));
                            jFrame.revalidate();
                            jFrame.repaint();
                        }
                    });
                } else {
                    jFrame.remove(jButton);
                    jFrame.remove(cb);
                    jFrame.setLayout( new GridLayout(11,0));
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
                    String[] day = {"0", "1", "2", "3", "4", "5", "6"," 7", "8"," 9", "10",
                                    "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
                                    "22", "23"};
                    String[] hr_sec = new String[60];
                    for (int i = 0; i<60; i++)
                        hr_sec[i] = String.valueOf(i);
                    JComboBox hour = new JComboBox<>(day);
                    hour.setMaximumRowCount(6);
                    JComboBox minute = new JComboBox<>(hr_sec);
                    minute.setMaximumRowCount(6);
                    JComboBox second = new JComboBox<>(hr_sec);
                    second.setMaximumRowCount(6);
                    JLabel j5 = new JLabel();
                    j5.setText("New Time");
                    JLabel j6 = new JLabel();
                    JButton go = new JButton();
                    j1.setVisible(true);
                    j2.setVisible(true);
                    j3.setVisible(true);
                    hour.setVisible(true);
                    minute.setVisible(true);
                    second.setVisible(true);
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
                    jFrame.add(hour);
                    jFrame.add(minute);
                    jFrame.add(second);
                    jFrame.add(go);
                    jFrame.add(j5);
                    jFrame.add(j6);
                    jFrame.revalidate();
                    jFrame.repaint();
                    go.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String a = (String)jComboBox.getSelectedItem();
                            String b = (String)comboBox.getSelectedItem();
                            int h = Integer.parseInt((String)hour.getSelectedItem());
                            int m = Integer.parseInt((String)minute.getSelectedItem());
                            int s = Integer.parseInt((String)second.getSelectedItem());
                            TimeZone t1 = new TimeZone(a);
                            TimeZone t2 = new TimeZone(b);
                            String off1[] = ((String.valueOf(t1.getZoneOffset()))).split(":");
                            String off2[] = ((String.valueOf(t2.getZoneOffset()))).split(":");
                            int hr_dif = Integer.parseInt(off2[0]) - Integer.parseInt(off1[0]);
                            int min_dif = Integer.parseInt(off2[1]) - Integer.parseInt(off1[1]);
                            if ((m + min_dif) >= 60) {
                                m = (min_dif + m) - 60;
                                hr_dif += 1;
                            } else
                                m = (min_dif + m);
                            if ((h + hr_dif) >= 24) {
                                h = (hr_dif + h) - 24;
                            } else
                                h = (hr_dif + h);
                            String new_time = h + ":" + m + ":" + s;
                            j6.setText(new_time);
                            jFrame.add(j6);
                            jFrame.revalidate();
                            jFrame.repaint();
                        }
                    });
                }
            }
        });

        jFrame.pack();
        jFrame.setVisible(true);
    }
}
