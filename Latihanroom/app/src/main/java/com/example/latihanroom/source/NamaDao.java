package com.example.latihanroom.source;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.latihanroom.model.NamaModel;
import java.util.List;

@Dao
public interface NamaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<NamaModel> namaModels);

    @Query("SELECT DISTINCT * FROM namatabel ORDER BY id ASC")
    LiveData<List<NamaModel>> getListNama();

    @Query("DELETE FROM namatabel")
    void deleteAll();
}
