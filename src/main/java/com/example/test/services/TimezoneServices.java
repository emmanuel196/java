package com.example.test.services;

import com.example.test.dto.TimezoneDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.time.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class TimezoneServices {

    public String getTimeZone(String hour, String timeZone) throws JsonProcessingException {
        return calcTime(hour,timeZone).toString();
    }

    private String calcTime(String hour, String timezone) throws JsonProcessingException {
        LocalTime time = LocalTime.parse(hour);
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(),time);
        ZoneId zoneLocal = ZoneId.of(timezone);
        ZonedDateTime zonedDateTimeLocal = localDateTime.atZone(zoneLocal);
        ZoneId zoneUTC = ZoneId.of("UTC");
        ZonedDateTime utcTime = zonedDateTimeLocal.withZoneSameInstant(zoneUTC);
        String hourFormat = utcTime.getHour()+":"+utcTime.getMinute()+":"+utcTime.getSecond();
        ObjectMapper mapper = new ObjectMapper();
        TimezoneDTO tzDTO = new TimezoneDTO(hourFormat, utcTime.getZone().toString().toLowerCase());
        String jsonString = mapper.writeValueAsString(tzDTO);
        return "{\"response\":" + jsonString+ "}";
    }
}
