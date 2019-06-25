package udea.edu.co.concept_test_stories;

import android.support.v4.app.Fragment;
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
import udea.edu.co.concept_test_stories.Historias_Frases_Libros.Stories_Phrases_Fragment;

public class MainActivity extends AppCompatActivity {

    public Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        fragment = new Stories_Phrases_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentStories,fragment).addToBackStack(null).commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
