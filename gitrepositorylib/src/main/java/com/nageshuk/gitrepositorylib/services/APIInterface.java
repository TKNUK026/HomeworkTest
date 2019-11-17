package com.nageshuk.gitrepositorylib.services;

import com.nageshuk.gitrepositorylib.model.Repository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface APIInterface {
    @GET("repositories")
    Call<Repository> doGetListItems(@Query("q") String platform, @Query("org") String org);
}
