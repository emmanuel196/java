package com.example.test.controller;

import com.example.test.services.TimezoneServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TimezoneController {

    @Autowired
    private TimezoneServices timezoneServices;
    @CrossOrigin
    @PostMapping("/timezones")
    public String createTimezone(@RequestBody String timezone) throws JsonProcessingException {
        JsonObject object = new JsonParser().parse(timezone).getAsJsonObject();
        // first parameter hour, second parameter timezone
        return timezoneServices.getTimeZone(object.get("hour").getAsString(),object.get("timezone").getAsString());
    }
}
