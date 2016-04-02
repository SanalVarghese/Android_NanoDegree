package android.movieshub.com.movieshub;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 1/4/16.
 */
public class MoviesRestClient extends BaseRestClient {

	public static Service service;

	public MoviesRestClient() {
		service = retrofit.create(Service.class);
	}

	public void fetchPopularMovieList() {

		Call<MovieList> popularMovieListCall = service.fetchPopularMovieList(Constants.MOVIE_DB_KEY);
		popularMovieListCall.enqueue(new Callback<MovieList>() {
			@Override
			public void onResponse(Call<MovieList> call, Response<MovieList> response) {

				if (null != response && response.body().getStatus_code() != 0) {

					// error case
					GenericError error = new GenericError();
					error.setErrorMessage(response.body().getStatus_message());
					EventBus.getDefault().postSticky(error);

				} else {

					EventBus.getDefault().postSticky(response.body().getResults());

				}

			}

			@Override
			public void onFailure(Call<MovieList> call, Throwable t) {

			}
		});

	}

	public void fetchTopRatedMovieList(){

		Call<MovieList> topRatedMovieListCall = service.fetchTopMovieList(Constants.MOVIE_DB_KEY);
		topRatedMovieListCall.enqueue(new Callback<MovieList>() {
			@Override
			public void onResponse(Call<MovieList> call, Response<MovieList> response) {
				if (null != response && response.body().getStatus_code() != 0) {

					// error case
					GenericError error = new GenericError();
					error.setErrorMessage(response.body().getStatus_message());
					EventBus.getDefault().postSticky(error);

				} else {

					EventBus.getDefault().postSticky(response.body().getResults());

				}
			}

			@Override
			public void onFailure(Call<MovieList> call, Throwable t) {

			}
		});

	}
}
