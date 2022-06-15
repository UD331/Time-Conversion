import javax.swing.*;

public class Conversion {
    

    public String changeCurrentTime(JComboBox jComboBox) {
        String a = (String)jComboBox.getSelectedItem();
        TimeZone t1 = new TimeZone(a);
        return String.valueOf(t1.getZoneDateTime());
    }

    public String changeEnteredTime(JComboBox jComboBox, JComboBox comboBox, JComboBox hour,
                                    JComboBox minute, JComboBox second) {
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
        return new_time;
    }
    
}
