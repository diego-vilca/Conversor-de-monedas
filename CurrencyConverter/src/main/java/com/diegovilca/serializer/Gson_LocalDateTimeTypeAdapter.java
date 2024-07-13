package com.diegovilca.serializer;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.diegovilca.calc.CurrencyCalculator;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.diegovilca.util.CommonConstants.DATETIME_PATTERN;

public class Gson_LocalDateTimeTypeAdapter extends TypeAdapter<LocalDateTime> {
    @Override
    public void write(JsonWriter jsonWriter, LocalDateTime localDateTime) throws IOException {
        jsonWriter.value(CurrencyCalculator.formatDateTime(localDateTime, DATETIME_PATTERN));
    }

    @Override
    public LocalDateTime read(JsonReader jsonReader) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATETIME_PATTERN);
        return LocalDateTime.parse( jsonReader.nextString(), formatter);
    }
}
