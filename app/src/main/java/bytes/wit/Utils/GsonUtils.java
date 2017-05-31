package bytes.wit.Utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by Md. Sifat-Ul Haque on 5/31/2017.
 */

public class GsonUtils {

    public static <T> List<T> toList(Gson gson, String json, Class<T> clazz) {
        if (null == json) {
            return null;
        }
        return gson.fromJson(json, new TypeToken<T>(){}.getType());
    }
}
