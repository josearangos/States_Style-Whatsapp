package udea.edu.co.concept_test_stories.Historias_Frases_Libros.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import udea.edu.co.concept_test_stories.Historias_Frases_Libros.Story;
import udea.edu.co.concept_test_stories.Historias_Frases_Libros.Story_View.Story_View_Activity;
import udea.edu.co.concept_test_stories.R;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.MyViewHolder> {

    private ArrayList<Story> storyList= new ArrayList<Story>();
    private int mItemSelected=-1;
    private Context mContext;


    public StoryAdapter(ArrayList<Story> storyList, Context mContext) {
        this.storyList = storyList;
        this.mContext = mContext;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public ArrayList<Story> getStoryList() {
        return storyList;
    }

    public void setStoryList(ArrayList<Story> storyList) {
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

                   Intent intent = new Intent(getmContext(),Story_View_Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Stories",getStoryList());
                    bundle.putInt("POSITION",7);
                    intent.putExtras(bundle);
                    getmContext().startActivity(intent);

                }
            });

        }
    }
}
