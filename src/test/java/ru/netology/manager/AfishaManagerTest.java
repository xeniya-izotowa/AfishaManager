package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {

    @Test
    void shouldAddMovie() {
        AfishaManager manager = new AfishaManager();
        Movie first = new Movie(1, "Bloodshot", "action", false);
        Movie second = new Movie(2, "Onward", "cartoon", false);

        manager.addMovie(first);
        manager.addMovie(second);

        Movie[] expected = new Movie[]{second, first};
        Movie[] actual = manager.showLastMovies(manager.getLimit());

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowLastMoviesLess10() {
        AfishaManager manager = new AfishaManager(5);
        Movie one = new Movie(1, "Bloodshot", "action", false);
        Movie two = new Movie(2, "Onward", "cartoon", false);
        Movie three = new Movie(3, "Hotel Belgrad", "comedy", false);
        Movie four = new Movie(4, "Gentlemen", "action", false);
        Movie five = new Movie(5, "The Invisible Man", "Horror", false);
        Movie six = new Movie(6, "Trolls. World Tour", "cartoon", false);
        Movie seven = new Movie(7, "Number One", "comedy", false);
        Movie eight = new Movie(8, "Harry Potter", "adventures", false);
        Movie nine = new Movie(9, "Titanic", "drama", false);
        Movie ten = new Movie(10, "Kill Bill", "action", false);
        Movie eleven = new Movie(11, "Candyman", "horror", true);

        manager.addMovie(one);
        manager.addMovie(two);;
        manager.addMovie(three);
        manager.addMovie(four);
        manager.addMovie(five);
        manager.addMovie(six);
        manager.addMovie(seven);
        manager.addMovie(eight);
        manager.addMovie(nine);
        manager.addMovie(ten);
        manager.addMovie(eleven);

        manager.showLastMovies(manager.getLimit());

        Movie[] expected = new Movie[]{eleven, ten, nine, eight, seven};
        //Movie[] actual =

        //assertArrayEquals(expected, actual);

    }


    }
