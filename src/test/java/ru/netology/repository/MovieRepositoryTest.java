package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {

    private Movie[] test;
    MovieRepository repository = new MovieRepository();
    private Movie movie1 =new Movie(1,"Bloodshot","action",false);
    private Movie movie2 =new Movie(2,"Onward","cartoon",false);
    private Movie movie3 =new Movie(3,"Hotel Belgrad","comedy",false);
    private Movie movie4 =new Movie(4,"Gentlemen","action",false);
    private Movie movie5 =new Movie(5,"The Invisible Man","Horror",false);
    private Movie movie6 =new Movie(6,"Trolls. World Tour","cartoon",false);
    private Movie movie7 =new Movie(7,"Number One","comedy",false);

    @Test
    void shouldFindAll() {
        repository.save(movie1);
        repository.save(movie2);
        repository.save(movie3);

        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{movie1, movie2, movie3};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSave() {
        repository.save(movie7);
        repository.save(movie4);

        Movie[] expected = new Movie[]{movie7, movie4};
        Movie[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        repository.save(movie1);
        repository.save(movie2);

        repository.removeById(1);

        Movie[] expected = new Movie[]{movie1};
        Movie[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindById() {
        repository.save(movie7);
        repository.save(movie6);
        repository.save(movie4);
        repository.save(movie2);
        repository.save(movie5);

        Movie expected = null;
        Movie actual = repository.findById(1);

        assertEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        repository.save(movie7);
        repository.save(movie6);
        repository.save(movie4);
        repository.save(movie2);
        repository.save(movie5);

        Movie expected = new Movie(2,"Onward","cartoon",false);
        Movie actual = repository.findById(2);

        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.save(movie3);
        repository.save(movie6);
        repository.save(movie1);
        repository.save(movie2);
        repository.save(movie4);

        repository.removeAll();

        Movie[] expected = new Movie[0];
        Movie[] actual = repository.findAll();
    }

}