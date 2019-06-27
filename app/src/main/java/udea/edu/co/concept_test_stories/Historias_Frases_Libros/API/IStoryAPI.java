package udea.edu.co.concept_test_stories.Historias_Frases_Libros.API;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import udea.edu.co.concept_test_stories.Historias_Frases_Libros.Story;

public interface IStoryAPI {
    @GET("Stories_Phrases.json")
    Call<ArrayList<Story>> getStories();

}
