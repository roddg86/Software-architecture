package hexarch.application;

import hexarch.domain.MovieReview;

import java.util.List;

public interface IPrintMovieReviews {
    public void writeMovieReviews(List<MovieReview> movieReviewList);
}
