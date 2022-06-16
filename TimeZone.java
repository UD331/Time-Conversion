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

    public String[] getListOfZoneId() {
        Set<String> s = ZoneId.getAvailableZoneIds();
        String[] timeZones = new String[s.size()];
        int i = 0;
        for (String str : s) {
            timeZones[i] = str;
            i++;
        }
        return timeZones;
    }

    public LocalTime getZoneDateTime() {
        return LocalTime.now(zoneId); //returns only time
        //return ZonedDateTime.now(zoneId); // returns both date and time
    }

    public ZoneOffset getZoneOffset() {
        return zoneId.getRules().getOffset(Instant.now());
    }

}
