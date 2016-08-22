package com.kai.android_mvp_architecture.network;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitSimpleExample {
    public static final String API_URL = "http://gc.ditu.aliyun.com/";

    public static class CityGeoInfo {
        public final String lon;
        public final String level;
        public final String address;
        public final String cityName    ;
        public final String alevel;
        public final String lat;

        public CityGeoInfo(String lon, String level, String address, String cityName, String alevel, String lat) {
            this.lon = lon;
            this.level = level;
            this.address = address;
            this.cityName = cityName;
            this.alevel = alevel;
            this.lat = lat;
        }
    }

    public interface CityGeoInfoApi {
        @GET("geocoding")
        Call<CityGeoInfo> getCityGeoInfo(
                @Query("cityCode") String cityCode);
    }

    public static void test(final Context context) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CityGeoInfoApi weatherApi = retrofit.create(CityGeoInfoApi.class);

        Call<CityGeoInfo> call = weatherApi.getCityGeoInfo("武汉");

        call.enqueue(new Callback<CityGeoInfo>() {
            @Override
            public void onResponse(Call<CityGeoInfo> call, Response<CityGeoInfo> response) {
                if (response.isSuccessful()){
                    System.out.println("-------response:success"+response);
                }else {
                    System.out.println("-------response:failed"+response);
                }
                Toast.makeText(context,"onResponse",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CityGeoInfo> call, Throwable t) {
                Toast.makeText(context,"onFailure",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
