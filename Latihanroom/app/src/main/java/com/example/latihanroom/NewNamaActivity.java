package com.example.latihanroom;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.latihanroom.model.NamaModel;
import com.example.latihanroom.model.NamaViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewNamaActivity extends AppCompatActivity {
    private NamaViewModel namaViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_nama);
        namaViewModel = new ViewModelProvider(this).get(NamaViewModel.class);

        EditText editNama = findViewById(R.id.edit_nama);
        Button save = findViewById(R.id.button_save);

        save.setOnClickListener(view -> {
            String nama = editNama.getText().toString();
            if(!nama.equals("")){
                NamaModel data = new NamaModel();
                data.nama = nama;
                //namaViewModel.insertNama(data);
                finish();
            }else{
                Toast.makeText(this,"Data Tidak Boleh Kosong",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
