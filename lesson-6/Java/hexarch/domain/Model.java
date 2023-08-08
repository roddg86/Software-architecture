package hexarch.domain;

import hexarch.application.MovieApp;

public class Model {

    private MovieApp movieApp;

    public Model(MovieApp movieApp) {
        this.movieApp = movieApp;
    }

    public void Run(MovieSearchRequest movieSearchRequest)
    {
        movieApp.accept(movieSearchRequest);
    }

}
