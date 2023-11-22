package com.example.latihanroom.source;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.latihanroom.model.NamaModel;

import java.util.List;

public class Repository {
    private final AppDatabase appDatabase;

    public Repository(Application application) {
        appDatabase = AppDatabase.getInstance(application);
    }

    public LiveData<List<NamaModel>> getListNama(){
        return appDatabase.namaDao().getListNama();
    }



    public void insertAll(List<NamaModel> namaModels){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            appDatabase.namaDao().insertAll(namaModels);
        });
    }



}
