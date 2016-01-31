package myportfolio.nanodegree.com.udacity_project0;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PortfolioActivity extends AppCompatActivity implements View.OnClickListener {

    private Button spotifyAppButton;
    private Button scoresAppButton;
    private Button libraryAppButton;
    private Button buildItBiggerButton;
    private Button xyzReaderAppButton;
    private Button capstoneProjectButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initializeViews();
    }

    /**
     * This method will initialize all views in this activity and configure listners for initializes views.
     */
    private void initializeViews() {

        spotifyAppButton = (Button) findViewById(R.id.spotify_button);
        scoresAppButton = (Button) findViewById(R.id.scores_app);
        libraryAppButton = (Button) findViewById(R.id.library_app);
        buildItBiggerButton = (Button) findViewById(R.id.build_it_bigger_button);
        xyzReaderAppButton = (Button) findViewById(R.id.xyz_reader_app);
        capstoneProjectButton = (Button) findViewById(R.id.capstone_project);

        setListener();
    }

    /**
     * Configure listners for required views
     */
    private void setListener() {

        spotifyAppButton.setOnClickListener(this);
        scoresAppButton.setOnClickListener(this);
        libraryAppButton.setOnClickListener(this);
        buildItBiggerButton.setOnClickListener(this);
        xyzReaderAppButton.setOnClickListener(this);
        capstoneProjectButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.spotify_button:
                showToast("This button will show my music streaming App");
                break;
            case R.id.scores_app:
                showToast("This button will show my Sports score App");
                break;
            case R.id.library_app:
                showToast("This button will show my library App");
                break;
            case R.id.build_it_bigger_button:
                showToast("This will take you to advanced project topics");
                break;
            case R.id.xyz_reader_app:
                showToast("This will take you to my reader app");
                break;
            case R.id.capstone_project:
                showToast("This will take you to my final project");
                break;
        }

    }

    /***
     * this method will show toast to user.
     *
     * @param message : message to be shown to the user
     */
    public void showToast(String message) {
        Toast.makeText(PortfolioActivity.this, message, Toast.LENGTH_SHORT).show();

    }
}
