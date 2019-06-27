package udea.edu.co.concept_test_stories.Historias_Frases_Libros;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public interface IStories_Phrases {


    interface IView {
        void displayLoader(boolean loader);
        void initializeViews(View view);
        void getStories(ArrayList<Story> stories);
        void displayError(String error);
    }

    interface IPresenter {
        void onDestroy();
        void getStories();
    }

    interface IInteractor{
        void getStories();
    }

    interface CompleteListener {
        void onSuccess(ArrayList<Story> stories);
        void onError(String error);
    }

}
