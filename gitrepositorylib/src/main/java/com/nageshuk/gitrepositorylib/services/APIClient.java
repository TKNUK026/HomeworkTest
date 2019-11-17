package com.nageshuk.gitrepositorylib.services;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class APIClient {

    private static final String BASE_URL = "http://api.github.com/search/";
    private static Retrofit retrofit = null;
    private static APIClient instance = null;

    private APIClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    static APIClient getInstance()
    {
        if (instance == null) {
            instance = new APIClient();
        }
        return instance;
    }

    APIInterface getServices(){
        return retrofit.create(APIInterface.class);
    }
}
