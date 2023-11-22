package com.example.latihanroom.util;

import com.example.latihanroom.model.NamaModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    String BASE_URL = "https://api.github.com/users/sidiqpermana/";

    @GET("followers")
    Call<List<NamaModel>> getListFollowers();


}
