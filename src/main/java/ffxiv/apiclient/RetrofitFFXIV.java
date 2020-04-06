package ffxiv.apiclient;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import javax.net.ssl.*;

public class RetrofitFFXIV {

    private ServiceFFXIV service;
    private static RetrofitFFXIV INSTANCE = new RetrofitFFXIV();
    public static RetrofitFFXIV getInstance() { return  INSTANCE; }
    public ServiceFFXIV getService(){
        return service;
    }


    public RetrofitFFXIV(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://xivapi.com/")
                .build();
        service = retrofit.create(ServiceFFXIV.class);
    }
}