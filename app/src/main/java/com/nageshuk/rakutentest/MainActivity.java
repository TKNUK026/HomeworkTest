package com.nageshuk.rakutentest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.nageshuk.gitrepositorylib.GithubRepositorySDK;
import com.nageshuk.gitrepositorylib.model.Item;

import java.util.List;

// Sample code for testing sdk.
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new AsyncTaskExample().execute();
    }

    private static class AsyncTaskExample extends AsyncTask<String, String, List<Item>> {

        @Override
        protected void onPreExecute() {
            Log.d(TAG, "onPreExecute()");
        }

        @Override
        protected List<Item> doInBackground(String... strings) {
            Log.d(TAG, "doInBackground()");
            return GithubRepositorySDK.getRepositoryInfo("android", "rakutentech");
        }

        @Override
        protected void onPostExecute(List<Item> items) {
            super.onPostExecute(items);
            Log.d(TAG, "onPostExecute()");
            if (items != null && !items.isEmpty()) {
                Log.d(TAG, "items size = " + items.size());
                for (Item i : items) {
                    Log.d(TAG, "Name = " + i.getName());
                    Log.d(TAG, "Privacy status = " + i.getStatusesUrl());
                    Log.d(TAG, "Description = " + i.getDescription());
                    Log.d(TAG, "Language = " + i.getLanguage());
                }
            } else {
                Log.d(TAG, "Empty items");
            }
        }
    }
}
