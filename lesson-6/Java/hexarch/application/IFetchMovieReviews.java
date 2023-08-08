package hexarch.application;

import hexarch.domain.MovieReview;
import hexarch.domain.MovieSearchRequest;

import java.util.List;

public interface IFetchMovieReviews {
    public List<MovieReview> fetchMovieReviews(MovieSearchRequest movieSearchRequest);
}
