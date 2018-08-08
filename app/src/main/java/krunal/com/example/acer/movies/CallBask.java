package krunal.com.example.acer.movies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by acer on 15-02-2018.
 */

public interface CallBask {

    @GET("marvel")
    Call<List<Heros>> getHerolist();
}
