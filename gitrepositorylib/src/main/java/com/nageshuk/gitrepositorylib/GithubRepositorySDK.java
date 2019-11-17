package com.nageshuk.gitrepositorylib;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nageshuk.gitrepositorylib.model.Item;
import com.nageshuk.gitrepositorylib.services.APIHelper;

import java.util.List;

public class GithubRepositorySDK {

    private static final String TAG = GithubRepositorySDK.class.getSimpleName();

    private GithubRepositorySDK(){}

    /**
     * Return the Items list.
     *
     * @param platform name of platform
     * @param organization name of organization
     *
     * @return If Success then returns List<Item> else null.
     * */
    @Nullable
    public static List<Item> getRepositoryInfo(@NonNull String platform, @NonNull String organization) {

        List<Item> itemsList = null;

        if (platform != null && !platform.isEmpty()
                && organization != null && !organization.isEmpty()) {
            itemsList = APIHelper.getItemsList(platform, organization);
        } else {
            if (platform == null || platform.isEmpty()) {
                Log.e(TAG, "Please provide valid platform info!");
            }
            if (organization == null || organization.isEmpty()) {
                Log.e(TAG, "Please provide valid organization info!");
            }
        }
        return itemsList;
    }
}
