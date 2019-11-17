package com.nageshuk.gitrepositorylib.services;

import android.util.Log;

import androidx.annotation.Nullable;

import com.nageshuk.gitrepositorylib.model.Item;
import com.nageshuk.gitrepositorylib.model.Repository;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class APIHelper {

    private static final String TAG = APIHelper.class.getSimpleName();

    @Nullable
    public static List<Item> getItemsList(String platform, String organization) {
        List<Item> itemsList =  null;

        // Get the ApiClient instance.
        APIInterface apiService = APIClient.getInstance().getServices();

        Call<Repository> call = apiService.doGetListItems(platform, organization);
        try {
            Response<Repository> responseRepository = call.execute();
            if (responseRepository.body() != null) {
                if (responseRepository.isSuccessful()) {
                    itemsList = responseRepository.body().getItems();
                } else {
                    if (responseRepository.errorBody() != null) {
                        Log.e(TAG, "Response error body : " + responseRepository.errorBody().toString());
                    }
                }
            }
        } catch (IOException | NullPointerException e) {
            Log.e(TAG, "Exception : " + e.getMessage());
        }
        return itemsList;
    }
}