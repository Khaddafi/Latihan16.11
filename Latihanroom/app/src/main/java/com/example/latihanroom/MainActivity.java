package com.example.latihanroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.example.latihanroom.model.NamaModel;
import com.example.latihanroom.model.NamaViewModel;
import com.example.latihanroom.util.APIService;
import com.example.latihanroom.util.RestClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private NamaViewModel namaViewModel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        namaViewModel = new ViewModelProvider(this).get(NamaViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final WordListAdapter adapter = new WordListAdapter(new WordListAdapter.WordDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        namaViewModel.getListNama().observe(this, new Observer<List<NamaModel>>() {
            @Override
            public void onChanged(List<NamaModel> namaModels) {
                adapter.submitList(namaModels);
            }
        });



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener( view -> {
//            Intent intent = new Intent(MainActivity.this, NewNamaActivity.class);
//            startActivity(intent);
            requestData();
        });
    }

    private void requestData(){
        RestClient restClient = RestClient.getInstance();
        APIService api= restClient.getMyApi();
        Call<List<NamaModel>> call = api.getListFollowers();
        call.enqueue(new Callback<List<NamaModel>>() {
            @Override
            public void onResponse(Call<List<NamaModel>> call, Response<List<NamaModel>> response) {
                namaViewModel.insertAll(response.body());
            }

            @Override
            public void onFailure(Call<List<NamaModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}