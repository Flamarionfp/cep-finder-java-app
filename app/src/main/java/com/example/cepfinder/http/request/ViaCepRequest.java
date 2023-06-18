package com.example.cepfinder.http.request;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ViaCepRequest {
    private static final String VIA_CEP_URL = "https://viacep.com.br/ws/%s/json/";

    public static String handle(String postalCode) throws Exception {
        OkHttpClient client = new OkHttpClient();
        String url = String.format(VIA_CEP_URL, postalCode);
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new Exception("Unexpected response code: " + response.code());
            }
        }
    }
}
