package android.movieshub.com.movieshub;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 1/4/16.
 */
public class BaseRestClient {

	protected final Retrofit retrofit;

	public BaseRestClient() {

		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

		retrofit = new Retrofit.Builder()
				.baseUrl(EndPoints.BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.client(client)
				.build();
	}


}
