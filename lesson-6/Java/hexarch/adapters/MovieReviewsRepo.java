package hexarch.adapters;

import hexarch.application.IFetchMovieReviews;
import hexarch.domain.MovieReview;
import hexarch.domain.MovieSearchRequest;

import java.util.*;

public class MovieReviewsRepo implements IFetchMovieReviews {
    private Map<String, List<MovieReview>> movieReviewMap;

    public MovieReviewsRepo() {
        initialize();
    }

    public List<MovieReview> fetchMovieReviews(MovieSearchRequest movieSearchRequest) {

        return Optional.ofNullable(movieReviewMap.get(movieSearchRequest.getMovieName()))
                .orElse(new ArrayList<>());
    }

    private void initialize() {
        this.movieReviewMap = new HashMap<>();
        movieReviewMap.put("Звездные войны", Collections.singletonList(new MovieReview("1", 7.5, "Хороший")));
        movieReviewMap.put("Звездный путь", Arrays.asList(new MovieReview("1", 9.5, "Отличный"), new MovieReview("1", 8.5, "Хороший")));
    }
}
