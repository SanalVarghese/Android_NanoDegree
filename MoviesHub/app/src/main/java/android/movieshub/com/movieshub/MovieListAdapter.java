package android.movieshub.com.movieshub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sanal on 1/4/16.
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.RecyclerViewHolders> {

    public ArrayList<MovieDetails> movieList;
    private Context context;

    public MovieListAdapter(Context context, ArrayList<MovieDetails> movieList) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list, parent, false);
        RecyclerViewHolders movieListViewHolder = new RecyclerViewHolders(layoutView, movieList);

        return movieListViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {

        holder.moviename.setText(movieList.get(position).getTitle());
        Picasso.with(context).load(EndPoints.IMAGE_BASE_URL + movieList.get(position).getPoster_path()).into(holder.moviePoster);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView moviePoster;
        private TextView moviename;
        private ArrayList<MovieDetails> movieDetails;


        public RecyclerViewHolders(View itemView, ArrayList<MovieDetails> movieList) {
            super(itemView);
            movieDetails = movieList;
            itemView.setOnClickListener(this);
            moviePoster = (ImageView) itemView.findViewById(R.id.movie_poster);
            moviename = (TextView) itemView.findViewById(R.id.movie_name);
        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(v.getContext(), MoviesDetailActivity.class);

            Bundle bundle = new Bundle();
            bundle.putString(v.getContext().getString(R.string.original_title_key), movieDetails.get(getAdapterPosition()).getOriginal_title());
            bundle.putString(v.getContext().getString(R.string.image_path), movieDetails.get(getAdapterPosition()).getBackdrop_path());
            bundle.putString(v.getContext().getString(R.string.description), movieDetails.get(getAdapterPosition()).getOverview());
            bundle.putString(v.getContext().getString(R.string.average_rating), movieDetails.get(getAdapterPosition()).getVote_average());
            bundle.putString(v.getContext().getString(R.string.total_rating), movieDetails.get(getAdapterPosition()).getVote_count());
            bundle.putString(v.getContext().getString(R.string.title), movieDetails.get(getAdapterPosition()).getTitle());
            bundle.putString(v.getContext().getString(R.string.date), movieDetails.get(getAdapterPosition()).getRelease_date());
            bundle.putString(v.getContext().getString(R.string.poster_key), movieDetails.get(getAdapterPosition()).getPoster_path());
            bundle.putString(v.getContext().getString(R.string.popularity_key), movieDetails.get(getAdapterPosition()).getPopularity());
            intent.putExtras(bundle);
            v.getContext().startActivity(intent);


        }
    }
}
