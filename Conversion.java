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

    public static void main(String[] args) {
        TimeZone t1 = new TimeZone(originalTimeZone);
        TimeZone t2 = new TimeZone(changedTimeZone);
    }
}
