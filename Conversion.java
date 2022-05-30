import java.time.ZoneOffset;

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
        TimeZone t1 = new TimeZone(originalTimeZone);
        TimeZone t2 = new TimeZone(changedTimeZone);
        ZoneOffset z1 = t1.getZoneOffset();
        ZoneOffset z2 = t2.getZoneOffset();


    }
}
