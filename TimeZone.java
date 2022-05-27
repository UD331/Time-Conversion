import java.time.*;
import java.util.Set;

public class TimeZone {
    ZoneId zoneId;
    public TimeZone(String zoneId) {
        this.zoneId = ZoneId.of(zoneId);
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public Set<String> getListOfZoneId() {
        return ZoneId.getAvailableZoneIds();
    }

    public ZonedDateTime getZoneDateTime() {
        return ZonedDateTime.now(zoneId);
    }

    public ZoneOffset getZoneOffset() {
        return zoneId.getRules().getOffset(Instant.now());
    }

    public static void main(String[] args) {
        TimeZone t = new TimeZone("America/Montreal");
        System.out.println(t.getZoneOffset());
        System.out.println(t.getZoneDateTime());
        System.out.println(t.getZoneId());
        Set<String> s = t.getListOfZoneId();
        for (String str : s) {
            System.out.println(str);
        }
    }
}
