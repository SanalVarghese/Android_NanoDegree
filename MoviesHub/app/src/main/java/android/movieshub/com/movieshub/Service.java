package android.movieshub.com.movieshub;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 1/4/16.
 */
public interface Service {

   @GET("popular")
	Call<MovieList> fetchPopularMovieList(@Query("api_key") String apiKey);

    @GET("top_rated")
    Call<MovieList> fetchTopMovieList(@Query("api_key") String apiKey);
}
