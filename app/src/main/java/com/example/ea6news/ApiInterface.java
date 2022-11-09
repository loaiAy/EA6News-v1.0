package com.example.ea6news;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String base_url = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<News> getCategoryNews(
                    @Query("category") String category,
                    @Query("country") String country,
                    @Query("pageResults") int results,
                    @Query("apiKey") String apiKey
            );
}
