package ru.sfedu.coursework.main.dao;

import ru.sfedu.coursework.main.beans.Genre;

import java.util.List;

public interface GenreDao {

    public boolean addGenre(Genre genre);
    public boolean updateGenre(List<Genre> genre);
    public boolean removeGenre(List<Genre> genre);
    public List<Genre> getGenreById(int genreId);
    public List<Genre> getGenres();

}
