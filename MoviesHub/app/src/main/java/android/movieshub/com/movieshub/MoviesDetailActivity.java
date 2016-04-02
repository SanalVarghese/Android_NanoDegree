package android.movieshub.com.movieshub;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MoviesDetailActivity extends AppCompatActivity {
    private String originalTitle;
    private String title;
    private String imageUrl;
    private ImageView moviePic;
    private TextView originalTitleText;
    private TextView overviewText;
    private String overview;
    private String avgRating;
    private String totalRating;
    private ImageView thumbImageview;
    private TextView ratTextView;
    private TextView releaseDateText;
    private String releaseDate;
    private String posterUrl;
    private TextView popularityTextView;
    private String popularityCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle extras = getIntent().getExtras();
        if (null != extras) {
            originalTitle = (String) extras.get("orginalTitle");
            title = (String) extras.get("title");
            imageUrl = (String) extras.get("imageUrl");
            overview = (String) extras.get("description");
            avgRating = (String) extras.get("avgRating");
            totalRating = (String) extras.get("totalRating");
            releaseDate = (String) extras.get("date");
            posterUrl = (String) extras.get("poster");
            popularityCount = (String) extras.get("popularity");

        }
        getSupportActionBar().setTitle(title);
        initViews();
        loadInitialData();
    }

    private void initViews() {
        moviePic = (ImageView) findViewById(R.id.movie_poster);
        thumbImageview = (ImageView) findViewById(R.id.thumb_imageview);
        overviewText = (TextView) findViewById(R.id.description);
        originalTitleText = (TextView) findViewById(R.id.orginal_title);
        ratTextView = (TextView) findViewById(R.id.rating_text);
        releaseDateText = (TextView) findViewById(R.id.release_date);
        popularityTextView = (TextView) findViewById(R.id.popularity_count);
    }

    private void loadInitialData() {

        Picasso.with(this).load(EndPoints.IMAGE_BASE_URL + imageUrl).into(moviePic);
        Picasso.with(this).load(EndPoints.MOVIE_THUMB_URL + posterUrl).into(thumbImageview);
        overviewText.setText(overview);
        originalTitleText.setText(originalTitle);
        ratTextView.setText(avgRating + "/" + totalRating);
        releaseDateText.setText(releaseDate);
        popularityTextView.setText(popularityCount);
    }

}
