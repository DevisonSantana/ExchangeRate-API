package models.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;

import com.google.gson.Gson;

import models.exchange.CodesExchange;
import models.exchange.ConversorDeMoeda;
import models.records.RCodes;
import models.records.RPair;

public class RequestAPI {
    private String APIKEY = "Bearer e823d0f9bf341fc53964a7ca";
    private final String ENDPOINT = "https://v6.exchangerate-api.com/v6";
    private final String CODES = "/codes";
    private final String PAIR = "/pair/";

    public RequestAPI() {
    }

    public ArrayList<String> showCodes() {
        URI uri = URI.create(ENDPOINT + CODES);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Authorization", APIKEY)
                .build();
        String json = null;
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            json = response.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        RCodes gson = new Gson().fromJson(json, RCodes.class);
        CodesExchange codesExchange = new CodesExchange(gson);
        return codesExchange.getCodeList();
    }

    public ConversorDeMoeda converteMoeda(String codigoMoeda, String codigoMoedaConverter, String valor) {
        String url = ENDPOINT + PAIR + codigoMoeda + '/' + codigoMoedaConverter + '/' + valor;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .header("Authorization", APIKEY)
        .build();
        String json = null;
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            json = response.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        RPair gson = new Gson().fromJson(json, RPair.class);
        ConversorDeMoeda conversorDeMoeda = new ConversorDeMoeda(gson);
        return conversorDeMoeda;
    }
}
