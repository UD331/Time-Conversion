import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;


public class InputOutputGui {


    public static void create() {
        TimeZone t = new TimeZone("Europe/Paris");
        String[] list = t.getListOfZoneId();
        String[] s = {"Change Current System Time", "Change a Specific Time"};
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Time Change");
        jFrame.setResizable(true);
        jFrame.setSize(80, 280);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setLayout(new GridLayout(4,0));
        JComboBox<String> cb = new JComboBox<>(s);
        cb.setBounds(250, 250,290,220);
        jFrame.add(cb);
        JButton jButton = new JButton();
        jButton.setLayout(null);
        jButton.setBounds(300, 275, 100, 100);
        jFrame.add(jButton);

        optionZero(jFrame, jButton, cb, list, s);

        jFrame.pack();
        jFrame.setVisible(true);
    }
    public static void optionZero(JFrame jFrame, JButton jButton, JComboBox cb, String[] list, String[] s) {
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String choice;

                choice = (String) cb.getSelectedItem();
                if (choice.equalsIgnoreCase(s[0])) {
                    optionOne(jFrame, jButton, cb, list);

                } else {
                    optionTwo(jFrame, jButton, cb, list);
                }
            }
        });
    }
    public static void optionOne(JFrame jFrame, JButton jButton, JComboBox cb, String[] list) {
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
        JButton back = new JButton("Back");
        back.setVisible(true);
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
        jFrame.add(back);
        jFrame.revalidate();
        jFrame.repaint();
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                create();
            }
        });
        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j3.setText(Conversion.changeCurrentTime(jComboBox));
                jFrame.revalidate();
                jFrame.repaint();
            }
        });
    }

    public static  void optionTwo(JFrame jFrame, JButton jButton, JComboBox cb, String[] list) {
        jFrame.remove(jButton);
        jFrame.remove(cb);
        jFrame.setLayout(new FlowLayout());
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
        JButton back = new JButton("Back");
        back.setVisible(true);
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
        jFrame.add(back);
        jFrame.revalidate();
        jFrame.repaint();
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                create();
            }
        });
        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j6.setText(Conversion.changeEnteredTime(jComboBox, comboBox, hour,
                        minute, second));
                jFrame.add(j6);
                jFrame.revalidate();
                jFrame.repaint();
            }
        });
    }

    public static void main(String[] args) {
        create();
    }
}
