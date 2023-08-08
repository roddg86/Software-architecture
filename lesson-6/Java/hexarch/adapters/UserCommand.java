package hexarch.adapters;

import hexarch.application.IFetchMovieReviews;
import hexarch.application.IPrintMovieReviews;
import hexarch.application.IUserInput;
import hexarch.application.MovieApp;
import hexarch.domain.Model;
import hexarch.domain.MovieSearchRequest;

public class UserCommand implements IUserInput {
    private Model model;

    public UserCommand(IFetchMovieReviews fetchMovieReviews, IPrintMovieReviews printMovieReviews) {
        MovieApp movieApp = new MovieApp(fetchMovieReviews, printMovieReviews);
        this.model = new Model(movieApp);
    }

    public void handleUserInput(Object userCommand) {
        model.Run((MovieSearchRequest)userCommand);
    }
}
