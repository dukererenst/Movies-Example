package krunal.com.example.acer.movies;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private RecyclerView mrecyclerView;
    private RecycleAdapter recycleAdapter;
    private CallBask mcallBack;
    private Retrofit mRetrofit;
    private Call<List<Heros>> mgetCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView= findViewById(R.id.imageView);
        mRetrofit = NetworkApiCall.getRetrofit();
        mrecyclerView = findViewById(R.id.recyclerView2);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mcallBack = mRetrofit.create(CallBask.class);

        mgetCallback = mcallBack.getHerolist();

        if (CheckInterConnection(this)) {
            mImageView.setVisibility(View.INVISIBLE);
            mImageView = null;

            mgetCallback.enqueue(new Callback<List<Heros>>() {
                @Override
                public void onResponse(Call<List<Heros>> call, Response<List<Heros>> response) {
                    List<Heros> list = response.body();
                    recycleAdapter = new RecycleAdapter(getApplication(), list);
                    mrecyclerView.setAdapter(recycleAdapter);
                }

                @Override
                public void onFailure(Call<List<Heros>> call, Throwable t) {
                    Toast.makeText(getApplication(), "Fail to Load", Toast.LENGTH_LONG).show();
                }
            });
        }else {
            mrecyclerView.setVisibility(View.INVISIBLE);
            recycleAdapter = null;
            mcallBack = null;
            mRetrofit = null;
            mgetCallback = null;
            mImageView.setVisibility(View.VISIBLE);
        }


    }

    private boolean CheckInterConnection(Context context){
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

}
