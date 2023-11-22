package com.example.latihanroom.util;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static RestClient instance = null;
    private final APIService myApi;

    private RestClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(APIService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(APIService.class);
    }

    public static synchronized RestClient getInstance() {
        if (instance == null) {
            instance = new RestClient();
        }
        return instance;
    }

    public APIService getMyApi() {
        return myApi;
    }
}
