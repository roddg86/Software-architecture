package hexarch;

import hexarch.adapters.ConsolePrinter;
import hexarch.adapters.MovieReviewsRepo;
import hexarch.adapters.UserCommand;
import hexarch.application.IFetchMovieReviews;
import hexarch.application.IPrintMovieReviews;
import hexarch.application.IUserInput;
import hexarch.application.MovieUser;
import hexarch.domain.MovieSearchRequest;

public class Main {
    public static void main(String[] args) {

        IFetchMovieReviews fetchMovieReviews = new MovieReviewsRepo();
        IPrintMovieReviews printMovieReviews = new ConsolePrinter();
        IUserInput userCommand = new UserCommand(fetchMovieReviews, printMovieReviews);

        MovieUser movieUser = new MovieUser(userCommand);
        MovieSearchRequest starWarsRequest = new MovieSearchRequest("Звездные войны");
        MovieSearchRequest starTreckRequest = new MovieSearchRequest("Звездный путь");

        System.out.println("Отображение рецензий на фильм " + starTreckRequest.getMovieName());
        movieUser.processInput(starTreckRequest);
        System.out.println("Отображение рецензий на фильм " + starWarsRequest.getMovieName());
        movieUser.processInput(starWarsRequest);
    }
}