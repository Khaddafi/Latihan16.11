package com.example.latihanroom.model;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.latihanroom.source.Repository;
import java.util.List;

public class NamaViewModel extends AndroidViewModel{
    private Repository repository;

    public NamaViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public LiveData<List<NamaModel>> getListNama(){
        return repository.getListNama();
    }

    public void insertAll(List<NamaModel> namaModels){
        repository.insertAll(namaModels);
    }

}
