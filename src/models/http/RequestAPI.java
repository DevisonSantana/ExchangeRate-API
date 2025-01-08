package models.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import models.exchange.CodesExchange;
import models.records.RCodes;

public class RequestAPI {
    private String APIKEY = "Bearer e823d0f9bf341fc53964a7ca";
    HttpClient client = HttpClient.newHttpClient();
    
    public RequestAPI () {}
    
    public RequestAPI (String code) {}
    
    public RequestAPI (String a, String b, double c) {}
    
    public void showCodes () {
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/codes");
        HttpRequest request = HttpRequest.newBuilder().uri(uri).header("Authorization", APIKEY).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            
            RCodes gson = new Gson().fromJson(json, RCodes.class);
            CodesExchange codesExchange = new CodesExchange(gson);

            codesExchange.getCodeList().forEach(System.out::println);
            
        } catch (Exception e) {
            throw new RuntimeException("Deu ruim x_x");
        }
    }
}
