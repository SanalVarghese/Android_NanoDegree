package android.movieshub.com.movieshub;

import java.util.ArrayList;

/**
 * Created by user on 1/4/16.
 */
public class MovieList {

	public String page;
	public ArrayList<MovieDetails> results;
	public String total_results;
	public String total_pages;
	public int status_code;
	public String status_message;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public ArrayList<MovieDetails> getResults() {
		return results;
	}

	public void setResults(ArrayList<MovieDetails> results) {
		this.results = results;
	}

	public String getTotal_results() {
		return total_results;
	}

	public void setTotal_results(String total_results) {
		this.total_results = total_results;
	}

	public String getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(String total_pages) {
		this.total_pages = total_pages;
	}

	public int getStatus_code() {
		return status_code;
	}

	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}

	public String getStatus_message() {
		return status_message;
	}

	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}
}
