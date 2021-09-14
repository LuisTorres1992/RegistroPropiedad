/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesrp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 *
 * @author evill
 */
public class JsonManager {

    public static String serialize(Object obj) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
         JsonParser jp = new JsonParser();
        JsonElement je = jp.parse((gson.toJson(obj)));
        return gson.toJson(je);

    }

    public static <T> T deserialize(String json, Class<T> T) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        return gson.fromJson(json, T);
    }
    public static String serializeWithEscaping(Object obj) {
        Gson gson = new GsonBuilder().create();
        return (gson.toJson(obj));

    }

    public static <T> T deserializeWithEscaping(String json, Class<T> T) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, T);
    }
}