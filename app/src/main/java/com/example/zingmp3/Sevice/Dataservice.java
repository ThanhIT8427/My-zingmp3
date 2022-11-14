package com.example.zingmp3.Sevice;

import com.example.zingmp3.Model.Advertex;
import com.example.zingmp3.Model.Album;
import com.example.zingmp3.Model.Likedsong;
import com.example.zingmp3.Model.Playlistcurrentday;
import com.example.zingmp3.Model.Themeandcategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {
    @GET("adabort.php")
    Call<List<Advertex>> getdataad();

    @GET("playlistcurrentday.php")
    Call<List<Playlistcurrentday>> getplaylistcurrentday();

    @GET("themeandcategory.php")
    Call<Themeandcategory> getthemeandcategory();

    @GET("album.php")
    Call<List<Album>> getalbum();

    @GET("likedsong.php")
    Call<List<Likedsong>> getlikedsong();

    @FormUrlEncoded
    @POST("listadsong.php")
    Call<List<Likedsong>> getlistadsong(@Field("idquangcao") int id);

    @FormUrlEncoded
    @POST("listadsong.php")
    Call<List<Likedsong>> getlistplaylistsong(@Field("idplaylist") int id);

    @GET("Allplaylist.php")
    Call<List<Playlistcurrentday>> getallplaylist();

    @FormUrlEncoded
    @POST("updateluotthich.php")
    Call<List<Likedsong>> updatelikedsong(@Field("idbupdateluotthich") int idbaihat);
}
