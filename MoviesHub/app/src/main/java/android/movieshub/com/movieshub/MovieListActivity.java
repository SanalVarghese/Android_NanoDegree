package android.movieshub.com.movieshub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity {

    private GridLayoutManager lLayout;
    RecyclerView rView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        lLayout = new GridLayoutManager(this, getResources().getInteger(R.integer.grid_count));
        rView = (RecyclerView) findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);
        fetchPopularMovies();
    }

    private void fetchPopularMovies() {
        MoviesRestClient moviesRestClient = new MoviesRestClient();
        moviesRestClient.fetchPopularMovieList();
    }

    private void fetchTopRatedMovies() {
        MoviesRestClient moviesRestClient = new MoviesRestClient();
        moviesRestClient.fetchTopRatedMovieList();
    }

    @Override
    protected void onResume() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        super.onResume();
    }


    @Override
    protected void onPause() {

        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        super.onPause();
    }

    @Subscribe
    public void onPopularMoviesFetchCompleted(ArrayList<MovieDetails> movieList) {

        EventBus.getDefault().removeStickyEvent(movieList);
        updateMovieAdapter(movieList);
    }

    @Subscribe
    public void onTopratedMoviesFetchCompleted(ArrayList<MovieDetails> movieList) {

        EventBus.getDefault().removeStickyEvent(movieList);
        updateMovieAdapter(movieList);
    }

    private void updateMovieAdapter(ArrayList<MovieDetails> movieList) {
        MovieListAdapter movieListAdapter = new MovieListAdapter(this, movieList);
        rView.setAdapter(movieListAdapter);
    }

    @Subscribe
    public void errorOnFetching(Error error) {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.overflow_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.top_rated:
                fetchTopRatedMovies();
                break;
            case R.id.most_popular:
                fetchPopularMovies();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
