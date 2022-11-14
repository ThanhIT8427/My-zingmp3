package com.example.zingmp3.Sevice;

public class APIService {
    private  static String base_url="https://thanhnguyen.store/zingmp3/server/";
    public static Dataservice getservice(){
        return APIRetrofit.getRetrofit(base_url).create(Dataservice.class);
    }
}
