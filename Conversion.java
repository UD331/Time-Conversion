import java.lang.reflect.Array;
import java.time.ZoneOffset;
import java.util.Arrays;

public class Conversion {

    public static String originalTimeZone;
    public static String changedTimeZone;
    public static String originalTime;
    public static String changedTime;

    public Conversion(String originalTime, String originalTimeZone,
                      String changedTime, String changedTimeZone) {
        this.originalTime = originalTime;
        this.originalTimeZone = originalTimeZone;
        this.changedTime = changedTime;
        this.changedTimeZone = changedTimeZone;
    }

    public void changeCurrentTime() {

    }

    public void changeEnteredTime() {

    }

    public static void main(String[] args) {
        //TimeZone t1 = new TimeZone(originalTimeZone);
        //TimeZone t2 = new TimeZone(changedTimeZone);
        TimeZone t1 = new TimeZone("America/Montreal");
        TimeZone t2 = new TimeZone("Europe/Paris");
        ZoneOffset z1 = t1.getZoneOffset();
        ZoneOffset z2 = t2.getZoneOffset();
        String s1 = String.valueOf(z1);
        String s2 = String.valueOf(z2);
        String[] v1 = s1.split(":");
        String[] v2 = s2.split(":");
        System.out.println(Arrays.toString(v1));
        System.out.println(Arrays.toString(v2));
        int a = Integer.parseInt(v2[0]) - Integer.parseInt(v1[0]);
        int b = Integer.parseInt(v2[1]) - Integer.parseInt(v1[1]);
        System.out.println(a);
        System.out.println(b);
    }
}
