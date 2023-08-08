package hexarch.adapters;

import hexarch.application.IPrintMovieReviews;
import hexarch.domain.MovieReview;

import java.util.List;

public class ConsolePrinter implements IPrintMovieReviews {
    @Override
    public void writeMovieReviews(List<MovieReview> movieReviewList) {
        movieReviewList.forEach(movieReview -> {
            System.out.println(movieReview.toString());
        });
    }
}
