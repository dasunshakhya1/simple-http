package core;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class JsonParser {
    private static final Gson GSON = new Gson();

    public static <T> T convertJsonStringToObject(Class<T> type, String json) {
        return GSON.fromJson(json, type);

    }

    public static <T> List<T> convertJsonStringToObjectList(Class<T> type, String json) {
        Type userListType = TypeToken.getParameterized(List.class, type).getType();
        return GSON.fromJson(json, userListType);
    }

    public static <T> String convertObjectToString(T type) {
        return GSON.toJson(type);
    }


}
