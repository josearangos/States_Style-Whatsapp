package udea.edu.co.concept_test_stories;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import jp.shts.android.storiesprogressview.StoriesProgressView;

public class MainActivity extends AppCompatActivity implements StoriesProgressView.StoriesListener{


    private StoriesProgressView storiesProgressView;
    private ImageView image;
    private TextView author,phrase;
    private LinearLayout content_phrase;

    int n=4, m=7;

    private int counter = 0;
    private final int[] resources = new int[]{
            R.drawable.sample1,
            R.drawable.sample2,
            R.drawable.sample3,
            R.drawable.sample4,
            R.drawable.sample5,
            R.drawable.sample6,
    };

    private  String[][] resources_Phrases ={
            {"Aristóteles","El fin de la ciencia especulativa es la verdad, y el fin de la ciencia práctica es la acción.","#00574B","#FFFFFF","","20sp","40sp"},
            {"Pedro","Frase 2.","#00574B","#FFFFFF","","20sp","40sp"},
            {"Juan","Frase 3","#00574B","#FFFFFF","","20sp","40sp"},
            {"Sneider","Frase 4","#00574B","#FFFFFF","","20sp","40sp"},
            {"Stiven","Frase 5","#00574B","#FFFFFF","","20sp","40sp"}

    };

    private   int PROGRESS_COUNT = resources_Phrases.length;


    private final long[] durations = new long[]{
            500L, 1000L, 1500L, 4000L, 5000L, 1000,
    };

    long pressTime = 0L;
    long limit = 500L;

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
        setContentView(R.layout.activity_main);

        storiesProgressView = (StoriesProgressView) findViewById(R.id.stories);
        storiesProgressView.setStoriesCount(PROGRESS_COUNT);
        storiesProgressView.setStoryDuration(3000L);
        // or
        // storiesProgressView.setStoriesCountWithDurations(durations);
        storiesProgressView.setStoriesListener(this);
//        storiesProgressView.startStories();
        counter = 0;
        storiesProgressView.startStories(counter);

        image = (ImageView) findViewById(R.id.image);
        author =(TextView)findViewById(R.id.author);
        content_phrase= (LinearLayout)findViewById(R.id.content_phrase);
        phrase=(TextView)findViewById(R.id.phrase);
        content_phrase.setOnTouchListener(onTouchListener);
        //image.setImageResource(resources[counter]);
        author.setText(resources_Phrases[counter][0]);
        phrase.setText(resources_Phrases[counter][1]);


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
        //image.setImageResource(resources[++counter]);
        author.setText(resources_Phrases[++counter][0]);
        phrase.setText(resources_Phrases[counter][1]);
    }

    @Override
    public void onPrev() {
        if ((counter - 1) < 0) return;
        //image.setImageResource(resources[--counter]);
        author.setText(resources_Phrases[--counter][0]);
        phrase.setText(resources_Phrases[counter][1]);
    }

    @Override
    public void onComplete() {
    }

    @Override
    protected void onDestroy() {
        // Very important !
        storiesProgressView.destroy();
        super.onDestroy();
    }
}
