package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

public class AfishaManagerTest {
    @Mock
    private MovieRepository repository;
    @InjectMocks
    private AfishaManager manager;

    Movie one = new Movie(1, "Bloodshot", "action", false);
    private Movie two = new Movie(2, "Onward", "cartoon", false);
    private Movie three = new Movie(3, "Hotel Belgrad", "comedy", false);
    private Movie four = new Movie(4, "Gentlemen", "action", false);
    private Movie five = new Movie(5, "The Invisible Man", "Horror", false);
    private Movie six = new Movie(6, "Trolls. World Tour", "cartoon", false);
    private Movie seven = new Movie(7, "Number One", "comedy", false);
    private Movie eight = new Movie(8, "Harry Potter", "adventures", false);
    private Movie nine = new Movie(9, "Titanic", "drama", false);
    private Movie ten = new Movie(10, "Kill Bill", "action", false);
    private Movie eleven = new Movie(11, "Candyman", "horror", true);

    @Test
    void shouldAddMovie() {
        Movie[] returned = new Movie[]{five};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(five);

        manager.addMovie(five);

        Movie[] expected = new Movie[]{five};
        Movie[] actual = manager.getAll();

        assertArrayEquals(expected, actual);

        verify(repository).save(five);
    }

    @Test
    void shouldShowLastAdded() {
        Movie[] returned = new Movie[]{eleven, five, one, two, six};
        doReturn(returned).when(repository).findAll();

        Movie[] expected = new Movie[]{six, two, one, five, eleven};
        Movie[] actual = manager.showLastMovies(5);

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}
