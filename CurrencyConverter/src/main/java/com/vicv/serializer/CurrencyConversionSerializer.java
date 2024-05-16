package com.vicv.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.vicv.model.CurrencyConversion;
import com.vicv.util.CommonConstants;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CurrencyConversionSerializer {
    public static void serialize(CurrencyConversion conversion, String filename) {
        List<CurrencyConversion> conversions = readFromJson();
        conversions.add(conversion);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new Gson_LocalDateTimeTypeAdapter())
                .setPrettyPrinting()
                .create();

        try (FileWriter writer = new FileWriter(filename);){
            gson.toJson(conversions, writer);
        } catch (IOException e) {
            System.err.println("Error serializing the CurrencyConversion object: " + e.getMessage());
        }
    }

    public static List<CurrencyConversion> readFromJson() {
        List<CurrencyConversion> conversions = new ArrayList<>();

        try (Reader reader = new FileReader(CommonConstants.JSON_FILE_PATH)) {
            // TypeToken is a class provided by Gson that is used to capture the type of a generic type
            // parameter during object serialization and deserialization.
            Type conversionListType = new TypeToken<List<CurrencyConversion>>(){}.getType();

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new Gson_LocalDateTimeTypeAdapter())
                    .create();

            conversions = gson.fromJson(reader, conversionListType);

        } catch (IOException e) {
            // The file may not exist yet, in which case we simply return an empty list.
        }
        return conversions;
    }
}
