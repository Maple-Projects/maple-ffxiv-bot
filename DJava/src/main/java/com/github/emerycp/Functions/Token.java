package com.github.emerycp.Functions;

import com.google.gson.Gson;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Token {
    public static String getToken() {
        try
        {
            Gson gson = new Gson();

            Reader reader = Files.newBufferedReader(Paths.get("package.json"));

            Map<?, ?> map = gson.fromJson(reader, Map.class);

            return map.get("token").toString();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
