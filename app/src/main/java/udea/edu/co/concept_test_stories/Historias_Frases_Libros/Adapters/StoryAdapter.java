package udea.edu.co.concept_test_stories.Historias_Frases_Libros.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import udea.edu.co.concept_test_stories.Historias_Frases_Libros.Story;
import udea.edu.co.concept_test_stories.R;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.MyViewHolder> {

    private List<Story> storyList= new ArrayList<>();
    private int mItemSelected=-1;

    public StoryAdapter(List<Story> storyList) {
        setStoryList(storyList);
        System.out.println("SIZE"+String.valueOf(getStoryList().size()));
    }

    public List<Story> getStoryList() {
        return storyList;
    }

    public void setStoryList(List<Story> storyList) {
        this.storyList = storyList;
    }

    @Override
    public StoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_storie,viewGroup,false);
       return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StoryAdapter.MyViewHolder viewHolder, int i) {
            viewHolder.btnStory.setText("J");
    }

    @Override
    public int getItemCount() {
        return getStoryList().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public Button btnStory;

        public MyViewHolder( final View itemView) {
            super(itemView);
            btnStory=(Button)itemView.findViewById(R.id.btnStory) ;

            btnStory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("Me tocann!!!!!!!!");
                    //Open Story View Activity with position

                }
            });

        }
    }
}
