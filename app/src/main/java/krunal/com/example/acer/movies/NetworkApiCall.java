package krunal.com.example.acer.movies;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by acer on 15-02-2018.
 */

public class NetworkApiCall {

    public static final String BASE_URL = "https://simplifiedcoding.net/demos/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                    .build();

        }
        return retrofit;
    }
}
