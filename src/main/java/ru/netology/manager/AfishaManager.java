package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

@Data

public class AfishaManager {
    private MovieRepository repository;
    private int limit = 10;
    private Movie[] movies = new Movie[0];

    public AfishaManager() {

    }

    public AfishaManager(MovieRepository repository) {
        this.repository = repository;
    }
    public  AfishaManager(int limit) {
        this.limit = limit;
    }

    public void addMovie(Movie movie) {
        repository.save(movie);
    }

   public Movie[] showLastMovies(int limit) {
        Movie[] films = new Movie[limit];
        Movie[] tmp = repository.findAll();
        for (int i = 0; i < films.length; i++) {
            int index = tmp.length - i - 1;
            films[i] = tmp[index];
        }
        return films;
   }

   public Movie[] getAll() {
        return repository.findAll();
   }
}
