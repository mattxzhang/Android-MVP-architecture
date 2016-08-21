package com.kai.android_mvp_architecture.network;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;


public class APIService {
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

    public interface WeatherApi {
        @GET("geocoding")
        Call<CityGeoInfo> getWeather(
                @Query("cityCode") String cityCode);
    }

    public static void test(final Context context) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApi weatherApi = retrofit.create(WeatherApi.class);

        Call<CityGeoInfo> call = weatherApi.getWeather("武汉");


        call.enqueue(new Callback<CityGeoInfo>() {
            @Override
            public void onResponse(Response<CityGeoInfo> response) {
                Toast.makeText(context,"onResponse",Toast.LENGTH_SHORT).show();
                System.out.println("-------response:"+response);
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(context,"onFailure",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
