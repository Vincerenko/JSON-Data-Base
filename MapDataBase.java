package server;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MapDataBase {
    private static final Map<String, String> MAP = new HashMap<>();
    Gson gson = new Gson();
    public String set(String key, String value) {
        MAP.put(key,value);

        return "{\"response\":\"OK\"}";
    }

    public String get(String value) {
        if (MAP.containsKey(value)) {
            return "{\"response\":\"OK\",\"value\":\""+MAP.get(value)+"\"}";
        }
        else{
            return "{\"response\":\"ERROR\",\"reason\":\"No such key\"}";
        }

    }

    public String delete(String key) {
        if (MAP.containsKey(key)) {
            MAP.remove(key);
            return "{\"response\":\"OK\"}";
        }
        else{
            return "{\"response\":\"ERROR\",\"reason\":\"No such key\"}";
        }

    }

}
