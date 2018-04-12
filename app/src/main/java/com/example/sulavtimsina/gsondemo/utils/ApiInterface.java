package com.example.sulavtimsina.gsondemo.utils;

import com.example.sulavtimsina.gsondemo.model.Product;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    //echoJson.php will be appended at the end of BASE_URL in ApiClient.java
    @GET("{itemId}")
    Call<Product> getProduct(@Path("itemId") int id, @Query("apiKey") String apiKey, @Query("format") String format);
}
