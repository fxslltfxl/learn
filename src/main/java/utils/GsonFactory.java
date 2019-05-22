package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

public class GsonFactory {


    public static Gson getInstance() {
        return Holder.gson;
    }

    private static class Holder {

        private static final Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setVersion(4.5)
                .excludeFieldsWithModifiers(Modifier.FINAL)
                .create();
    }
}
