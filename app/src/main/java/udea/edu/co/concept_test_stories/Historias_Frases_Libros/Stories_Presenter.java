package udea.edu.co.concept_test_stories.Historias_Frases_Libros;

import java.util.ArrayList;
import java.util.List;

public class Stories_Presenter implements IStories_Phrases.IPresenter, IStories_Phrases.CompleteListener {

    IStories_Phrases.IView view;
    IStories_Phrases.IInteractor interactor;


    public Stories_Presenter(IStories_Phrases.IView view) {
        this.view = view;
        interactor = new Stories_Model(this);
    }

    @Override
    public void onDestroy() {
        view=null;
    }

    @Override
    public void getStories() {
        if(view !=null){
            view.displayLoader(true);
            interactor.getStories();
        }
    }

    @Override
    public void onSuccess(List<Story> stories) {
        view.displayLoader(false);
        view.getStories(stories);
    }

    @Override
    public void onError(String error) {
        view.displayLoader(false);
        view.displayError(error);
    }
}
