package com.yeolmok.aichat;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeTools {

    @Tool(description = "Returns the current time in ISO-8601 format")
    public String getTime() {
        ZonedDateTime now = ZonedDateTime.now();
        return now.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
}
