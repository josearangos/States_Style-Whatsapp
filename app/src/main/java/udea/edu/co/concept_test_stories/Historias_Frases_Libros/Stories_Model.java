package udea.edu.co.concept_test_stories.Historias_Frases_Libros;

import android.telecom.Call;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import udea.edu.co.concept_test_stories.Historias_Frases_Libros.API.IStoryAPI;

public class Stories_Model implements IStories_Phrases.IInteractor {

    private IStories_Phrases.CompleteListener listener;
    List<Story> stories = new ArrayList<>();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://cirene.udea.edu.co/biblioapp/historias/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    IStoryAPI iStoryAPI = retrofit.create(IStoryAPI.class);


    public Stories_Model(IStories_Phrases.CompleteListener listener) {
        this.listener = listener;
    }

    @Override
    public void getStories() {

        retrofit2.Call<List<Story>> call = iStoryAPI.getStories();

        call.enqueue(new Callback<List<Story>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Story>> call, Response<List<Story>> response) {
                if(!response.isSuccessful()){
                    System.out.println("Error: "+String.valueOf(response.body()));
                    return;
                }
                stories= response.body();
                listener.onSuccess(stories);

            }

            @Override
            public void onFailure(retrofit2.Call<List<Story>> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });


    }
}
