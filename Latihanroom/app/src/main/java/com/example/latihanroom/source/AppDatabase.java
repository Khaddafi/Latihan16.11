package com.example.latihanroom.source;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.latihanroom.model.NamaModel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {NamaModel.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "NAMAMHS";
    public abstract NamaDao namaDao();

    public static volatile AppDatabase INSTANCE = null;
    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .build();
        }
        return INSTANCE;
    }

}
