package udea.edu.co.concept_test_stories.Historias_Frases_Libros.Story_View;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.shts.android.storiesprogressview.StoriesProgressView;
import retrofit2.http.GET;
import udea.edu.co.concept_test_stories.Historias_Frases_Libros.Story;
import udea.edu.co.concept_test_stories.R;

public class Story_View_Activity extends AppCompatActivity  implements StoriesProgressView.StoriesListener {


    private ArrayList<Story> storyList = new ArrayList<Story>();
    private int POSITION_INITAL =0;
    private StoriesProgressView storiesProgressView;
    private TextView author,phrase;
    private LinearLayout content_phrase;
    long pressTime = 0L;
    long limit = 500L;
    private int counter = 0;

    /*private  String[][] resources_Phrases ={
            {"Aristóteles","El fin de la ciencia especulativa es la verdad, y el fin de la ciencia práctica es la acción.","#00574B","#FFFFFF","","20sp","40sp"},
            {"Marie Curie (1867 – 1934)","“Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.”","#00574B","#FFFFFF","","20sp","40sp"},
            {"Georg Lichtenberg (1742 – 1799)","“Es extraño que sólo las personas extraordinarios hagan descubrimientos que luego aparecen de manera fácil y sencilla”","#00574B","#FFFFFF","","20sp","40sp"},
            {"Galileo Galilei (1564 – 1642)","“No se puede enseñar nada a un hombre, sólo se le puede ayudar a descubrirse a sí mismo”","#00574B","#FFFFFF","","20sp","40sp"},
            {"John Archibald Wheeler (1911 – 2008)","“No existe una ley excepto la ley de que no hay ley”\n","#00574B","#FFFFFF","","20sp","40sp"}

    };*/

    public int getPOSITION_INITAL() {
        return POSITION_INITAL;
    }

    public void setPOSITION_INITAL(int POSITION_INITAL) {
        this.POSITION_INITAL = POSITION_INITAL;
    }

    public ArrayList<Story> getStoryList() {
        return storyList;
    }

    public void setStoryList(ArrayList<Story> storyList) {
        this.storyList = storyList;
    }

    private   int PROGRESS_COUNT =0;

    public int getPROGRESS_COUNT() {
        return PROGRESS_COUNT;
    }

    public void setPROGRESS_COUNT(int PROGRESS_COUNT) {
        this.PROGRESS_COUNT = PROGRESS_COUNT;
    }


    private final long[] durations = new long[]{
            500L, 1000L, 1500L, 4000L, 5000L, 1000,
    };

    public Story_View_Activity() {
    }

    public Story_View_Activity(ArrayList<Story> storyList, int POSITION_INITAL) {
        this.storyList = storyList;
        this.POSITION_INITAL = POSITION_INITAL;
    }

    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    pressTime = System.currentTimeMillis();
                    storiesProgressView.pause();
                    return false;
                case MotionEvent.ACTION_UP:
                    long now = System.currentTimeMillis();
                    storiesProgressView.resume();
                    return limit < now - pressTime;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_story_view);
        Bundle bundle = getIntent().getExtras();
        setStoryList((ArrayList<Story>)bundle.getSerializable("Stories"));
        setPOSITION_INITAL(bundle.getInt("POSITION"));
        System.out.println("Position "+ String.valueOf(getPOSITION_INITAL()));
        System.out.println("Story "+ getStoryList().get(0).getAuthor());

        setPROGRESS_COUNT(getStoryList().size());
        storiesProgressView = (StoriesProgressView) findViewById(R.id.stories);
        storiesProgressView.setStoriesCount(getPROGRESS_COUNT());


        storiesProgressView.setStoryDuration(3000);
        // or
        // storiesProgressView.setStoriesCountWithDurations(durations);
        storiesProgressView.setStoriesListener(this);
        counter =  getPOSITION_INITAL();

        storiesProgressView.startStories(counter);
        author =(TextView)findViewById(R.id.author);
        content_phrase= (LinearLayout)findViewById(R.id.content_phrase);
        phrase=(TextView)findViewById(R.id.phrase);
        content_phrase.setOnTouchListener(onTouchListener);
        author.setText(getStoryList().get(counter).getAuthor());
        phrase.setText(getStoryList().get(counter).getPhrase());

        // bind reverse view
        View reverse = findViewById(R.id.reverse);
        reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storiesProgressView.reverse();
            }
        });
        reverse.setOnTouchListener(onTouchListener);

        // bind skip view
        View skip = findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storiesProgressView.skip();
            }
        });
        skip.setOnTouchListener(onTouchListener);


    }
    @Override
    public void onNext() {
        author.setText(getStoryList().get(++counter).getAuthor());
        phrase.setText(getStoryList().get(counter).getPhrase());
    }

    @Override
    public void onPrev() {
        if ((counter - 1) < 0) return;
        author.setText(getStoryList().get(--counter).getAuthor());
        phrase.setText(getStoryList().get(counter).getPhrase());
    }

    @Override
    public void onComplete() {
    }

    @Override
    protected void onDestroy() {
        storiesProgressView.destroy();
        super.onDestroy();
    }



}
