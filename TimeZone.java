import java.time.*;

public class TimeZone {
    ZoneId zoneId;
    public TimeZone(ZoneId zoneId) {
        this.zoneId = zoneId;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public ZonedDateTime getZoneDateTime() {
        return ZonedDateTime.now(zoneId);
    }

    public ZoneOffset getZoneOffset() {
        return zoneId.getRules().getOffset(Instant.now());
    }

    public static void main(String[] args) {
        TimeZone t = new TimeZone(ZoneId.of("America/Montreal"));
        System.out.println(t.getZoneOffset());
        System.out.println(t.getZoneDateTime());
        System.out.println(t.getZoneId());
    }
}
