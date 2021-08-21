package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.Movie;

@Data

public class AfishaManager {

    private int limit = 10;
    private Movie[] movies = new Movie[0];

    public AfishaManager() {

    }

    public  AfishaManager(int limit) {
        this.limit = limit;
    }

    public void addMovie(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

   public Movie[] showLastMovies(int limit) {
        int resultLength;
        if (movies.length > limit) {
            resultLength = limit;
        } else {
            resultLength = movies.length;
        }
       Movie[] lastAdded = new Movie[resultLength];
        for (int i = 0; i < lastAdded.length; i++) {
            int index = movies.length - i - 1;
            lastAdded[i] = movies[index];
        }
        return lastAdded;
   }
}
