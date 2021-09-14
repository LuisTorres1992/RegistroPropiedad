/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesrp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Dictionary;
import java.util.Map;

/**
 *
 * @author evill
 */
public class RequestManager {

    public static <T> T post(Object param, String host, String method, Class<T> T, String token, String userHandler) throws Exception {
        URL url = new URL(host + method);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        try {
            conn.addRequestProperty("Content-Type", "application/json");
            conn.addRequestProperty("entityHandler", userHandler);
            conn.addRequestProperty("DeviceHeader", "186.46.57.100");
            if (token != null) {
                if (!token.isEmpty()) {
                    conn.addRequestProperty("Authorization", "Bearer " + token);
                }
            }
            conn.setUseCaches(false);

            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            //conn.connect();
            OutputStream os = conn.getOutputStream();
            String body = JsonManager.serializeWithEscaping(param);
            os.write(body.getBytes());
            os.flush();
            os.close();
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
           // System.out.println("Output from Server .... \n");

            while ((output = br.readLine()) != null) {
                //System.out.println(output);
                conn.disconnect();
                //System.out.println(output);
                return JsonManager.deserialize(output, T);
            }

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage() + " .... \n");

        } catch (IOException e) {
            System.out.println(e.getMessage() + " .... \n");
        } catch (Exception e) {
            System.out.println(e.getMessage() + " .... \n");
        }
        conn.disconnect();
        return null;
    }
    
     public static  <T> T get2(Map<String, String> params, String host, String method, Class<T> T, String token, String entityhandler) throws MalformedURLException, IOException {
   StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> param : params.entrySet()) {
            if (builder.toString().isEmpty()) {

                builder.append("?" + param.getKey() + "=" + param.getValue());
            } else {
                builder.append("&" + param.getKey() + "=" + param.getValue());
            }
        }
        URL url = new URL(host + method + builder.toString());    
         
       
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
       

             conn.addRequestProperty("entityHandler", entityhandler);
             conn.addRequestProperty("DeviceHeader", "186.46.57.100");
            if (token != null) {
                if (!token.isEmpty()) {
                    conn.addRequestProperty("authorization", "Bearer " + token);
                }
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
               
         System.out.println(sb.toString());
        
     conn.disconnect();
         T ret =  JsonManager.deserialize(sb.toString(), T);
       return ret ; 
     }
    public static <T> T get(Map<String, String> params, String host, String method, Class<T> T, String token, String entityhandler) throws MalformedURLException, IOException {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> param : params.entrySet()) {
            if (builder.toString().isEmpty()) {

                builder.append("?" + param.getKey() + "=" + param.getValue());
            } else {
                builder.append("&" + param.getKey() + "=" + param.getValue());
            }
        }
        URL url = new URL(host + method + builder.toString());      
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.addRequestProperty("Content-Type", "application/json");       
        try {
            conn.addRequestProperty("DeviceHeader", "186.46.57.100");
            conn.addRequestProperty("entityHandler", entityhandler);
            if (token != null) {
                if (!token.isEmpty()) {
                    conn.addRequestProperty("authorization", "Bearer " + token);
                }
            }
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");

            OutputStream os = conn.getOutputStream();
            conn.connect();
            os.flush();
            os.close();
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
           // System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                //System.out.println(output);
                conn.disconnect();
                //System.out.println(output);
                return JsonManager.deserialize(output, T);
            }
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }

        conn.disconnect();
        return null;
    }
}
