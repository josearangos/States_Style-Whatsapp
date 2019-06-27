package udea.edu.co.concept_test_stories.Historias_Frases_Libros;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import udea.edu.co.concept_test_stories.Historias_Frases_Libros.Adapters.StoryAdapter;
import udea.edu.co.concept_test_stories.R;


public class Stories_Phrases_Fragment extends Fragment implements IStories_Phrases.IView {

    private IStories_Phrases.IPresenter presenter;
    RecyclerView recyclerStories;
    ProgressBar progressBar;

    public Stories_Phrases_Fragment() {
        presenter = new Stories_Presenter(this);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new Stories_Presenter(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stories__phrases_, container, false);
        initializeViews(view);
        presenter.getStories();
        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void displayLoader(boolean loader) {
        if(loader){
            progressBar.setVisibility(View.VISIBLE);
        }else{
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void initializeViews(View view) {
        recyclerStories = (RecyclerView)view.findViewById(R.id.recyclerStories);
        progressBar= (ProgressBar)view.findViewById(R.id.progressBar);
    }

    @Override
    public void getStories(ArrayList<Story> stories) {

        StoryAdapter storyAdapter = new StoryAdapter(stories,getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        this.recyclerStories.setLayoutManager(linearLayoutManager);
        this.recyclerStories.setAdapter(storyAdapter);


    }

    @Override
    public void displayError(String error) {
        Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
    }
}
