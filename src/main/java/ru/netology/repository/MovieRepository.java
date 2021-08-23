package ru.netology.repository;

import ru.netology.domain.Movie;

public class MovieRepository {
    Movie[] movies = new Movie[0];

    public Movie[] findAll() {
        return movies;
    }

    public void save(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public void removeAll() {
        movies = new Movie[0];
    }

    public void removeById(int id) {
        Movie[] tmp = new Movie[movies.length - 1];
        int index = 0;
        for (Movie m : movies) {
            if (m.getId() != id) {
                tmp[index] = movies[index];
                index++;
            }
        }
        movies = tmp;
    }

    public Movie findById(int id) {
        try {
            for (Movie item : movies) {
                if (item.getId() == id) {
                    return item;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }
}



