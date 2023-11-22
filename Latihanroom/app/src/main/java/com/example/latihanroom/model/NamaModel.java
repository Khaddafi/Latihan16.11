package com.example.latihanroom.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "namatabel",indices = @Index(value = {"id"},unique = true))
public class NamaModel {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    @SerializedName("id")
    public int id;

    @ColumnInfo(name = "nama")
    @SerializedName("login")
    public String nama;
}
